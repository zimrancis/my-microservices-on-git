package com.ciphersnippet.rentcloud.profileservice.service;

import com.ciphersnippet.rentcloud.commons.model.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CustomerService {


    Customer save(Customer customer);

    Customer fetchById(int profileId);

    List<Customer> fetchAllProfiles();

    ResponseEntity<HttpStatus> deleteProfile(int id);

    public ResponseEntity<Customer> updateCustomer(int id, Customer customer);

    ResponseEntity<HttpStatus> deleteAllProfiles();
}
