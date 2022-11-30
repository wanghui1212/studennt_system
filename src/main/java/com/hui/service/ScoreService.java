package com.hui.service;

import com.hui.entity.Score;
import com.hui.utils.BeanMapUtils;
import com.hui.utils.MapParameter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ScoreService {


    public int create(Score pi);

    public int create(String sectionIds,String courseIds,Integer studentId);


    public int delete(Integer id);

    public int update(Score score);

    public int update(Integer courseId,Integer sectionId,String stuIds,String scores);

    public List<Score> query(Score score);

    public Score detail(Integer id);

    public int count(Score score);

    public List<HashMap> queryAvgScoreBySection();

    public List<HashMap> queryScoreByStudent(Integer studentId);

}
