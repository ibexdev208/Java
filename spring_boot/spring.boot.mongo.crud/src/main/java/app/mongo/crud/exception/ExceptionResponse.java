package app.mongo.crud.exception;

import java.util.Date;

public class ExceptionResponse {

	private Date timestamp;
	private String response;
	private String path;
	private String status;
	
	public ExceptionResponse() {
		super();
	}

	public ExceptionResponse(Date timestamp, String response, String path, String status) {
		super();
		this.timestamp = timestamp;
		this.response = response;
		this.path = path;
		this.status = status;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getResponse() {
		return response;
	}

	public String getpath() {
		return path;
	}
	
	public String getstatus() {
		return status;
	}
}
