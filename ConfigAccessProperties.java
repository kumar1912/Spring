package no.fellesdata.util.inspectionlog;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import no.fellesdata.util.IniFile;
import no.fellesdata.util.trace.Trace;


/**
 * Class for reading all the configuration related to transaction router from transactionRouter.ini
 * 
 * @author vinaya.prasad
 *
 */
public  class ConfigAccessProperties {
	//public static void main( String[] args ){
	final static String iniFileName = "inspectionLogs/inspectionLog.ini";
	static IniFile iniFile;
	private static ConfigAccessProperties instance = null;


	/**
	 * Default Constructor
	 * @throws IOException
	 */
	private ConfigAccessProperties() throws IOException{
		Trace.entry(this,"ConfigAccessProperties");
		try {
			Trace.trace(this,"Loading inspectionLog.ini");
			iniFile = new IniFile(iniFileName, iniFileName);
			Trace.trace(this,"Sucessfully loaded inspectionLog.ini");
		} catch (IOException e) {
			Trace.trace(this,"Unable to load file inspectionLog.ini "+e.getMessage());
		}
		Trace.exit(this,"ConfigAccessProperties", null);
	}


	/**
	 * Method to get the value of the specific key in property file
	 * @param key
	 * @return
	 */
	public String getProperty(String key) {
		return iniFile.getProperty(key);
	}

	/**
	 * Method to get the instance of this object
	 * @return
	 */
	public static ConfigAccessProperties getInstance() {
		Trace.entry("ConfigAccessProperties","getInstance");
		if(instance == null) {
			try {
				instance = new ConfigAccessProperties();
			} catch (IOException e) {
				Trace.trace("ConfigAccessProperties","Unable to load file inspectionLog.ini "+e.getMessage());
			}
		}
		Trace.exit("ConfigAccessProperties","ConfigAccessPgetInstanceroperties", null);
		return instance;
	}
	/**
	 * Test Method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
	}
}
