package com.example.course_booking_lab.controllers;

import com.example.course_booking_lab.models.Booking;
import com.example.course_booking_lab.repositories.BookingsRepository;
import org.aspectj.lang.annotation.DeclareAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.RespectBinding;
import java.awt.print.Book;
import java.util.List;

@RestController
public class BookingsController {

    @Autowired
    BookingsRepository bookingsRepository;

// getAll getOne Create Update Delete

    @GetMapping(value="/bookings")
    public ResponseEntity getAllBookingsAndFilters(@RequestParam(required=false, name="date") String date){
        if (date != null){
            return new ResponseEntity(bookingsRepository.findByDate(date), HttpStatus.OK);
        }
        return new ResponseEntity(bookingsRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value="/bookings/{id}")
    public ResponseEntity getBooking(@PathVariable Long id){
        return new ResponseEntity<>(bookingsRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value="/bookings")
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        bookingsRepository.save(booking);
        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }

    @PutMapping(value="/bookings/{id}")
    public ResponseEntity<Booking> updateBooking(
            @RequestBody Booking booking,
            @PathVariable Long id) {
        bookingsRepository.save(booking);
        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }

    @DeleteMapping(value="/bookings/{id}")
    public ResponseEntity<List<Booking>> deleteBooking(@PathVariable Long id){
        bookingsRepository.deleteById(id);
        return new ResponseEntity<>(bookingsRepository.findAll(), HttpStatus.OK);
    }



}
