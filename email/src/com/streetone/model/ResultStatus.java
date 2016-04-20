package com.streetone.model;

public class ResultStatus {

	public boolean status;
	public String data;

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResultStatus [status=" + status + ", data=" + data + "]";
	}

}
