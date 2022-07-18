package com.bridgelabz.addressbookapp.dto;

import lombok.AllArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@ToString
public class AddressBookDTO {
    @Pattern(regexp = "^[A-Z][a-zA-Z]{2,}$", message = "First name invalid")
    public String firstName;
    @Pattern(regexp = "^[A-Z][a-zA-Z]{2,}$", message = "Last name invalid")
    public String lastName;
    @NotBlank(message = "Address should not be empty")
    public String address;
    @NotBlank(message = "City should not be empty")
    public String city;
    @NotBlank(message = "State should not be empty")
    public String state;
    @Pattern(regexp = "^[1-9]\\d{2}\\s?\\d{3}$", message = "Zip code invalid")
    public String zipCode;
    @Pattern(regexp = "^(\\d{0,2}\\s?)*[1-9]\\d{9}$", message = "Phone No. invalid")
    public String phoneNo;
    @Email(message = "Email is invalid")
    public String email;
}
