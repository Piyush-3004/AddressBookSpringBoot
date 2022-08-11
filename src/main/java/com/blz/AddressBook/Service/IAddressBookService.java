package com.blz.AddressBook.Service;

import java.util.List;

import com.blz.AddressBook.Dto.AddressBookDto;
import com.blz.AddressBook.Model.AddressBookModel;

public interface IAddressBookService {

	AddressBookModel create(AddressBookModel addressBookDto);

	AddressBookModel update(long contactId, AddressBookDto addressBookDto);

	List<AddressBookModel> readList();

	AddressBookModel readById(long contactId);

	AddressBookModel delete(long contactId);

}
