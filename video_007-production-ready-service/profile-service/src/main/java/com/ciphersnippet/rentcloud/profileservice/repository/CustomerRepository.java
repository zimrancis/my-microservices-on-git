package com.ciphersnippet.rentcloud.profileservice.repository;


import com.ciphersnippet.rentcloud.commons.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository  extends JpaRepository<Customer,Integer> {
//    List<Customer> findByPublished(boolean published);
//    List<Customer> findByTitleContaining(String title);
}
