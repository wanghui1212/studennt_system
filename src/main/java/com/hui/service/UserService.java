package com.hui.service;

import com.hui.entity.User;

import java.util.List;

public interface UserService {

    public int create(User pi) ;

    public int delete(Integer id) ;
    public int delete(String ids) ;

    public int update(User user) ;

    public List<User> query(User user) ;

    public User detail(Integer id) ;
    public int count(User user) ;
    public User login(String userName,String password);

}
