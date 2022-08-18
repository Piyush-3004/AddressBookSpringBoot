package com.blz.AddressBook.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.blz.AddressBook.Dto.AddressBookDto;
import com.blz.AddressBook.Exception.ContactNotFoundException;
import com.blz.AddressBook.Model.AddressBookModel;
import com.blz.AddressBook.Repository.IAddressBookRepository;
import com.blz.AddressBook.Util.Response;

@Service
public class AddressBookService implements IAddressBookService {
//	private List<AddressBookModel> dataList = new ArrayList<>();

	@Autowired
	IAddressBookRepository repo;
	
	@Autowired
	MailService mailService;
	
	@Override
	public AddressBookModel create(AddressBookDto addressBookDto) {
		AddressBookModel obj = new AddressBookModel(addressBookDto);
//		dataList.add(obj);
		repo.save(obj);
		return obj;
	}

	@Override
	public List<AddressBookModel> readList() {
		
		List<AddressBookModel> obj = repo.findAll(Sort.by(Sort.Direction.DESC,"firstName"));
		if(obj.size()>0) 
			return obj;
		throw new ContactNotFoundException(400,"Empty Contact List");
	}

	@Override
	public AddressBookModel readById(long contactId) {
		Optional<AddressBookModel> obj = repo.findById(contactId);
		if(obj.isPresent())
			return obj.get();	
		throw new ContactNotFoundException(400,"Contact with id " + contactId + " not present");
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
			obj.get().setMail(addressBookDto.getMail());
//			dataList.set((int) contactId - 1, obj.get());
			repo.save(obj.get());
			return obj.get();
		}
		throw new ContactNotFoundException(200,"Contact you are trying to update is Not Present");
	}

	@Override
	public AddressBookModel delete(long contactId) {
		Optional<AddressBookModel> obj = repo.findById(contactId);
		if (obj.isPresent()) {
			repo.delete(obj.get());
			return obj.get();
		}else
		throw new ContactNotFoundException(100,"Not available , could not delete");
	}

	@Override
	public AddressBookModel readbyheader(String firstName) {

		Optional<AddressBookModel> contact = repo.findByFirstName(firstName);
		if(contact.isPresent())
			return contact.get();
		else
			throw new ContactNotFoundException(100,"Contact Not Present");
	}

	@Override
	public void sendMail(String mail,String subject,String body) {

		try {
			Optional<AddressBookModel> isContactPresent = repo.findByMail(mail);
			if(isContactPresent.isPresent()) {
				//String body="Employee is added succesfully with employeeId ";
				//String subject="Employee Registration Succesfull";
				mailService.send(isContactPresent.get().getMail(),subject,body);
			}
			else throw new ContactNotFoundException(100,"No Contact with mail id "+isContactPresent.get().getMail());
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public List<AddressBookModel> getSortedByName() {
		
		return null;
	}

	@Override
	public List<AddressBookModel> getByCity(String city) {
//		List<AddressBookModel> doesContactsExist = repo.findByCity(city);

		List<AddressBookModel> doesContactsExist = repo.findAll();
		List<AddressBookModel> contactsList = new ArrayList<>();
		for(int i=0;i<doesContactsExist.size();i++) {
			if(doesContactsExist.get(i).getCity().contains(city))
				contactsList.add(doesContactsExist.get(i));
		}
		if(!contactsList.isEmpty())
			return contactsList;
		else 
			throw new ContactNotFoundException(100,"No Contact in city : "+city);

	}

	

}
