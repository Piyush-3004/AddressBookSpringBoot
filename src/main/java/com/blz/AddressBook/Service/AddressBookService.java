package com.blz.AddressBook.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blz.AddressBook.Dto.AddressBookDto;
import com.blz.AddressBook.Model.AddressBookModel;
import com.blz.AddressBook.Repository.IAddressBookRepository;

@Service
public class AddressBookService implements IAddressBookService {
	private List<AddressBookModel> dataList = new ArrayList<>();

	@Autowired
	IAddressBookRepository repo;

	@Override
	public AddressBookModel create(AddressBookModel addressBookDto) {
		AddressBookModel obj = new AddressBookModel(dataList.size() + 1, addressBookDto);
		dataList.add(obj);
		return obj;
	}

	@Override
	public List<AddressBookModel> readList() {
		return dataList;
	}

	@Override
	public AddressBookModel readById(long contactId) {

		Optional<AddressBookModel> obj = repo.findById(contactId);
		if (obj.isPresent())
			return dataList.get((int) contactId - 1);
		return null;
		// throw new EmployeeNotFoundException(400,"emp not present");
	}

	@Override
	public AddressBookModel update(long contactId, AddressBookDto addressBookDto) {
		Optional<AddressBookModel> obj = repo.findById(contactId);
		if (obj.isPresent()) {
			obj.get().setFirstName(addressBookDto.getFirstName());
			obj.get().setLastName(addressBookDto.getLastName());
			obj.get().setCity(addressBookDto.getCity());
			obj.get().setAddress(addressBookDto.getAddress());
			obj.get().setState(addressBookDto.getState());
			obj.get().setZip(addressBookDto.getZip());
			obj.get().setPhoneNumber(addressBookDto.getPhoneNumber());
			obj.get().seteMail(addressBookDto.geteMail());

			dataList.set((int) contactId - 1, obj.get());
			return obj.get();
		}
		return null;

	}

	@Override
	public AddressBookModel delete(long contactId) {
		Optional<AddressBookModel> obj = repo.findById(contactId);
		if (obj.isPresent()) {
			dataList.remove((int) contactId - 1);
			// repo.delete(emp.get());
			return obj.get();
		}
		return null;
	}

}
