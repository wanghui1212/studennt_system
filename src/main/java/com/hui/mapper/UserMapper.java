package com.hui.mapper;

import java.util.List;
import java.util.Map;

import com.hui.entity.User;

public interface UserMapper {
    public int create(User pi);

    public int delete(Map<String, Object> paramMap);

    public int update(Map<String, Object> paramMap);

    public List<User> query(Map<String, Object> paramMap);

    public User detail(Map<String, Object> paramMap);

    public int count(Map<String, Object> paramMap);
}