package no.fellesdata.util.logger;

import java.util.Properties;

import no.fellesdata.NoValueSetException;
/**
Log environment class containing static attributes,  used when logging messages. 
It depends on the specific logger how this infomation is used. 

@author     Jan-Petter Kruger

@version    $Revision: 1.2 $

Revisions :
$Log: FDCoreLogEnvironment.java  $
Revision 1.2 2002/04/10 09:13:58CEST z2326mn 

Revision 1.1  2000/09/14 04:51:52Z  z2043jk
Initial revision
*/
public class FDCoreLogEnvironment extends LogEnvironment {
    
    // The following attributes may or may not be set
    private String execEnv = null;
    
    /**
    <pre>
    Constructor.  Lookup the following attributes : 
    - hostName
    - hostAddress
    - userId
    </pre>
    */
    public FDCoreLogEnvironment() {
        super();
//        Trace.entry(this,"LogEnvironment");
        Properties prop = System.getProperties();
        String regEnv;
        if  ((regEnv = prop.getProperty("no.fellesdata.exec.env")) != null) {
          execEnv = regEnv;
        }
        
//        Trace.exit(this,"LogEnvironment",null);
    }
    
    /**
    @exception NoValueSetException If hostName is not set. 
    */
    public String getExecEnv() throws NoValueSetException {
        if  (this.execEnv == null)
            throw new NoValueSetException("Execution Environment not set");
        return this.execEnv;
    }
    
   /**
   @param execEnv The new ExecEnv
    */
    public void setExecEnv(String execEnv) {
        this.execEnv = execEnv;
    }
    
}