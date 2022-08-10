package com.blz.AddressBook.Model;
import javax.persistence.*;

import com.blz.AddressBook.Dto.AddressBookDto;
public class AddressBookModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long contactId;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private long zip;
	private long phoneNumber;
	private String eMail;
	

	public AddressBookModel(AddressBookDto addressBookDto) {
		this.firstName=addressBookDto.getFirstName();
		this.lastName=addressBookDto.getLastName();
		this.address=addressBookDto.getAddress();
		this.city=addressBookDto.getCity();
		this.state=addressBookDto.getState();
		this.zip=addressBookDto.getZip();
		this.phoneNumber=addressBookDto.getPhoneNumber();
		this.eMail=addressBookDto.geteMail();

	}
	
	
	public long getContactId() {
		return contactId;
	}

	public void setContactId(long contactId) {
		this.contactId = contactId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public long getZip() {
		return zip;
	}

	public void setZip(long zip) {
		this.zip = zip;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

}
