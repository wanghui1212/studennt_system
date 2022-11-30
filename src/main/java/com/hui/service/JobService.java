package com.hui.service;

import com.hui.entity.Job;

import java.util.List;

public interface JobService {


    public int create(Job pi);

    public int delete(Integer id);

    public int update(Job job);

    public List<Job> query(Job job);

    public Job detail(Integer id);

    public Job detailByStudent(Integer stuId);

    public int count(Job job);

}
