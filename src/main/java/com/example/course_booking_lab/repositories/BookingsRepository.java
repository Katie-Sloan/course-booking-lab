package com.example.course_booking_lab.repositories;

import com.example.course_booking_lab.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingsRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByDate(String date);
}
