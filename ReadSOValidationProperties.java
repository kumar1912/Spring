package no.fellesdata.util;

import java.io.IOException;

import no.fellesdata.util.trace.Trace;

public class ReadSOValidationProperties {
		final static String iniFileName = "soConfig/soValidation.ini";
		static IniFile iniFile;
		private static ReadSOValidationProperties instance = null;


		/**
		 * Default Constructor
		 * @throws IOException
		 */
		private ReadSOValidationProperties() throws IOException{
			try {
				Trace.trace(this, "Loading soValidation.ini");
				iniFile = new IniFile(iniFileName, iniFileName);
				Trace.trace(this, "Sucessfully loaded soValidation.ini");
			} catch (IOException e) {
				Trace.trace(this, e.getMessage());
			}
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
		public static ReadSOValidationProperties getInstance() {
			if(instance == null) {
				try {
					instance = new ReadSOValidationProperties();
				} catch (IOException e) {
					Trace.trace("ReadSOValidationProperties", e.getMessage());
				}
			}
			return instance;
		}
}
