package com.hui.mapper;

import com.hui.entity.Clazz;
import com.hui.entity.Section;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})

public class SectionMapperTest {

    Section section = new Section();
    Clazz clazz = new Clazz();

//    @Autowired
//    SectionDao sectionDao;
//
    
// 注入Dao实现类依赖
    @Resource
SectionMapper sectionMapper;

    @Test
    public void create() {
//        各个表之间没有关联
        clazz.setId(55);
        section.setClazz(clazz);
        section.setId(20);
        section.setType("夏季");
        section.setYear(2022);
        section.setRemark("这是测试section");
        sectionMapper.create(section);
    }

    @Test
    public void queryByStudent() {
        Map<String, Object> paramMap = new HashMap<>();
        
        System.out.println(sectionMapper.queryByStudent(paramMap));

    }

    @Test
    public void queryByTeacher() {


    }
}