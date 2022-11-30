package com.hui.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)  //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})//classpath就是代表编译后的 /WEB-INF /classes/ 这个路径
public class CourseServiceImplTest {


    @Test
    public void create() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void testDelete() {
    }

    @Test
    public void update() {
    }

    @Test
    public void query() {
    }

    @Test
    public void detail() {
    }

    @Test
    public void count() {
    }
}