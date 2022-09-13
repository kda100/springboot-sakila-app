package com.Sakila.api.SakilaApp.Customer;

import com.Sakila.api.SakilaApp.Address.AddressDTO;
import lombok.Data;

import javax.persistence.Column;
import java.util.List;

@Data
public class CustomerDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private int active;
    private List<AddressDTO> addresses;
}