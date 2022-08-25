package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.Courses;

@Service
public class CourseServiceImpl implements CourseService {


    List<Courses> list;
    

    public CourseServiceImpl() {
        list = new ArrayList<>();
        list.add(new Courses(134,"Java Core Course","this course is for java"));
        list.add(new Courses(333,"Spring boot Course","This course teaches about spring boot"));
    }


    @Override
    public List<Courses> getCourses() {
        // TODO Auto-generated method stub
        return list;
    }


    @Override
    public Courses getCourse(long courseId) {

        Courses c=null;
        for(Courses course:list){
            if(course.getId()==courseId){
                c=course;
                break;
            }
        }
        return c;
    }


    @Override
    public Courses addCourses(Courses course) {
        // TODO Auto-generated method stub
        list.add(course);
        return course;
    }


    @Override
    public Courses updateCourses(Courses course) {
        // TODO Auto-generated method stub
        list.forEach(e -> {
            if(e.getId() == course.getId()){
                e.setTitle(course.getTitle());
                e.setDescription(course.getDescription());
            }
        });
        
        return course;
    }


    @Override
    public void deleteCourses(Long parseLong) {
        // TODO Auto-generated method stub
        
        list = this.list.stream().filter(e ->e.getId() != parseLong).collect(Collectors.toList());
        return;
    }
    

}
