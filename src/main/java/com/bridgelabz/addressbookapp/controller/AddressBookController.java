package com.bridgelabz.addressbookapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressBookController {
    @GetMapping(value = {"","/","home"})
    public String welcomeMessage(){
        return "Welcome to Address book App.";
    }
}
