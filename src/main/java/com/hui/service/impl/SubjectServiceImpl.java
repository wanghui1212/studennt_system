package com.hui.service.impl;

import com.github.pagehelper.PageHelper;
import com.hui.entity.Subject;
import com.hui.mapper.SubjectMapper;
import com.hui.service.SubjectService;
import com.hui.utils.BeanMapUtils;
import com.hui.utils.MapParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectMapper subjectMapper;

    @Override
    public int create(Subject pi) {
        return subjectMapper.create(pi);
    }

    @Override
    public int delete(Integer id) {
        return subjectMapper.delete(MapParameter.getInstance().addId(id).getMap());
    }
    @Override
    public int delete(String ids) {
        int flag = 0;
        for (String str : ids.split(",")) {
            flag = subjectMapper.delete(MapParameter.getInstance().addId(Integer.parseInt(str)).getMap());
        }
        return flag;
    }

    @Override
    public int update(Subject subject) {
        Map<String, Object> map = MapParameter.getInstance().add(BeanMapUtils.beanToMapForUpdate(subject)).addId(subject.getId()).getMap();
        return subjectMapper.update(map);
    }

    @Override
    public List<Subject> query(Subject subject) {
        //当查询条件有分页信息时，按照分页查询
        if(subject != null && subject.getPage() != null){
            PageHelper.startPage(subject.getPage(),subject.getLimit());
        }
        return subjectMapper.query(BeanMapUtils.beanToMap(subject));
    }

    @Override
    public Subject detail(Integer id) {
        return subjectMapper.detail(MapParameter.getInstance().addId(id).getMap());
    }

    @Override
    public int count(Subject subject) {
        return subjectMapper.count(BeanMapUtils.beanToMap(subject));
    }

}
