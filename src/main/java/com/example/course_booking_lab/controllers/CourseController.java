package com.example.course_booking_lab.controllers;

import com.example.course_booking_lab.models.Booking;
import com.example.course_booking_lab.models.Course;
import com.example.course_booking_lab.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    // getAll getOne Create Update Delete

    @GetMapping(value="/courses")
    public ResponseEntity getAlCoursesAndFilters(
            @RequestParam(required = false, name="starRating") Integer starRating
    ){
        if (starRating != null){
            return new ResponseEntity(courseRepository.findByStarRating(starRating), HttpStatus.OK);
        }
        return new ResponseEntity(courseRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value="/courses/{id}")
    public ResponseEntity getCourse(@PathVariable Long id){
        return new ResponseEntity<>(courseRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value="/courses")
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        courseRepository.save(course);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }

    @PutMapping(value="/course/{id}")
    public ResponseEntity<Booking> updateCourse(
            @RequestBody Course course,
            @PathVariable Long id) {
        courseRepository.save(course);
        return new ResponseEntity(course, HttpStatus.CREATED);
    }

    @DeleteMapping(value="/courses/{id}")
    public ResponseEntity<List<Course>> deleteCourse(@PathVariable Long id){
        courseRepository.deleteById(id);
        return new ResponseEntity(courseRepository.findAll(), HttpStatus.OK);
    }


}
