package com.blz.AddressBook.Exception.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.blz.AddressBook.Exception.ContactNotFoundException;
import com.blz.AddressBook.Util.Response;

@ControllerAdvice
public class ContactExceptionHandler {
	@ExceptionHandler(ContactNotFoundException.class)
	public ResponseEntity<Response> handleHiringException(ContactNotFoundException he){
		Response response = new Response();
        response.setErrorCode(400);
        response.setMessage(he.getMessage());
        return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
