package com.example.course_booking_lab.repositories;

import com.example.course_booking_lab.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByTownAndBookingsCourseName(String town, String name);
}
