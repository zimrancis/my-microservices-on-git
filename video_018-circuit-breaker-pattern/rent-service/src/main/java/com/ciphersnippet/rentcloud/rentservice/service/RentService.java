package com.ciphersnippet.rentcloud.rentservice.service;

import com.ciphersnippet.rentcloud.model.rent.Rent;
import com.ciphersnippet.rentcloud.rentservice.model.DetailResponse;
import com.ciphersnippet.rentcloud.rentservice.model.Response;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author Zobair Al-Imran
 * admin@ciphersnippet.com
 * www.ciphersnippet.com
 * twitter @zimrancis
 * on 05-September-2020 08:58 PM
 * @Project rentcloudmodel
 */
public interface RentService {
    Rent save(Rent customer);

    Rent findById(int id);

    List<Rent> findAll();

    DetailResponse findDetailResponse(int id) throws ExecutionException, InterruptedException;
}
