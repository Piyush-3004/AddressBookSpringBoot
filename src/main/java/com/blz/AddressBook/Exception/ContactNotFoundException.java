package com.blz.AddressBook.Exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ContactNotFoundException extends RuntimeException{
	
	private int statusCode;
	private String statusMessage;

	public ContactNotFoundException(int statusCode, String statusMessage) {
		super(statusMessage);
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
	}

}
