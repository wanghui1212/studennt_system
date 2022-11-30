package com.hui.service;

import com.hui.entity.Course;

import java.util.List;

public interface CourseService {


    public int create(Course pi) ;

    public int delete(Integer id);

    public int delete(String ids);

    public int update(Course course);
    public List<Course> query(Course course) ;

    public Course detail(Integer id) ;

    public int count(Course course) ;

}
