package com.blz.AddressBook.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blz.AddressBook.Model.AddressBookModel;


public interface IAddressBookRepository extends JpaRepository<AddressBookModel, Long >{

	Optional<AddressBookModel> findByMail(String email);

	Optional<AddressBookModel> findByFirstName(String firstName);

	List<AddressBookModel> findByCity(String city);

}
