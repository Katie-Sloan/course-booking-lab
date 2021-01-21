package com.example.course_booking_lab;

import com.example.course_booking_lab.models.Booking;
import com.example.course_booking_lab.models.Course;
import com.example.course_booking_lab.models.Customer;
import com.example.course_booking_lab.repositories.BookingsRepository;
import com.example.course_booking_lab.repositories.CourseRepository;
import com.example.course_booking_lab.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseBookingLabApplicationTests {

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	BookingsRepository bookingsRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canFindCoursesByStarRating(){
		List<Course> foundCourses = courseRepository.findByStarRating(5);
		assertEquals("Software Development", foundCourses.get(0).getName());
	}

	@Test
	public void canFindBookingsByBookingDate(){
		List<Booking> foundBookings = bookingsRepository.findByDate("01-02-2021");
		assertEquals(3, foundBookings.size());
	}

}
