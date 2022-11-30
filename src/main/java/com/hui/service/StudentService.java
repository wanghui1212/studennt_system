package com.hui.service;

import com.hui.entity.Student;
import com.hui.utils.BeanMapUtils;
import com.hui.utils.MD5Utils;
import com.hui.utils.MapParameter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface StudentService {


    public int create(Student pi);

    public int delete(Integer id);

    public int delete(String ids);

    public int update(Student student);

    public List<Student> query(Student student);

    public Student detail(Integer id);

    public int count(Student student);


    public Student login(String userName, String password);

    public List<HashMap> querySelectStudent(Integer courseId, Integer sectionId);

    public List<Student> queryStudentByTeacher(Integer teacherId,Integer clazzId,Integer subjectId);

}
