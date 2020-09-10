package com.ciphersnippet.rentcloud.model.customer;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


/**
 * @author Zobair Al-Imran
 * admin@ciphersnippet.com
 * www.ciphersnippet.com
 * twitter @zimrancis
 * on 05-September-2020 08:58 PM
 * @Project rentcloudmodel
 */


@Entity
@Table(name = "customer")
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    private String firstName;
    private String lastName;
    private String dlNumber;
    private String zipcode;
    @OneToMany(mappedBy = "customer")
    private List<Loyality> loyalities;


}
