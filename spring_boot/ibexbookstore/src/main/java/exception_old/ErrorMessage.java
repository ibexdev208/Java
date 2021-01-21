package exception_old;

import java.sql.Date;

public class ErrorMessage {

	//private int statusCode;
	private Date timestamp;
	private String message;
	private String description;
	
	public ErrorMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

//	public ErrorMessage(int statusCode, java.util.Date date, String message, String description) {
	public ErrorMessage(java.util.Date date, String message, String description) {
		super();
		//this.statusCode = statusCode;
		this.timestamp = (Date) date;
		this.message = message;
		this.description = description;
	}

//	public int getStatusCode() {
//		return statusCode;
//	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDescription() {
		return description;
	}
	
	
}
