package no.fellesdata.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import no.fellesdata.util.trace.Trace;


/**
 * Class for reading all the configuration related to transaction router from transactionRouter.ini
 * 
 * @author vinaya.prasad
 *
 */
public  class ReadMqProperties {
	//public static void main( String[] args ){
	final static String iniFileName = "mqSettings.ini";
	static IniFile iniFile;
	private static ReadMqProperties instance = null;


	/**
	 * Default Constructor
	 * @throws IOException
	 */
	private ReadMqProperties() throws IOException{
		Trace.entry(this, "ReadMqProperties");
		try {
			Trace.trace(this, "Loading mqSettings.ini");
			iniFile = new IniFile(iniFileName, iniFileName);
			Trace.trace(this, "Sucessfully loaded transactionRouter.ini");
		} catch (IOException e) {
			Trace.trace(this, e.getMessage());
		}
		Trace.exit(this, "ReadMqProperties",null);
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
	public static ReadMqProperties getInstance() {
		if(instance == null) {
		Trace.entry("ReadMqProperties", "getInstance");
			try {
				instance = new ReadMqProperties();
			} catch (IOException e) {
				Trace.trace("ReadMqProperties", e.getMessage());
			}
		}
		Trace.exit("ReadMqProperties", "getInstance",null);
		return instance;
	}
}
