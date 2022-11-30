package com.hui.mapper;

import com.hui.entity.Clazz;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)  //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})//classpath就是代表编译后的 /WEB-INF /classes/ 这个路径
public class ClazzMapperTest {

    Clazz clazz = new Clazz();

    @Autowired
    ClazzMapper clazzDao;

    @Test
    public void create() {

        clazz.setId(1);
        clazz.setClazzName("测试课程");
        clazz.setRemark("测试");
        clazzDao.create(clazz);

    }

    @Test
    public void delete() {
//        clazz.setId(1);
//        clazz.setClazzName("测试课程");
//        clazz.setRemark("测试");
//        Integer integer = clazz.getId();
//        String string = clazz.getClazzName();
//        System.out.println(string);
//        System.out.println(integer);
        Map<String, Object> paramMap = new HashMap<>();
//        paramMap.put("计算机测试课程",1);
        System.out.println(paramMap);
        clazzDao.delete(paramMap);
    }

    @Test
    public void update() {

        Map<String, Object> paramMap = new HashMap<>();
//        paramMap.put("计算机191","计算机科学与技术");
//        System.out.println(paramMap);

//        clazzDao.update(paramMap);

    }

    @Test
    public void query() {
        //全部查询
        Map<String, Object> paramMap = new HashMap<>();
//        paramMap.put("测试课程","测试课程2");
        System.out.println(paramMap);
        System.out.println(clazzDao.query(paramMap));
    }

    @Test(expected = AssertionError.class)//断言异常
    public void detail() {
        Map<String, Object> paramMap = new HashMap<>();
        System.out.println(paramMap);
//        断言：assertEquals();
       // assertEquals("计算机191",clazzDao.detail(paramMap).getClazzName());
        assertEquals("15",clazzDao.detail(paramMap).getId());

    }

    @Test
    public void count() {
        Map<String, Object> paramMap = new HashMap<>();
        System.out.println(paramMap);
        System.out.println(clazzDao.count(paramMap));
    }
}