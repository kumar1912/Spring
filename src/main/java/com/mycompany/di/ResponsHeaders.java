package com.tui.uk.domain;

import java.util.List;

public class ResponsHeaders {
	 public int status;
	    public int QTime;
	    public SolarParams params;
	    
		public int getStatus() {
			return status;
		}
		public void setStatus(int status) {
			this.status = status;
		}
		public int getQTime() {
			return QTime;
		}
		public void setQTime(int qTime) {
			QTime = qTime;
		}
		public SolarParams getParams() {
			return params;
		}
		public void setParams(SolarParams params) {
			this.params = params;
		}
		
	    

}
