package com.example.course_booking_lab.components;

import com.example.course_booking_lab.models.Booking;
import com.example.course_booking_lab.models.Course;
import com.example.course_booking_lab.models.Customer;
import com.example.course_booking_lab.repositories.BookingsRepository;
import com.example.course_booking_lab.repositories.CourseRepository;
import com.example.course_booking_lab.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingsRepository bookingsRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    public DataLoader() {

    }

    public void run(ApplicationArguments args) throws Exception {
        Course course1 = new Course("Software Development", "Edinburgh", 5);
        courseRepository.save(course1);

        Course course2 = new Course("Data Analysis", "Glasgow", 4);
        courseRepository.save(course2);

        Customer customer1 = new Customer("Michael", "Edinburgh", 21);
        customerRepository.save(customer1);

        Customer customer2 = new Customer("Michael", "Ayr", 39);
        customerRepository.save(customer2);

        Customer customer3 = new Customer("Emily", "Edinburgh", 21);
        customerRepository.save(customer3);

        Booking booking1 = new Booking("12-10-2020", course1, customer1);
        bookingsRepository.save(booking1);

        Booking booking2 = new Booking("01-02-2021", course2, customer1);
        bookingsRepository.save(booking2);

        Booking booking3 = new Booking("12-10-2020", course1, customer2);
        bookingsRepository.save(booking3);

        Booking booking4 = new Booking("01-02-2021", course2, customer2);
        bookingsRepository.save(booking4);

        Booking booking5 = new Booking("12-10-2020", course1, customer3);
        bookingsRepository.save(booking5);

        Booking booking6 = new Booking("01-02-2021", course2, customer3);
        bookingsRepository.save(booking6);


    }
}
