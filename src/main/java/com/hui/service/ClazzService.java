package com.hui.service;

import com.hui.entity.Clazz;

import java.util.List;

public interface ClazzService {


    public int create(Clazz pi) ;

    public int delete(Integer id) ;

    public int delete(String ids) ;

    public int update(Clazz clazz) ;

    public List<Clazz> query(Clazz clazz);
    public Clazz detail(Integer id) ;
    public int count(Clazz clazz) ;

}
