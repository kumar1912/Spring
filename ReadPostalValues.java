package no.fellesdata.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import no.fellesdata.util.trace.Trace;

/**
 * Class for reading all the configuration related to PostalValues.
 * 
 * @author vinaya.prasad
 *
 */
public class ReadPostalValues {
	final static String iniFileName = "postalValues.ini";
	static IniFile iniFile;
	private static ReadPostalValues instance = null;


	/**
	 * Default Constructor
	 * @throws IOException
	 */
	private ReadPostalValues() throws IOException{
		Trace.entry(this, "ReadPostalValues");
		try {
			Trace.trace(this, "Loading postalValues.ini");
			iniFile = new IniFile(iniFileName, iniFileName);
			Trace.trace(this, "Sucessfully loaded postalValues.ini");
		} catch (IOException e) {
			Trace.trace(this, e.getMessage());
		}
		Trace.exit(this, "ReadPostalValues",null);
	}


	/**
	 * Method to get the value of the specific key in ini file
	 * @param key
	 * @return
	 */
	public String getProperty(String key) {
		return iniFile.getProperty(key);
	}

	private Properties getKeyValues(){
		return iniFile.returnProperties();
	}

	/**
	 * Method to get the key of the specific value in ini file
	 * 
	 * @param postOffice
	 * @return
	 */
	public String getKeyFromValue(String postOffice){
		Map<String, String> mapForPostNo = new HashMap<String,String>();
		Iterator<Entry<Object, Object>> iterator = ReadPostalValues.getInstance().getKeyValues().entrySet().iterator();
		while(iterator.hasNext()){
			Map.Entry me = (Map.Entry)iterator.next();
			mapForPostNo.put((String)me.getValue(), (String)me.getKey());
			mapForPostNo.remove(""); //This is added because, while forming key value pair from ini file, ini file header [MainSection] will also get added, to remove this, we add this line
		}
		return mapForPostNo.get(postOffice);

	}

	/**
	 * Method to get the instance of this object
	 * @return
	 */
	public static ReadPostalValues getInstance() {
		Trace.entry("ReadPostalValues", "getInstance");
		if(instance == null) {
			try {
				instance = new ReadPostalValues();
			} catch (IOException e) {
				Trace.trace("ReadPostalValues", e.getMessage());
			}
		}
		Trace.exit("ReadPostalValues", "getInstance",null);
		return instance;
	}
}
