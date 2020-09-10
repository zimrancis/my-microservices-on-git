package com.ciphersnippet.rentcloud.profileservice.controller;

import com.ciphersnippet.rentcloud.profileservice.service.CustomerService;
import com.ciphersnippet.rentcloud.commons.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/services")
public class ProfileController {


    @Autowired
    CustomerService customerService;

    @PostMapping(value = "/profile")
    @PreAuthorize("hasAuthority('create_profile')")
    public Customer save(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @GetMapping("/profile/{id}")
    public Customer fetch(@PathVariable("id") int id) {
        return customerService.fetchById(id);
    }

    /*@GetMapping("/profile/{id}")
    public ResponseEntity<Customer> fetch(@PathVariable("id") int id) {
        Optional<Customer> tutorialData = Optional.ofNullable(customerService.fetchById(id));

        if (tutorialData.isPresent()) {
            return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }*/

    @GetMapping(value = "/profiles")
    @PreAuthorize("hasRole('ROLE_operator')")
    public List<Customer> fetchAll() {
        return customerService.fetchAllProfiles();
    }

    /*GET ALL PROFILES*/
    /*@GetMapping(value = "/profiles/last")
    public ResponseEntity<List<Customer>> getAllLastNameProfiles(String lastName) {
        return customerService.getAllProfiles(lastName);
    }*/

    /**
     * DELETE SINGLE PROFILE
     ***/
    @DeleteMapping("/profile/{id}")
    @PreAuthorize("hasAuthority('delete_profile')")
    public ResponseEntity<HttpStatus> deleteProfile(@PathVariable("id") int id) {
        try {
            customerService.deleteProfile(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/profile/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") int id, @RequestBody Customer customer) {
        return customerService.updateCustomer(id, customer);
    }

    @DeleteMapping("/profiles")
    public ResponseEntity<HttpStatus> deleteAllTutorials() {
        try {
            customerService.deleteAllProfiles();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}