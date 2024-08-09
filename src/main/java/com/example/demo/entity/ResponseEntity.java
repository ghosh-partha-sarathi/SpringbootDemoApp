package com.example.demo.entity;

public class ResponseEntity<T> {
	private int responseCode;
	private String status;
	private String message;
	private T data;
	
	public ResponseEntity(int responseCode, String status, String message, T data) {
		this.responseCode = responseCode;
		this.status = status;
		this.message = message;
		this.data = data;
	}
	
	public int getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}	
}
