package com.ciphersnippet.rentcloud.rentservice.controller;

import com.ciphersnippet.rentcloud.model.rent.Rent;
import com.ciphersnippet.rentcloud.rentservice.model.Response;
import com.ciphersnippet.rentcloud.rentservice.model.SimpleResponse;
import com.ciphersnippet.rentcloud.rentservice.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
@RestController
@RequestMapping("/services/rents")
public class RentController {


    @Autowired
    RentService rentService;

    @PostMapping
    public Rent save(@RequestBody Rent rent) {
        return rentService.save(rent);
    }

    @GetMapping(value = "/{id}")
    public Response getRent(@PathVariable int id, @RequestParam(required = false) String type) throws ExecutionException, InterruptedException {

        if(type==null){
            return  new SimpleResponse(rentService.findById(id));
        }else{
            return    rentService.findDetailResponse(id);
        }



    }

    @GetMapping
    public List<Rent> getAllRents() {
        return rentService.findAll();
    }

/*    @RequestMapping("/test")
    public Rent test() {
        Rent r = new Rent();
        r.setCustomerId(1);
        r.setCurrentOdometer(1223);
        r.setRentFrom(LocalDateTime.now());
        r.setRentTill(LocalDateTime.of(2020, 9, 31, 00, 00, 00));
        r.setReturnLocation("Dhaka");
        r.setVehicleId(1);

        return r;
    }*/
}
