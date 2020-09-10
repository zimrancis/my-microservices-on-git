package com.ciphersnippet.rentcloud.rentservice.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.ciphersnippet.rentcloud.model.vehicle.Vehicle;
import org.springframework.web.client.RestTemplate;

/**
 * @author Zobair Al-Imran
 * admin@ciphersnippet.com
 * www.ciphersnippet.com
 * twitter @zimrancis
 * on 05-September-2020 08:58 PM
 * @Project rentcloudmodel
 */
public class VehicleCommand extends HystrixCommand<Vehicle> {


    RestTemplate restTemplate;
    int vehicleId;



    public VehicleCommand(RestTemplate restTemplate, int vehicleId){

        super(HystrixCommandGroupKey.Factory.asKey("default"));
        this.restTemplate=restTemplate;
        this.vehicleId=vehicleId;
    }


    @Override
    protected Vehicle run() throws Exception {
        return restTemplate.getForObject("http://vehicle/services/vehicles/"+vehicleId,Vehicle.class);
    }

    @Override
    protected Vehicle getFallback() {
        System.out.println("hit on fallback");
        return new Vehicle();
    }
}
