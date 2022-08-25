package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Courses;
import com.springrest.springrest.services.CourseService;

@RestController
public class MyController {

    @Autowired
    private CourseService courseService;
    // get the courses
    @GetMapping("/courses")
    public List<Courses> getCourses(){
        return this.courseService.getCourses();
        
    }

    @GetMapping("/courses/{courseId}")
    public Courses getCourse(@PathVariable String courseId){
        return this.courseService.getCourse(Long.parseLong( courseId)) ;
    }

    @PostMapping("/courses")
    public Courses addCourses(@RequestBody Courses course){
        return this.courseService.addCourses(course);
    }

    @PutMapping("/courses")
    public Courses updatCourses(@RequestBody Courses course){
        return this.courseService.updateCourses(course);
    }

    @DeleteMapping("/courses/{id}")
    public ResponseEntity<HttpStatus> deleteCourses(@PathVariable String id){
        try{
            this.courseService.deleteCourses(Long.parseLong(id));
            return new ResponseEntity<>(HttpStatus.OK);
    
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }}
