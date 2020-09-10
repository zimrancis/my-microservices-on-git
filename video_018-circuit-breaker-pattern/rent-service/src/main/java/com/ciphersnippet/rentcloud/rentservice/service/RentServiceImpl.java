package com.ciphersnippet.rentcloud.rentservice.service;

import com.ciphersnippet.rentcloud.model.customer.Customer;
import com.ciphersnippet.rentcloud.model.rent.Rent;
import com.ciphersnippet.rentcloud.model.vehicle.Vehicle;
import com.ciphersnippet.rentcloud.rentservice.hystrix.CommonHysctrixCommand;
import com.ciphersnippet.rentcloud.rentservice.hystrix.VehicleCommand;
import com.ciphersnippet.rentcloud.rentservice.model.DetailResponse;
import com.ciphersnippet.rentcloud.rentservice.repository.RentRepository;
import com.netflix.hystrix.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author Zobair Al-Imran
 * admin@ciphersnippet.com
 * www.ciphersnippet.com
 * twitter @zimrancis
 * on 05-September-2020 08:58 PM
 * @Project rentcloudmodel
 */
@Service
public class RentServiceImpl implements RentService {


    @Autowired
    RentRepository rentRepository;


    @Autowired
    HystrixCommand.Setter setter;

    @LoadBalanced
    @Bean
    RestTemplate getRestTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Autowired
    RestTemplate restTemplate;


    @Override
    public Rent save(Rent customer) {
        return rentRepository.save(customer);
    }


    @Override
    public Rent findById(int id) {
        Optional<Rent> rent = rentRepository.findById(id);

        if (rent.isPresent())
            return rent.get();
        else
            return new Rent();

    }


    @Override
    public List<Rent> findAll() {
        return rentRepository.findAll();
    }


    public DetailResponse findDetailResponse(int id) throws ExecutionException, InterruptedException {


        Rent rent = findById(id);
        Customer customer = getCustomer(rent.getCustomerId());
        Vehicle vehicle = getVehicle(rent.getVehicleId());

        return new DetailResponse(rent, customer, vehicle);


    }

    public DetailResponse findDetailResponsefallback(int id) {
        return new DetailResponse(new Rent(), new Customer(), new Vehicle());
    }


    private Customer getCustomer(int customerId) throws ExecutionException, InterruptedException {

        CommonHysctrixCommand<Customer> customerCommonHysctrixCommand = new CommonHysctrixCommand<Customer>(setter, () ->
        {
            return restTemplate.getForObject("http://customer/services/customers/" + customerId, Customer.class);
        }, () -> {
            return new Customer();
        });

        Future<Customer> customerFuture = customerCommonHysctrixCommand.queue();
        return customerFuture.get();

    }

    private Vehicle getVehicle(int vehicleId) {

        VehicleCommand vehicleCommand = new VehicleCommand(restTemplate, vehicleId);
        return vehicleCommand.execute();

        // return restTemplate.getForObject("http://vehicle/services/vehicles/"+vehicleId,Vehicle.class);


    }
}
