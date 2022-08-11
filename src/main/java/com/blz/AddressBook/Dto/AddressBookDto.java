package com.blz.AddressBook.Dto;


import lombok.Data;

@Data
public class AddressBookDto {

//	private long contactId;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private long zip;
	private long phoneNumber;
	private String eMail;

//	public long getContactId() {
//		return contactId;
//	}
//
//	public void setContactId(long contactId) {
//		this.contactId = contactId;
//	}

	// public AddressBookDto(String string, List<AddressBookModel> dataList) {
//		
//	}
	// @Override
//	public String toString() {
//		return "AddressBookDto [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", city="
//				+ city + ", state=" + state + ", zip=" + zip + ", phoneNumber=" + phoneNumber + ", eMail=" + eMail
//				+ "]";
//	}
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
