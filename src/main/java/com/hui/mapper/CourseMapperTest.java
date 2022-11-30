package com.hui.mapper;

import com.hui.entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class CourseMapperTest {

    @Autowired
    CourseMapper courseDao;
    Course course = new Course();
    @Test
    public void create() {
        course.setCourseName("大学英语（测试）");
        courseDao.create(course);
    }

    @Test
    public void delete() {
//        删除的是整个表
        Map<String, Object> paramMap = new HashMap<>();
        courseDao.delete(paramMap);
    }

    @Test
    public void update() {
        Map<String, Object> paramMap = new HashMap<>();
//        修改的是整个表
//        courseDao.update(paramMap);
    }

    @Test
    public void query() {
        Map<String, Object> paramMap = new HashMap<>();
//        查询的是整个表
        courseDao.query(paramMap);
    }

    @Test
    public void detail() {
        Map<String, Object> paramMap = new HashMap<>();
//        默认显示第一条数据
        courseDao.detail(paramMap);
    }

    @Test
    public void count() {
        Map<String, Object> paramMap = new HashMap<>();
//        显示总数
        courseDao.count(paramMap);

    }
}