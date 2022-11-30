package com.hui.service;

import com.github.pagehelper.PageHelper;
import com.hui.mapper.RequestMapper;
import com.hui.entity.Request;
import com.hui.utils.BeanMapUtils;
import com.hui.utils.MapParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RequestService {


    public int create(Request pi);

    public int delete(Integer id);

    public int delete(String ids);

    public int update(Request request);

    public List<Request> query(Request request);

    public Request detail(Integer id);

    public int count(Request request);

}
