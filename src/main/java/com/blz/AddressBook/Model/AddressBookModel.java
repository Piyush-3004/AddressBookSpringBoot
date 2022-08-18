package com.blz.AddressBook.Model;
import javax.persistence.*;
import javax.validation.constraints.Pattern;

import com.blz.AddressBook.Dto.AddressBookDto;


import lombok.Data;

@Data
@Entity
public class AddressBookModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long contactId;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private long zip;
	private long phoneNumber;
	private String mail;
	

	
	public AddressBookModel(AddressBookDto addressBookDto) {
//		this.contactId=addressBookDto.getContactId();
		this.firstName=addressBookDto.getFirstName();
		this.lastName=addressBookDto.getLastName();
		this.address=addressBookDto.getAddress();
		this.city=addressBookDto.getCity();
		this.state=addressBookDto.getState();
		this.zip=addressBookDto.getZip();
		this.phoneNumber=addressBookDto.getPhoneNumber();
		this.mail=addressBookDto.getMail();

		
	}



	public AddressBookModel() {
		super();
	}
	
	
//	public AddressBookModel(int i, AddressBookModel obj) {
//	//	AddressBookModel obj1 =new  AddressBookModel();
//	//	this.contactId=obj.getContactId();
//		this.firstName=obj.getFirstName();
//		this.lastName=obj.getLastName();
//		this.address=obj.getAddress();
//		this.city=obj.getCity();
//		this.state=obj.getState();
//		this.zip=obj.getZip();
//		this.phoneNumber=obj.getPhoneNumber();
//		this.eMail=obj.getEMail();
//		
//	}



//	public AddressBookModel() {
//		// TODO Auto-generated constructor stub
//	}
//
//
//	public long getContactId() {
//		return contactId;
//	}
//
//	public void setContactId(long contactId) {
//		this.contactId = contactId;
//	}
//
//	public String getFirstName() {
//		return firstName;
//	}
//
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//
//	public String getLastName() {
//		return lastName;
//	}
//
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//
//	public String getAddress() {
//		return address;
//	}
//
//	public void setAddress(String address) {
//		this.address = address;
//	}
//
//	public String getCity() {
//		return city;
//	}
//
//	public void setCity(String city) {
//		this.city = city;
//	}
//
//	public String getState() {
//		return state;
//	}
//
//	public void setState(String state) {
//		this.state = state;
//	}
//
//	public long getZip() {
//		return zip;
//	}
//
//	public void setZip(long zip) {
//		this.zip = zip;
//	}
//
//	public long getPhoneNumber() {
//		return phoneNumber;
//	}
//
//	public void setPhoneNumber(long phoneNumber) {
//		this.phoneNumber = phoneNumber;
//	}
//
//	public String geteMail() {
//		return eMail;
//	}
//
//	public void seteMail(String eMail) {
//		this.eMail = eMail;
//	}


}
