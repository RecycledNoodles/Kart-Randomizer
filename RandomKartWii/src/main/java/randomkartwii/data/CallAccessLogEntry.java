package randomkartwii.data;


public class CallAccessLogEntry {
	private String dateAccessed;
	private int timesAccessed;
	private String callAccessed;
	
	public CallAccessLogEntry() {
		dateAccessed = null;
		timesAccessed = 0;
		callAccessed = null;
	}
	
	public String getDateAccessed() {
		return dateAccessed;
	}
	public void setDateAccessed(String dateAccessed) {
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
