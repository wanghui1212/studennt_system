package com.hui.service;

import com.github.pagehelper.PageHelper;
import com.hui.entity.Teacher;
import com.hui.utils.BeanMapUtils;
import com.hui.utils.MD5Utils;
import com.hui.utils.MapParameter;

import java.util.List;
import java.util.Map;

public interface TeacherService {


    public int create(Teacher pi);

    public int delete(Integer id);

    public int delete(String ids);

    public int update(Teacher teacher);

    public List<Teacher> query(Teacher teacher);

    public Teacher detail(Integer id);

    public int count(Teacher teacher);

    public Teacher login(String userName, String password);

}
