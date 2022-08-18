package com.blz.AddressBook.Util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {

    public Response(String string, int i) {
		this.message=string;
		this.errorCode=i;
	}
	private String message;
    private int errorCode;
    private Object token;    

}
