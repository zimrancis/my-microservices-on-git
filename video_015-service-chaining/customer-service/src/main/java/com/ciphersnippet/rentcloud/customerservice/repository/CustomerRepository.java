package com.ciphersnippet.rentcloud.customerservice.repository;

import com.ciphersnippet.rentcloud.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Zobair Al-Imran
 * admin@ciphersnippet.com
 * www.ciphersnippet.com
 * twitter @zimrancis
 * on 05-September-2020 08:58 PM
 * @Project rentcloudmodel
 */
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
