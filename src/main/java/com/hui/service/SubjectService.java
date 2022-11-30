package com.hui.service;

import com.hui.entity.Subject;

import java.util.List;

public interface SubjectService {


    public int create(Subject pi);

    public int delete(Integer id);

    public int delete(String ids);

    public int update(Subject subject);

    public List<Subject> query(Subject subject);

    public Subject detail(Integer id);

    public int count(Subject subject);


}
