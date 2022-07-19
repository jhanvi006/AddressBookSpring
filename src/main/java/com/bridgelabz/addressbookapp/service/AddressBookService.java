package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.exceptions.AddressBookException;
import com.bridgelabz.addressbookapp.model.AddressBook;
import com.bridgelabz.addressbookapp.repository.AddressBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AddressBookService implements IAddressBookService {
    @Autowired
    private AddressBookRepository repository;
    @Override
    public List<AddressBook> getAddressBook() {
        return repository.findAll();
    }
    @Override
    public AddressBook addAddressBook(AddressBookDTO addressBookDTO) {
        AddressBook addressBook = new AddressBook(addressBookDTO);
        log.debug("Address Book data: "+addressBook.toString());
        return repository.save(addressBook);
    }
    @Override
    public AddressBook getAddressBookById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new AddressBookException("Address Book with id "+id+" not found!"));
    }
    @Override
    public AddressBook editAddressBook(int id, AddressBookDTO addressBookDTO) {
        AddressBook addressBook = this.getAddressBookById(id);
        addressBook.updateData(addressBookDTO);
        log.debug("Address Book data: "+addressBook.toString());
        return repository.save(addressBook);
    }
    @Override
    public void deleteAddressBook(int id) {
        AddressBook addressBook = this.getAddressBookById(id);
        repository.delete(addressBook);
    }
    @Override
    public List<AddressBook> getAddressBookByCity(String city) {
        return repository.findByCity(city);
    }

    @Override
    public List<AddressBook> getAddressBookByState(String state) {
        return repository.findByState(state);
    }
    @Override
    public List<AddressBook> sortAddressBookByCity() {
        return repository.findAllByOrderByCity();
    }

    @Override
    public List<AddressBook> sortAddressBookByState() {
        return repository.findAllByOrderByState();
    }
}
