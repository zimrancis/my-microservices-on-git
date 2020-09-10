package com.ciphersnippet.rentcloud.rentprocesstask.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * @author Zobair Al-Imran
 * admin@ciphersnippet.com
 * www.ciphersnippet.com
 * twitter @zimrancis
 * on 05-September-2020 08:58 PM
 * @Project rent-process-task
 */
@Service
public class RentProcessServiceImpl implements RentProcessService {



    @Override
    public boolean validateDL(String dlNumber) {
        return dlNumber.length() > 5;
    }

}
