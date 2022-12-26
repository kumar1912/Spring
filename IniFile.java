/*--- formatted by Jindent 2.1, (www.c-lab.de/~jindent) ---*/

// Source file: d:/fdk.dev/no/fellesdata/util/IniFile.java
package no.fellesdata.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Enumeration;
import java.util.Properties;

import no.fellesdata.util.trace.Trace;

/**
 * Generic class for reading .INI files.  The FDPropertis.getIniPath() function
 * is used to descide the path for the INI file.
 *
 * @author     Dag Helge Sønderland
 * @version    $Revision: 1.17 $
 * Revisions :
 * $Log: IniFile.java  $
 * Revision 1.17 2004/05/26 12:53:15CEST z2121rl 
 * Changed osName-test to new standard
 * Revision 1.16 2002/11/14 15:06:44CET z2828ds
 *
 * Revision 1.15  2002/11/13 13:28:36Z  z2828ds
 * Trace properties in IniFile constructor
 * Revision 1.14  2002/02/22 09:36:26Z  z2828ds
 * Revision 1.12  2001/11/21 12:55:47Z  z2890ds
 * Revision 1.11  2001/10/21 16:02:34Z  z2828ds
 * Bug Fix .    Crash in getTestFile() fixed.
 * Revision 1.10  2001/04/26 11:06:32Z  z2828ds
 * Create inifile if it does'nt exist
 * Revision 1.9  2001/04/17 11:00:16Z  z2828ds
 * Changed search order for Ini files
 * Revision 1.8  2001/02/21 17:44:33Z  z2828ds
 * Revision 1.7  2001/02/19 10:44:31Z  z2828ds
 * IniFile search order
 * Revision 1.6  2001/01/19 08:56:53Z  z2828ds
 * Expand environment in IniFile
 * Revision 1.5  2000/12/07 15:19:52Z  z2828ds
 * Added contents in the setProperty method
 * Revision 1.4  1999/02/15 14:20:04Z  z2828ds
 * Revision 1.3  1999/02/10 14:15:51  z2828ds
 * Revision 1.2  1999/02/10 13:45:19  z2828ds
 * Revision 1.1  1999/02/03 19:27:49  z2828ds
 * Initial revision
 */
public class IniFile {
    private Properties prop;

    // private String fileName;
    private String     header;
    private File       file;

    /**
     * Creates instance of IniFile.
     *
     * The constructor will look for the specified IniFile in the following locations, in
     * the specified order.  The first match (where the file exists) will be used.
     *
     *
     * <OL>
     * <li>If the property no.fellesdata.path.ini is defined the value will be returned
     * <li>If the environment variable KM_INI eksist $KM_INI will be returned
     * <li>If the environment variable KM_HOME eksist $KM_HOME/ini will be returned (if $KM_HOME/ini exists)
     * <li>If the path ./ini exists in the current directory the absoulute path for this directory will be returned
     * <li>If Windows NT "c:\\ini" will be returned,  otherwise the value of user.home (which should always exist) + "ini" will be returned
     * </OL>
     *
     * Constructor.  The specified INI file will be loaded.
     * @exception java.io.IOException
     * If error reading from ini file.
     * @roseuid 36AC4DFA037E
     */
    public IniFile(String fileName, String header) throws java.io.IOException {
    	System.out.println(".........IniFile...............entry");
        String method = "IniFile";
        System.out.println(this+method);
        String iniPath = FDProperties.getIniPath();

        // this.fileName = iniPath + File.separator + fileName;
        this.file = getIniFile(fileName);
        System.out.println(".......IniFile.................."+this.file);
        if  (file == null) {
            //No such Ini file found
            String path = FDProperties.getIniPath();
            if  (path == null) {
                path = "";
            }
            path += (File.separator + fileName);

            file = new File(path);
            file.createNewFile();
        }

        this.header = header;
        prop = new Properties();
        this.load();


        // Trace inifile content
        System.out.println("Properties in " + file.getAbsolutePath() + ":");
        Enumeration keys = prop.keys();
        Enumeration elements = prop.elements();
        while (keys.hasMoreElements()) {
            String key = (String)keys.nextElement();
            String element = (String)elements.nextElement();
            StringBuffer bl = new StringBuffer("   ");
            for (int i = key.length(); i < 20; i++) {
                bl.append(' ');
            }

            System.out.println(this+key + ":" + bl.toString() + element);
        }

        System.out.println(this+method+null);
        System.out.println(".........IniFile...............exit");
    }

    /**
     * Method
     *
     *
     * @param fileName
     *
     * @return
     *
     */
    private File getIniFile(String fileName) {
        String method = "getIniFile";

        System.out.println(this+ method);
        File testFile = null;

        for (int i = 0; i < 5; i++) {
            testFile = getTestFile(fileName, i);
            if ((testFile != null) && (testFile.exists())) {
                break;
            }
            testFile = null;
        }
        System.out.println(this+ method+ ((testFile != null) ? testFile.getAbsolutePath() : ""));
        return testFile;
    }

    /**
     * Gest a File object for the specified fileName
     *
     *
     * @param fileName fileName
     * @param index index for location of the file (search order)
     *
     * @return File object if file found at the specified location (by index),  otherwise null
     *
     */
    private File getTestFile(String fileName, int index) {
        String method = "getTestFile";
        System.out.println(this+method);
        System.out.println(this+"Index : " + index);
        File       ret = null;
        String     path;
        Properties sysProp;
        switch (index) {
        case 0:
            sysProp = System.getProperties();
            path = sysProp.getProperty("no.fellesdata.path.ini");
            if (path != null) {
                ret = new File(path + File.separator + fileName);
            }
            break;
        case 3:
            File iniDir = new File("ini");

            if (iniDir.isDirectory()) {
                path = iniDir.getAbsolutePath() + File.separator + fileName;
                ret = new File(path);
            }
            break;
        case 1:
            try {
                String fdkIni = Environment.getEnvironmentVar("KM_INI");

                if (fdkIni != null) {
                    path = fdkIni + File.separator + fileName;
                    ret = new File(path);
                    System.out.println(this+ " KM_INI path : " + path);
                }
            } catch (LibraryNotLoadedException e) {}
            break;
        case 2:
            try {
                String fdkHome = Environment.getEnvironmentVar("KM_HOME");

                if (fdkHome != null) {
                    path = fdkHome + File.separator + "ini" + File.separator + fileName;
                    System.out.println(this+ "path : " + path);
                    ret = new File(path);
                }
            } catch (LibraryNotLoadedException e) {
            	 System.out.println("LibraryNotLoadedException");
            }
            break;
        case 4:
            sysProp = System.getProperties();
            String osName = sysProp.getProperty("os.name");

            path = null;
            if ((osName != null) && (osName.toUpperCase().startsWith("WINDOWS"))) {
                path = "c:\\ini";
            } else {
                path = sysProp.getProperty("user.home");
                if ((path == null) || (path.length() == 0)) {
                    path = File.separator;
                } else {
                    if (path.endsWith(file.separator) == false) {
                    	path += File.separator+"fdk"+File.separator;
                    }
                    path += "ini";
                }
            }
            path += (File.separator + fileName);
            ret = new File(path);
            break;
        default:
            ret = null;
            break;
        }

        System.out.println(this+method+ret);

        return ret;
    }

    /**
     * Set property.  Overwtites existing value if key exists.
     * @param key Property key
     * @param p2 Property value
     * @roseuid 36AC4D2302CB
     */
    public void setProperty(String key, String value) {
        prop.setProperty(key, value);
    }

    /**
     * Gets expanded value
     *
     *
     * @param propValue Propery value
     *
     * @return
     *
     */
    private String expandValue(String propValue) {
        if (propValue != null) {

            // Look for environment varaibles.
            int startIndex = -1;
            int endIndex = -1;

            do {
                startIndex = propValue.indexOf('%', 0);
                endIndex = (startIndex != -1) ? propValue.indexOf('%', startIndex + 1) : -1;
                if ((startIndex != -1) && (endIndex != -1)) {
                    String envVar = propValue.substring(startIndex + 1, endIndex);
                    String envValue = getEnv(envVar);

                    if (envValue == null) {
                        break;
                    } else {
                        StringBuffer sb = new StringBuffer(propValue.substring(0, startIndex));

                        sb.append(envValue);
                        sb.append(propValue.substring(endIndex + 1));
                        propValue = sb.toString();
                    }
                }
            } while ((startIndex != -1) && (endIndex != -1));
        }
        return propValue;
    }

    /**
     * Get stored value for property identified by key.
     * @param key Property key
     * @param key Property value to be returned if property key does not exist.
     * @return Returns Property value.  If Property does exists null
     * will be returned.
     */
    public String getProperty(String key, String defaultValue) {
        String propValue = prop.getProperty(key, defaultValue);

        return expandValue(propValue);
    }

    /**
     * Get stored value for property identified by key.
     * @param key Property key
     * @return Returns Property value.  If Property does exists null
     * will be returned.
     * @roseuid 36AC4D48030A
     */
    public String getProperty(String key) {
        return expandValue(prop.getProperty(key));
    }
    
    public Properties returnProperties(){
    	return prop;
    }

    /**
     * Stores all properties held by the IniFile object to the to INI file specified in constructor.  The existing INI file will be overwritten.
     * @exception java.io.IOException
     * If error writing to Inifile.
     * @roseuid 36AC4D5C002E
     */
    public void store() throws java.io.IOException {
        FileOutputStream os = new FileOutputStream(file);

        prop.store(os, header);
        os.close();
    }

    /**
     * Reset all Properties held by the IniFile object and reloads
     * properties for the INI file specified in constructor.
     * @exception java.io.IOException
     * If error loading from Inifile.
     * @roseuid 36AC4D6D006E
     */
    public void load() throws java.io.IOException {
        FileInputStream is = new FileInputStream(file);

        prop.clear();
        prop.load(is);
        is.close();
    }

    /**
     * Returns an Enumeration for all property keys held by the inifile object.
     * @return Enumeration for keys in property
     * @roseuid 36AC4D7800E2
     */
    public Enumeration keys() {
        return prop.keys();
    }

    /**
     * Returns an Enumeration for all Property values held by the Inifile object.
     *
     * @return Enumeration for values in property
     * @roseuid 36AC4DBA02AA
     */
    public Enumeration values() {
        return prop.elements();
    }

    /**
     * Method
     *
     *
     * @param env
     *
     * @return
     *
     */
    private String getEnv(String env) {
        String ret;

        try {
            ret = Environment.getEnvironmentVar(env);
        } catch (LibraryNotLoadedException e) {
            ret = null;
        }
        return ret;
    }

    /**
     * Method
     *
     *
     * @param varName
     *
     * @return
     *
     */
    private native String getEnvironmentVar(String varName);

    /**
     * Test Program
     *
     *
     * @param argv Command line arguments,  but not used
     *
     * @exception Exception If any error occurs
     *
     */
    public static void main(String[] argv) throws Exception {
        Trace.init();
        Thread.currentThread().sleep(2000);
        IniFile ini = new IniFile("applmgr.ini", "applmgr.ini");
        String  val = ini.getProperty("DHSTEST");

        System.out.print("DHSTEST : " + val);
    }

    public File getFile() {
        return this.file;
    }

}


/*--- formatting done in "Fellesdata AS Java Convention" style on 02-19-2001 ---*/

