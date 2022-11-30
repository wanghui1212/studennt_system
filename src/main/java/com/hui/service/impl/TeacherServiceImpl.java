package com.hui.service.impl;

import com.github.pagehelper.PageHelper;
import com.hui.entity.Teacher;
import com.hui.mapper.TeacherMapper;
import com.hui.service.TeacherService;
import com.hui.utils.BeanMapUtils;
import com.hui.utils.MD5Utils;
import com.hui.utils.MapParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public int create(Teacher pi) {
        pi.setTeacherPwd(MD5Utils.getMD5(pi.getTeacherPwd()));
        return teacherMapper.create(pi);
    }

    @Override
    public int delete(Integer id) {
        return teacherMapper.delete(MapParameter.getInstance().addId(id).getMap());
    }

    @Override
    public int delete(String ids) {
        int flag = 0;
        for (String str : ids.split(",")) {
            flag = teacherMapper.delete(MapParameter.getInstance().addId(Integer.parseInt(str)).getMap());
        }
        return flag;
    }

    @Override
    public int update(Teacher teacher) {
        Map<String, Object> map = MapParameter.getInstance().add(BeanMapUtils.beanToMapForUpdate(teacher)).addId(teacher.getId()).getMap();
        return teacherMapper.update(map);
    }

    @Override
    public List<Teacher> query(Teacher teacher) {
        if(teacher != null && teacher.getPage() != null){
            PageHelper.startPage(teacher.getPage(),teacher.getLimit());
        }
        return teacherMapper.query(BeanMapUtils.beanToMap(teacher));
    }

    @Override
    public Teacher detail(Integer id) {
        return teacherMapper.detail(MapParameter.getInstance().addId(id).getMap());
    }

    @Override
    public int count(Teacher teacher) {
        return teacherMapper.count(BeanMapUtils.beanToMap(teacher));
    }

    @Override
    public Teacher login(String userName, String password){
        Map<String, Object> map = MapParameter.getInstance()
                .add("teacherName", userName)
                .add("teacherPwd", password)
                .getMap();
        return teacherMapper.detail(map);
    }

}
