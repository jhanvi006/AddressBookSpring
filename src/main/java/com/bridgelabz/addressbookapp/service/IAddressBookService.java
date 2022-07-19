package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBook;

import java.util.List;

public interface IAddressBookService {
    List<AddressBook> getAddressBook();
    AddressBook addAddressBook(AddressBookDTO addressBookDTO);
    AddressBook getAddressBookById(int id);
    AddressBook editAddressBook(int id, AddressBookDTO addressBookDTO);
    void deleteAddressBook(int id);
    List<AddressBook> getAddressBookByCity(String city);
    List<AddressBook> getAddressBookByState(String state);
    List<AddressBook> sortAddressBookByCity();
    List<AddressBook> sortAddressBookByState();
}
