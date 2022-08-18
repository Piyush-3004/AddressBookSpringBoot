package com.blz.AddressBook.Controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.blz.AddressBook.Dto.AddressBookDto;
import com.blz.AddressBook.Model.AddressBookModel;
import com.blz.AddressBook.Service.IAddressBookService;
import com.blz.AddressBook.Util.Response;


@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
	
	@Autowired
	IAddressBookService service;

	@PostMapping("/create")
	public AddressBookModel create(@Valid @RequestBody AddressBookDto addressBookDto) {
		return service.create(addressBookDto);
	}	

	@GetMapping("/readList")
	public List<AddressBookModel> readAll(){
		return service.readList();
	}

	@GetMapping("/readbyfirstnamer")
	public AddressBookModel readbyheader(@RequestHeader String firstName) {
		return service.readbyheader(firstName);
	}
	
	@GetMapping("/readbyid/{id}")
	public AddressBookModel readById(@PathVariable long id) {
		return service.readById(id);
	}
	
	@GetMapping("/getsortedbyname")
	public List<AddressBookModel> getSortenByName(){
		return service.getSortedByName();
	}
	
//  partial matching of city name working
	@GetMapping("/getbycitybycontent/{city}")
	public List<AddressBookModel> getByCity(@PathVariable String city){
		return service.getByCity(city);
	}

	@PutMapping("/update/{id}")
	public AddressBookModel update(@RequestBody AddressBookDto addressBookDto, @PathVariable long id) {
		
		return service.update(id,addressBookDto);
	}
	
	@DeleteMapping("/delete/{id}")
	public AddressBookModel delete(@PathVariable long id) {
		return service.delete(id);
	}
	// mail will be sent if mail if is present in DB
	@PostMapping("/sendmailheader")
	public void sendMail(@RequestHeader String mail,@RequestHeader String subject,@RequestHeader String body) {
		service.sendMail(mail,subject,body);
	}
	
}
