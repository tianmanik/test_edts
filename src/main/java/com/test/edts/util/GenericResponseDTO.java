package com.test.edts.util;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public class GenericResponseDTO <T> implements Serializable {
	private com.test.edts.util.ResponseStatus status;
	private int code;
	private String message;
	private T data;

	@JsonIgnore
	public GenericResponseDTO<T> successResponse() {
		GenericResponseDTO<T> data = new GenericResponseDTO();
		data.setStatus(com.test.edts.util.ResponseStatus.S);
		data.setCode(201);
		data.setMessage("Process Successed");
		return data;
	}

	@JsonIgnore
	public GenericResponseDTO<T> successResponse(T t) {
		GenericResponseDTO<T> data = new GenericResponseDTO();
		data.setStatus(com.test.edts.util.ResponseStatus.S);
		data.setCode(201);
		data.setData(t);
		data.setMessage("Process Successed");
		return data;
	}

	@JsonIgnore
	public GenericResponseDTO<T> noDataFoundResponse(T t) {
		GenericResponseDTO<T> data = new GenericResponseDTO();
		data.setStatus(com.test.edts.util.ResponseStatus.S);
		data.setCode(204);
		data.setData(t);
		data.setMessage("No Data Found");
		return data;
	}

	@JsonIgnore
	public GenericResponseDTO<T> noDataFoundResponse() {
		GenericResponseDTO<T> data = new GenericResponseDTO();
		data.setStatus(com.test.edts.util.ResponseStatus.S);
		data.setCode(204);
		data.setMessage("No Data Found");
		return data;
	}

	@JsonIgnore
	public GenericResponseDTO<T> errorResponse(int code, String message) {
		GenericResponseDTO<T> data = new GenericResponseDTO();
		data.setStatus(com.test.edts.util.ResponseStatus.F);
		data.setCode(code);
		data.setMessage(message);
		return data;
	}

	public void setStatus(com.test.edts.util.ResponseStatus status) {
		this.status = status;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setData(T data) {
		this.data = data;
	}

	public com.test.edts.util.ResponseStatus getStatus() {
		return this.status;
	}


	public String getMessage() {
		return this.message;
	}

	public T getData() {
		return this.data;
	}

	public GenericResponseDTO() {
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public GenericResponseDTO(com.test.edts.util.ResponseStatus status, int code, String message, T data) {
		this.status = status;
		this.code = code;
		this.message = message;
		this.data = data;
	}

}
