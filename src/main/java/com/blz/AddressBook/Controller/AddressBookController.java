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


	@GetMapping("/readList")
	public List<AddressBookModel> readAll(){
		return service.readList();
	}
	
	@PostMapping("/sendmailheader")
	public void sendMail(@RequestHeader String mail,@RequestHeader String subject,@RequestHeader String body) {
		service.sendMail(mail,subject,body);
	}
	
	@GetMapping("/readbyheadefirstnamer")
	public AddressBookModel readbyheader(@RequestHeader String firstName) {
		return service.readbyheader(firstName);
	}
	
	@GetMapping("/readbyid/{id}")
	public AddressBookModel readById(@PathVariable long id) {
		return service.readById(id);
	}
		
	@PostMapping("/create")
	public AddressBookModel create(@Valid @RequestBody AddressBookDto obj) {
		return service.create(obj);
	}	
	
	@PutMapping("/update/{id}")
	public AddressBookModel update(@RequestBody AddressBookDto obj, @PathVariable long id) {

		return service.update(id,obj);
	}
	
	@DeleteMapping("/delete/{id}")
	public AddressBookModel delete(@PathVariable long id) {
		return service.delete(id);
	}
	
	@GetMapping("/getsortedbyname")
	public List<AddressBookModel> getSortenByName(){
		return service.getSortedByName();
	}
	
//  partial matching of city name working
	@GetMapping("/getbycity/{city}")
	public List<AddressBookModel> getByCity(@PathVariable String city){
		return service.getByCity(city);
	}
	
}
