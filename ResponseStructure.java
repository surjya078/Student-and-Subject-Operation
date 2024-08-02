package com.jsp.helper;

public class ResponseStructure<T> {

	private int statuscode;
	private T data;
	private String message;

	public int getStatuscode() {
		return statuscode;
	}

	public T getData() {
		return data;
	}

	public String getMessage() {
		return message;
	}

	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}

	public void setData(T data) {
		this.data = data;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
