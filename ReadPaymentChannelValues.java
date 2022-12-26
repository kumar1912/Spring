package no.fellesdata.util;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;
import java.util.Map.Entry;
import java.util.Properties;
import no.fellesdata.fdfront.fdcash.logic.profile.transactioncode.PaymentChannelType;
import no.fellesdata.util.trace.Trace;

/**
 * Class for reading all the configuration related to PaymentChannels.
 */
public class ReadPaymentChannelValues {
	final StringBuilder sbBasePath = new StringBuilder(System.getProperty("user.home")).append("/fdk/ini/").append("paymentChannelValues.ini");
	private static ReadPaymentChannelValues instance = null;
	private Scanner scan=null;
	private PaymentChannelType pct=null;

	/**
	 * Default Constructor
	 * @throws IOException
	 */
	private ReadPaymentChannelValues() throws IOException{
		Trace.entry(this, "ReadPaymentChannelValues");
		try {
			Trace.trace(this, "Loading paymentChannelValues.ini:"+sbBasePath.toString());
			scan = new Scanner(new File(sbBasePath.toString()));
			Trace.trace(this, "Sucessfully loaded paymentChannelValues.ini");
		} catch (IOException e) {
			Trace.trace(this, e.getMessage());
		}
		Trace.exit(this, "ReadPaymentChannelValues",null);
	}



	/**
	 * Method to get the values of the specific value in ini file
	 * 
	 * @param postOffice
	 * @return
	 */
	public PaymentChannelType[] getPaymentChannelvalues(){
		PaymentChannelType[] pctList=null;
		Vector     v = new Vector(128);
		while(scan.hasNextLine()) {
			//System.out.println(scan.nextLine());
			String split[] = scan.nextLine().trim().split("=");
			if(split.length == 2) {
				pct = new PaymentChannelType((String)split[0],(String)split[1]);
				Trace.trace(this, "Key : "+pct.getChannelKey() +" -Value: "+pct.getChannelValue());
			}else{
				Trace.trace(this, " Key :" +(String)split[0]+" does not have correct value in paymentChannelValues.ini file, please check" );
			}
			v.addElement(pct);	
		}
		if (v.size() > 0) {
			pctList = new PaymentChannelType[v.size()];
			v.copyInto(pctList);
		} else {
			pctList = new PaymentChannelType[]{};
		} 
		return pctList;

	}

	/**
	 * Method to get the instance of this object
	 * @return
	 */
	public static ReadPaymentChannelValues getInstance() {
		Trace.entry("ReadPaymentChannelValues", "getInstance");
		try {
				instance = new ReadPaymentChannelValues();
			} catch (IOException e) {
				Trace.trace("ReadPaymentChannelValues", e.getMessage());
			}
		Trace.exit("ReadPaymentChannelValues", "getInstance","");
		return instance;
	}

	public static void main(String v[]) throws IOException{

		ReadPaymentChannelValues obj = new ReadPaymentChannelValues();
		PaymentChannelType[] paymentChannelDeatils = obj.getPaymentChannelvalues();
		System.out.println("total size of channel details are :"+paymentChannelDeatils.length);
		for (int i=0;i<paymentChannelDeatils.length;i++){
			System.out.println("Channel Key is :" + paymentChannelDeatils[i].getChannelKey() +" Channel value is :"+ paymentChannelDeatils[i].getChannelValue());
		}
	}
}
