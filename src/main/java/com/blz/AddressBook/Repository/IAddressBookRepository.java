package com.blz.AddressBook.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blz.AddressBook.Model.AddressBookModel;


public interface IAddressBookRepository extends JpaRepository<AddressBookModel, Long >{

}
