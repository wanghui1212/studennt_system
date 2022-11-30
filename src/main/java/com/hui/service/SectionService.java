package com.hui.service;

import com.hui.entity.Section;
import com.hui.utils.BeanMapUtils;
import com.hui.utils.MapParameter;

import java.util.List;
import java.util.Map;

public interface SectionService {


    public int create(Section pi);

    public int delete(Integer id);

    public int delete(String ids);

    public int update(Section section);

    public List<Section> query(Section section);

    public Section detail(Integer id);

    public int count(Section section);

    public List<Section> queryByStudent(Integer studentId);

    public List<Section> queryByTeacher(Integer teacherId);

}
