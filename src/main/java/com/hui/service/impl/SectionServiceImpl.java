package com.hui.service.impl;

import com.hui.entity.Section;
import com.hui.mapper.SectionMapper;
import com.hui.service.SectionService;
import com.hui.utils.BeanMapUtils;
import com.hui.utils.MapParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SectionServiceImpl implements SectionService {

    @Autowired
    private SectionMapper sectionMapper;

    @Override
    public int create(Section pi) {
        return sectionMapper.create(pi);
    }

    @Override
    public int delete(Integer id) {
        return sectionMapper.delete(MapParameter.getInstance().addId(id).getMap());
    }

    @Override
    public int delete(String ids) {
        int flag = 0;
        for (String str : ids.split(",")) {
            flag = sectionMapper.delete(MapParameter.getInstance().addId(Integer.parseInt(str)).getMap());
        }
        return flag;
    }

    @Override
    public int update(Section section) {
        Map<String, Object> map = MapParameter.getInstance().add(BeanMapUtils.beanToMapForUpdate(section)).addId(section.getId()).getMap();
        return sectionMapper.update(map);
    }

    @Override
    public List<Section> query(Section section) {
        return sectionMapper.query(BeanMapUtils.beanToMap(section));
    }

    @Override
    public Section detail(Integer id) {
        return sectionMapper.detail(MapParameter.getInstance().addId(id).getMap());
    }

    @Override
    public int count(Section section) {
        return sectionMapper.count(BeanMapUtils.beanToMap(section));
    }

    @Override
    public List<Section> queryByStudent(Integer studentId){
        Map<String, Object> map = MapParameter.getInstance().add("studentId", studentId).getMap();
        return sectionMapper.queryByStudent(map);
    }

    @Override
    public List<Section> queryByTeacher(Integer teacherId){
        Map<String, Object> map = MapParameter.getInstance().add("teacherId", teacherId).getMap();
        return sectionMapper.queryByTeacher(map);
    }

}
