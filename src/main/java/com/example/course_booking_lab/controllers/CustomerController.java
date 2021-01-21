package com.example.course_booking_lab.controllers;

import com.example.course_booking_lab.models.Booking;
import com.example.course_booking_lab.models.Course;
import com.example.course_booking_lab.models.Customer;
import com.example.course_booking_lab.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value="/customers")
    public ResponseEntity getAllCustomersAndFilters(
            @RequestParam(required=false, name="town") String town,
            @RequestParam(required=false, name="bookingsCourseName") String name
            ){
        if (town != null && name != null){
            List<Customer> foundCustomers = customerRepository.findByTownAndBookingsCourseName(town, name);
            return new ResponseEntity(foundCustomers, HttpStatus.OK);
        }
        return new ResponseEntity(customerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value="/customers/{id}")
    public ResponseEntity getCustomer(@PathVariable Long id){
        return new ResponseEntity<>(customerRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value="/customers")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        customerRepository.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @PutMapping(value="/customers/{id}")
    public ResponseEntity<Customer> updateCustomer(
            @RequestBody Customer customer,
            @PathVariable Long id) {
        customerRepository.save(customer);
        return new ResponseEntity(customer, HttpStatus.CREATED);
    }

    @DeleteMapping(value="/customers/{id}")
    public ResponseEntity<List<Customer>> deleteCustomer(@PathVariable Long id){
        customerRepository.deleteById(id);
        return new ResponseEntity(customerRepository.findAll(), HttpStatus.OK);
    }
}
