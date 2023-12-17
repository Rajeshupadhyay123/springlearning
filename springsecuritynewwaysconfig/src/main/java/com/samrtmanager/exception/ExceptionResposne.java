package com.samrtmanager.exception;

public class ExceptionResposne {

	private String message;
	
	private String status;
	
	public ExceptionResposne() {
		// TODO Auto-generated constructor stub
	}

	public ExceptionResposne(String message, String status) {
		super();
		this.message = message;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ExceptionResposne [message=" + message + ", status=" + status + "]";
	}
	
	
}
