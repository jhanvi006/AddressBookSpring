package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.model.AddressBook;
import com.bridgelabz.addressbookapp.service.IAddressBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/addressBook")
@Slf4j
public class AddressBookController {
    @Autowired
    private IAddressBookService addressBookService;

    @GetMapping(value = {"", "/", "/getAddressBook"})
    public ResponseEntity<ResponseDTO> getAddressBookData(){
        List<AddressBook> addressBookList = null;
        addressBookList = addressBookService.getAddressBook();
        ResponseDTO responseDTO = new ResponseDTO("Get call successful", addressBookList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    @PostMapping("/addAddressBook")
    public ResponseEntity<ResponseDTO> createAddressBook(@Valid @RequestBody AddressBookDTO addressBookDTO){
        AddressBook addressBook = addressBookService.addAddressBook(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created Address Book data successfully", addressBook);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    @GetMapping("/getAddressBookById/{id}")
    public ResponseEntity<ResponseDTO> getAddressBookById(@PathVariable int id){
        AddressBook addressBook = addressBookService.getAddressBookById(id);
        ResponseDTO responseDTO = new ResponseDTO("Get call for id successful", addressBook);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    @PutMapping("/editAddressBook/{id}")
    public ResponseEntity<ResponseDTO> editAddressBook(@PathVariable int id, @Valid @RequestBody AddressBookDTO addressBookDTO){
        AddressBook addressBook = addressBookService.editAddressBook(id, addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated Address Book data successfully", addressBook);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    @DeleteMapping("/deleteAddressBook/{id}")
    public ResponseEntity<ResponseDTO> deleteAddressBook(@PathVariable int id){
        addressBookService.deleteAddressBook(id);
        ResponseDTO responseDTO = new ResponseDTO("Deleted Successfully", "Deleted for id: "+id);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
