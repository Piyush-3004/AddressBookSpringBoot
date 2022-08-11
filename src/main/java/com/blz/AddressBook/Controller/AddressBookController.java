package com.blz.AddressBook.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.blz.AddressBook.Dto.AddressBookDto;
import com.blz.AddressBook.Model.AddressBookModel;
import com.blz.AddressBook.Service.IAddressBookService;


@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
	
	@Autowired
	IAddressBookService service;


	@GetMapping("/readList")
	public List<AddressBookModel> readAll(){
		return service.readList();
	}
	
	@GetMapping("/readbyid/{id}")
	public AddressBookModel readById(@PathVariable long id) {
		return service.readById(id);
	}
	
	@PostMapping("/create")
	public AddressBookModel create(@RequestBody AddressBookModel obj) {
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
	
}
