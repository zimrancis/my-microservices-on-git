package com.ciphersnippet.rentcloud.profileservice.repository;


import com.ciphersnippet.rentcloud.commons.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository  extends JpaRepository<Customer,Integer> {

}
