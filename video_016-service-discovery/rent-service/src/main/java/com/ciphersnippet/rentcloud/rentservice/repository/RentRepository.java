package com.ciphersnippet.rentcloud.rentservice.repository;

import com.ciphersnippet.rentcloud.model.rent.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * @author Zobair Al-Imran
 * admin@ciphersnippet.com
 * www.ciphersnippet.com
 * twitter @zimrancis
 * on 05-September-2020 08:58 PM
 * @Project rentcloudmodel
 */
public interface RentRepository extends JpaRepository<Rent,Integer> {
}