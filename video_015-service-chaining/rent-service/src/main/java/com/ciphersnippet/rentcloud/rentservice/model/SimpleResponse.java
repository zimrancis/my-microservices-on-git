package com.ciphersnippet.rentcloud.rentservice.model;

import com.ciphersnippet.rentcloud.model.rent.Rent;

/**
 * @author Zobair Al-Imran
 * admin@ciphersnippet.com
 * www.ciphersnippet.com
 * twitter @zimrancis
 * on 05-September-2020 08:58 PM
 * @Project rentcloudmodel
 */
public class SimpleResponse implements Response {

    Rent rent;


    public SimpleResponse(Rent rent) {
        this.rent = rent;
    }

    public Rent getRent() {
        return rent;
    }

    public void setRent(Rent rent) {
        this.rent = rent;
    }
}
