package no.fellesdata.util.logger;
import no.fellesdata.logic.types.CustomerNo;
import no.fellesdata.NoValueSetException;
import no.fellesdata.util.trace.Trace;
import java.net.InetAddress;
import java.net.UnknownHostException;
/**
Log environment class containing static attributes,  used when logging messages. 
It depends on the specific logger how this infomation is used. 

@author     Dag Helge Sønderland

@version    $Revision: 1.2 $

Revisions :
$Log: LogEnvironment.java  $
Revision 1.2 2002/04/10 09:21:22CEST z2326mn 

Revision 1.1  1999/06/12 22:32:19Z  z2828ds
Initial revision
Revision 1.4  1999/03/18 21:19:21  z2828ds
 */
public class LogEnvironment {

	// The follwoing attributes should always be set
	private String hostName;
	private String hostAddress; // this field can be thick or thin client IP.
	private String userId;

	// The following attributes may or may not be set
	private String officeCode = null;
	private CustomerNo customerId = null;
	private int regNo;
	private boolean regNoSet = false;
	private String clientIp; //This is used in case where SO validation fails. Because session bean controller client address will return last used IP address
	private String thickClientIpAddress; //This field is strictly used for thick client IP 
	/**
	 * These fields are required for logging details to FLG.
	 * When FLG was called from client side , in the new architecture, there will not be session bean data
	 * available. So, instead of km Logged in user, system login user will be logged in FLGPList. To prevent
	 * this, we need to send km logged in user as parameter instead of system logged in user. Same case applies 
	 * to regNo and office code. Both will be treated as null if we dont set them from client side.
	 * 
	 * Note that this applies only to client side calls for FLG. Server side calls remain as it is.
	 * 
	 */
	private static String userIdFLG;
	private static String officeCodeFLG;
	private static int regNoFLG;

	/**
    <pre>
    Constructor.  Lookup the following attributes : 
    - hostName
    - hostAddress
    - userId
    </pre>
	 */
	public LogEnvironment() {
		//        Trace.entry(this,"LogEnvironment");

		userId = System.getProperty("user.name");

		try {
			InetAddress iaddr = InetAddress.getLocalHost();
			hostName = iaddr.getHostName();
			hostAddress = iaddr.getHostAddress();
		} catch (UnknownHostException e) {
			//#dhs Logg message ?
					Trace.trace(this,"Exception : " + e.toString());
		}
		//      Trace.exit(this,"LogEnvironment",null);
	}

	/**
    @exception NoValueSetException If hostName is not set. 
	 */
	public String getHostName() throws NoValueSetException {
		if  (this.hostName == null)
			throw new NoValueSetException("Hostnam not set");
		return this.hostName;
	}

	/**
    @exception NoValueSetException If hostAddress is not set. 
	 */
	public String getHostAddress() throws NoValueSetException {
		if  (hostAddress == null)
			throw new NoValueSetException("hostAddress not set");
		return this.hostAddress;
	}

	/**
    @exception NoValueSetException If userId is not set. 
	 */
	public String getUserId() throws NoValueSetException {
		if (userId == null)
			throw new NoValueSetException("userId not set");
		return this.userId;
	}

	/**
    @exception NoValueSetException If officeCode is not set. 
	 */
	public String getOfficeCode() throws NoValueSetException {
		if  (officeCode == null)
			throw new NoValueSetException("officeCode not set");
		return this.officeCode;
	}

	/**
    @exception NoValueSetException If customerId is not set. 
	 */
	public CustomerNo getCustomerId() throws NoValueSetException {
		if  (customerId == null)
			throw new NoValueSetException("customerId not set");
		return this.customerId;
	}

	/**
    @exception NoValueSetException If regNo is not set. 
	 */
	public int getRegNo() throws NoValueSetException {
		if  (regNoSet == false)
			throw new NoValueSetException("regno not set");
		return this.regNo;
	}

	/**
   @param hostName The new hostName
	 */
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	/**
    @param The new hostAddress
	 */
	public void setHostAddress(String hostAddress) {
		this.hostAddress = hostAddress;
	}

	/**
    @param userId The new userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
    @param The
	 */
	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}

	/**
	 */
	public void setCustomerId(CustomerNo customerId) {
		this.customerId = customerId;
	}

	/**
	 */
	public void setRegNo(int regNo) {
		regNoSet = true;
		this.regNo = regNo;
	}    


	/**
	 * @return the clientIp
	 */
	public String getClientIp() {
		return clientIp;
	}

	/**
	 * Constructor created to log when so validation fails. Existing constructor
	 * was logging host name as server name for SO Validation, since at the first 
	 * level there will be no data to log about node names, only user name and IP will be logged.
	 * 
	 * @param userName
	 */
	public LogEnvironment(String clientIp) {
		this.clientIp= clientIp;
	}

	/**
	 * @return the userIdFLG
	 */
	public static String getUserIdFLG() {
		return userIdFLG;
	}

	/**
	 * @param userIdFLG the userIdFLG to set
	 */
	public static void setUserIdFLG(String userIdFLG) {
		LogEnvironment.userIdFLG = userIdFLG;
	}

	/**
	 * @return the officeCodeFLG
	 */
	public static String getOfficeCodeFLG() {
		return officeCodeFLG;
	}

	/**
	 * @param officeCodeFLG the officeCodeFLG to set
	 */
	public static void setOfficeCodeFLG(String officeCodeFLG) {
		LogEnvironment.officeCodeFLG = officeCodeFLG;
	}

	/**
	 * @return the regNoFLG
	 */
	public static int getRegNoFLG() {
		return regNoFLG;
	}

	/**
	 * @param regNoFLG the regNoFLG to set
	 */
	public static void setRegNoFLG(int regNoFLG) {
		LogEnvironment.regNoFLG = regNoFLG;
	}

	public String getThickClientIpAddress() {
		return thickClientIpAddress;
	}

	public void setThickClientIpAddress(String thickClientIpAddress) {
		this.thickClientIpAddress = thickClientIpAddress;
	}


}