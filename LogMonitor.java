/*--- formatted by Jindent 2.1, (www.c-lab.de/~jindent) ---*/

package no.fellesdata.util.logger;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;
import java.util.Vector;

import com.edb.fs.enterprise.km.srv.common.service.trace.WebServicesLogger;

import no.fellesdata.util.FDProperties;
import no.fellesdata.util.IniFile;

/**
 * The LogMonitor is started as a standalone thread when Log.init() is called.
 * If there are no files in ini\logger logging is regareded to disabled
 * and the thread will not be started. The LogMonitor will cleanup references to
 * Threads that are terminated.   And will monitor changes in any ini\logger file.
 * If a change is detected,  the changed INI file will be read in,  and changes
 * will take effect. The LogMonitor thread will run 10. second.
 *
 * @author     Jan-Petter Kruger
 * @version    $Revision: 1.5 $
 */
public class LogMonitor extends Thread {
	private Vector iniFiles = null;
	private boolean stopInd = false;
	private String reloadFileName = "ReLoad.ini";
	/**
	 * Constructor. Calls Thread constructor,  setting thread name
	 * to LogMonitor.
	 */
	public LogMonitor() {
		super("LogMonitor");
	}


	/**
	 * Sets stop flag to indicate that run thread should stop
	 */
	public void stopMonitor() {
		stopInd = true;
	}

	/**
	 * Overloading void run() in Thread,  This function is invoked
	 * when the thread is started.
	 */
	public void run() {

		// Trace.entry(this,"run");
		while ((this.stopInd == false) && (readConfig())) {
			cleanup();
			LogMaster.cleanup();
			try {
				this.sleep(10000);    // Sleep 10 seconds
			} catch (java.lang.InterruptedException e) {}
		}
		LogMaster.removeAllLoggers();
		iniFiles = null;

		// Trace.exit(this,"run",null);
	}

	/**
	 * Reads configuration files under ini\log.
	 * @return true if INI files exists,  otherwise false
	 */
	private boolean readConfig() {

		// Trace.entry(this,"readConfig");
		String iniPath = FDProperties.getIniPath() + File.separator + "logger";

		// Trace.trace(this, "Looking for inifiles in path:" +iniPath);
		String fileList[];
		int    noofFiles;
		File   ifp = new File(iniPath);

		setAllKeepFlags(false);
		if (ifp.isDirectory() == false) {

			// Trace.exit(this,"readConfig",new Boolean(false));
			return false;
		}
		fileList = ifp.list(new no.fellesdata.util.trace.IniFileFilter());
		noofFiles = fileList.length;
		if (noofFiles > 0) {
			for (int i = 0; i < noofFiles; i++) {

				/*
				 *  Modified code for release 1.4:  
				 *  New requirement is that: Even if any of the ini file is modified by admin, without being notified the modified files should not be reloaded
				 *  Admin will notify the system by sending a signal from command prompt, once this signal is send then a file by name "ReLoad.ini" will be created
				 *  in rtsHome/fdk/inirtslink/logger/ folder
				 *  So if any of the ini file is modified and if the "ReLoad.ini" exists then system has to reload the modified ini, or else modified ini content should not
				 *  be reloaded.
				 */

				processIniFile(new File(iniPath + File.separator + fileList[i]),ifp);
			}
		} else {
			LogMaster.removeAllLoggers();
		}

		// Trace.exit(this,"readConfig",new Boolean(true));
		return true;
	}

	/**
	 * Process INI file if needed
	 * @param file File object for current INI file
	 */
	private void processIniFile(File file, File ifp) {

		// Trace.entry(this,"processIniFile");
		IniFile prop;
		String  loggerType;

		if ((file.canRead()) && (reProcessIniFile(file,ifp)) ) {
			storeIniFileInfo(file);
			//
			// Read the Ini File and construct the logger instance
			//
			try {
				String iniFileName = file.getName();

				// Trace.trace(this, "Process file : " + iniFileName);
				prop = new IniFile("logger" + File.separator + iniFileName, "");
				loggerType = prop.getProperty("Logger");
				Logger logger = null;

				try {
					Class[]     initArgsClass = new Class[] {
							IniFile.class
					};
					Object[]    initArgs = new Object[] {
							prop
					};
					Constructor initArgsConstructor;
					Class       loggerClass = Class.forName(loggerType);

					initArgsConstructor = loggerClass.getConstructor(initArgsClass);
					logger = (Logger) createObject(initArgsConstructor, initArgs);
				} catch (Exception ex) {
					System.out.println(ex);
				}
				if ((logger != null) && (logger.isWorking())) {
					LogMaster.installLogger(iniFileName, logger);
				} else if (logger != null) {
					LogMaster.removeLogger(iniFileName);
				}
			} catch (IOException e) {
				System.out.println("Exception : " + e);
			}
		}

		// Trace.exit(this,"processIniFile",null);
	}

	/**
	 * Method for creating an instance of a Logger object.
	 * Used as a helper method to make the process of adding new Logger classes as
	 * easy as possible.
	 *
	 * @param constructor A constructor reference
	 * @param arguments   arguments to send to the specified constructor
	 * @return Logger object
	 */
	private static Object createObject(Constructor constructor, Object[] arguments) {
		Object object = null;

		try {
			object = constructor.newInstance(arguments);
			return object;
		} catch (InstantiationException e) {
			System.out.println(e);
		} catch (IllegalAccessException e) {
			System.out.println(e);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		} catch (InvocationTargetException e) {
			System.out.println(e);
		}
		return object;
	}

	/**
	 * Modified code for release 1.4:  
	 *  New requirement is that: Even if any of the ini file is modified by admin, without being notified the modified files should not be reloaded
	 *  Admin will notify the system by sending a signal from command prompt, once this singal is send then a file by name "ReLoad.ini" will be created
	 *  So if any of the ini file is modified and if the "ReLoad.ini" exists then system has to reload the modified ini, or else modified ini content should not
	 *  be reloaded. 
	 *  
	 * @param file : file to be re porcessed
	 * @param directory : gives the current directory
	 * @return true or false
	 */
	private boolean reProcessIniFile(File file, File directory) {

		// Trace.entry(this,"reProcessIniFile");
		Enumeration                          e;
		no.fellesdata.util.trace.IniFileInfo info;
		boolean                              ret = true;
		if (iniFiles != null) {
			String name = file.getName();
			e = iniFiles.elements();
			while ((e.hasMoreElements()) && (ret == true)) {
				info = (no.fellesdata.util.trace.IniFileInfo) e.nextElement();
				if (name.compareTo(info.getName()) == 0) {
					if (info.getTimeModified() == file.lastModified()) {
						ret = false;
						info.setKeep(true);    // Keep existing info and don't reload.
					}else if(!checkAndDeleteIfReloadFileExistInDir( directory)){
						// if ReLoad.ini file does not exists in the directory then don't reload the ini file even if it is modified.
						ret = false;
						info.setKeep(true);   
					}
				}
			}
		}
		// Trace.exit(this,"reProcessIniFile", new Boolean(ret));
		return ret;
	}

	/**
	 * This method is used for checking if the modified ini file can be re process or not
	 * Once the INI file is changed manually by Admin then from Command prompt a signal has to be triggered, the triggering signal will create a temporaryfile in the location
	 * if the file is there then the code will assume that we need to reload the ini file , if not then reload of ini will not happen even if the file is modified.
	 * ReLoad.ini : will be the file that will be created when Admin sends signal from Command prompt, once this is read this file has to be deleted.
	 * 
	 * if the file exists then return true and then delete the file, if not then return false.
	 */

	private boolean checkAndDeleteIfReloadFileExistInDir(File directory){
		boolean val;
		File f = new File(directory+File.separator+reloadFileName);
		if(f.exists() && !f.isDirectory()) { 
			val = true;
			// Delete the file if exists.
			f.delete();
			// reload configurations for webservice log
			/**
			 * This check is performed because for RTSLink flow we don't add core wrapper and log4j as dependencies, 
			 * but calling below lines will invoke those dependencies, hence to prevent this we are adding this check
			 * checking rtslink will help check both places, one in rtslink user as well as in inirtslink string
			 */
			String absolutePath = f.getAbsolutePath();
			String filePath = absolutePath. substring(0,absolutePath.lastIndexOf(File.separator));
			System.out.println("filePath : "+filePath);
			if(!filePath.toLowerCase().contains("rtslink")){
				WebServicesLogger webServicesLogger = new WebServicesLogger();
				webServicesLogger.init();
			}
		}else{
			val = false;
		}
		return val;
	}

	/**
	 * Stores inifile information in iniFiles.  Any existing IniFileInfo objects representing
	 * the current file will be removed from iniFiles.
	 * @param file File object for current INI file.
	 */
	private void storeIniFileInfo(File file) {

		// Trace.entry(this, "storeIniFileInfo");
		no.fellesdata.util.trace.IniFileInfo info;
		int                                  i;
		int                                  size;
		String                               name;
		boolean                              stored = false;

		if (iniFiles == null) {
			iniFiles = new Vector();
		}
		name = file.getName();
		for (i = 0, size = iniFiles.size(); (i < size) && (!stored); i++) {
			info = (no.fellesdata.util.trace.IniFileInfo) iniFiles.elementAt(i);
			if (name.compareTo(info.getName()) == 0) {
				iniFiles.setElementAt(new no.fellesdata.util.trace.IniFileInfo(file), i);
				stored = true;
			}
		}
		if (!stored) {
			iniFiles.addElement(new no.fellesdata.util.trace.IniFileInfo(file));

			// Trace.exit(this, "storeIniFileInfo",null);
		}
	}

	/**
	 * Sets keep flag in all IniFileInfo objects in iniFiles to the specified keepFlag
	 * @param keepFlag to set in IniFileInfo
	 */
	private void setAllKeepFlags(boolean keepFlag) {

		// Trace.entry(this,"setAllKeepFlags");
		no.fellesdata.util.trace.IniFileInfo info;
		int                                  i, size;

		if (iniFiles != null) {
			for (i = 0, size = iniFiles.size(); i < size; i++) {
				info = (no.fellesdata.util.trace.IniFileInfo) iniFiles.elementAt(i);
				info.setKeep(keepFlag);
			}
		}

		// Trace.exit(this,"setAllKeepFlags",null);
	}

	/**
	 * Clean up iniFiles Vector.  Remove where keepFlag is false.
	 */
	private void cleanup() {

		// Trace.entry(this, "cleanup");
		no.fellesdata.util.trace.IniFileInfo info;
		int                                  i, size;

		if (iniFiles != null) {
			for (i = 0, size = iniFiles.size(); i < size; i++) {
				info = (no.fellesdata.util.trace.IniFileInfo) iniFiles.elementAt(i);
				if (!info.getKeep()) {
					LogMaster.removeLogger(info.getName());
					iniFiles.removeElementAt(i);
					size--;
					i--;
				}
			}
			iniFiles.trimToSize();
		}

		// Trace.exit(this, "cleanup",null);
	}

}
