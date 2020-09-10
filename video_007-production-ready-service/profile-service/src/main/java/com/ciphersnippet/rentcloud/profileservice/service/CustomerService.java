package com.ciphersnippet.rentcloud.profileservice.service;

import com.ciphersnippet.rentcloud.commons.model.Customer;

import java.util.List;

public interface CustomerService {


    Customer save(Customer customer);

    Customer fetchById(int profileId);

    List<Customer> fetchAllProfiles();
}
