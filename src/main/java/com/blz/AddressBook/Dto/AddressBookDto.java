package com.blz.AddressBook.Dto;


import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class AddressBookDto {

	@Pattern(regexp="^[A-Z]{1}[a-zA-Z]{2,}$",message="name invalid  !!!!!!")
	private String firstName;
	@Pattern(regexp="^[A-Z]{1}[a-zA-Z]{2,}$",message="last name invalid  !!!!!!")
	private String lastName;
	private String address;
	private String city;
	private String state;
	private long zip;
	private long phoneNumber;
	@Pattern(regexp="^[a-zA-Z]+([_+-.][a-zA-Z])*[@][a-zA-Z]+[.][a-z]{2,3}([.][a-zA-Z]{2})*$",message="Invalid mail id ...!!!")
	private String Mail;
	
	}
