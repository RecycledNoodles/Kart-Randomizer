package randomkartwii.data;

import java.util.Date;

public class CallAccessLogEntry {
	private Date dateAccessed;
	private int timesAccessed;
	private String callAccessed;
	
	public CallAccessLogEntry() {
		dateAccessed = null;
		timesAccessed = 0;
		callAccessed = null;
	}
	
	public Date getDateAccessed() {
		return dateAccessed;
	}
	public void setDateAccessed(Date dateAccessed) {
		this.dateAccessed = dateAccessed;
	}
	public int getTimesAccessed() {
		return timesAccessed;
	}
	public void setTimesAccessed(int timesAccessed) {
		this.timesAccessed = timesAccessed;
	}
	public String getCallAccessed() {
		return callAccessed;
	}
	public void setCallAccessed(String callAccessed) {
		this.callAccessed = callAccessed;
	}
}
