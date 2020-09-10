package com.ciphersnippet.rentcloud.profileservice.controller;

import com.ciphersnippet.rentcloud.commons.model.Customer;
import com.ciphersnippet.rentcloud.profileservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/services")
public class ProfileController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public Customer save(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @GetMapping("/profile/{id}")
    public Customer fetch(@PathVariable("id") int id) {
        return customerService.fetchById(id);
    }

/*    @GetMapping("/profile/{id}")
    public ResponseEntity<Customer> fetch(@PathVariable("id") int id) {
        Optional<Customer> tutorialData = Optional.ofNullable(customerService.fetchById(id));

        if (tutorialData.isPresent()) {
            return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }*/

    @RequestMapping(value = "/profiles", method = RequestMethod.GET)
    public List<Customer> fetch() {
        return customerService.fetchAllProfiles();
    }
}