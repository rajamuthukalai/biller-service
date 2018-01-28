package com.sannu.billerservice.exception;

public class BillerNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private long billerId;

	public BillerNotFoundException(long billerId) {
		this.billerId = billerId;
	}
	
	public long getBillerId() {
		return billerId;
	}
}