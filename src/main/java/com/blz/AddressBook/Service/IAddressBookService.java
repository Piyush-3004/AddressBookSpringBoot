package com.blz.AddressBook.Service;

import java.util.List;

import com.blz.AddressBook.Dto.AddressBookDto;
import com.blz.AddressBook.Model.AddressBookModel;
import com.blz.AddressBook.Util.Response;


public interface IAddressBookService {

	AddressBookModel update(long contactId, AddressBookDto addressBookDto);

	List<AddressBookModel> readList();

	AddressBookModel readById(long contactId);

	AddressBookModel delete(long contactId);

	AddressBookModel create(AddressBookDto addressBookDto);

	AddressBookModel readbyheader(String firstName);

	void sendMail(String mail, String subject, String body);

	List<AddressBookModel> getSortedByName();

	List<AddressBookModel> getByCity(String city);

}
