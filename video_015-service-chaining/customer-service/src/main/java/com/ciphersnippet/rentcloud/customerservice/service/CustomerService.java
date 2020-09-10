package com.ciphersnippet.rentcloud.customerservice.service;

import com.ciphersnippet.rentcloud.model.customer.Customer;

import java.util.List;

/**
 * @author Zobair Al-Imran
 * admin@ciphersnippet.com
 * www.ciphersnippet.com
 * twitter @zimrancis
 * on 05-September-2020 08:58 PM
 * @Project rent-process-task
 */
public interface CustomerService {
    Customer save(Customer customer);

    Customer findById(int id);

    List<Customer> findAll();
}
