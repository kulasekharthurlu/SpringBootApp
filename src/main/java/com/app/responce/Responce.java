package com.app.responce;

import org.springframework.http.HttpStatus;

public class Responce<T> {

	private HttpStatus httpStatus;
	private T data;
	private String message;

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Responce(HttpStatus httpStatus, T data, String message) {
		super();
		this.httpStatus = httpStatus;
		this.data = data;
		this.message = message;
	}

	public Responce() {
		super();
	}

	@Override
	public String toString() {
		return "Responce [httpStatus=" + httpStatus + ", data=" + data + ", message=" + message + "]";
	}

}
