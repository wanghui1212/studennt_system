package com.hui.service.impl;

import com.github.pagehelper.PageHelper;
import com.hui.mapper.CourseMapper;
import com.hui.entity.Course;
import com.hui.service.CourseService;
import com.hui.utils.BeanMapUtils;
import com.hui.utils.MapParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public int create(Course pi) {
        return courseMapper.create(pi);
    }

    @Override
    public int delete(Integer id) {
        return courseMapper.delete(MapParameter.getInstance().addId(id).getMap());
    }

    @Override
    public int delete(String ids) {
        int flag = 0;
        for (String str : ids.split(",")) {
            flag = courseMapper.delete(MapParameter.getInstance().addId(Integer.parseInt(str)).getMap());
        }
        return flag;
    }

    @Override
    public int update(Course course) {
        Map<String, Object> map = MapParameter.getInstance().add(BeanMapUtils.beanToMapForUpdate(course)).addId(course.getId()).getMap();
        return courseMapper.update(map);
    }

    @Override
    public List<Course> query(Course course) {
        if(course != null && course.getPage() != null){
            PageHelper.startPage(course.getPage(),course.getLimit());
        }
        return courseMapper.query(BeanMapUtils.beanToMap(course));
    }

    @Override
    public Course detail(Integer id) {
        return courseMapper.detail(MapParameter.getInstance().addId(id).getMap());
    }

    @Override
    public int count(Course course) {
        return courseMapper.count(BeanMapUtils.beanToMap(course));
    }

}
