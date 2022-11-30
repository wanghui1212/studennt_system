package com.hui.service.impl;

import com.hui.entity.Job;
import com.hui.mapper.JobMapper;
import com.hui.service.JobService;
import com.hui.utils.BeanMapUtils;
import com.hui.utils.MapParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobMapper jobMapper;

    @Override
    public int create(Job pi) {
        return jobMapper.create(pi);
    }

    @Override
    public int delete(Integer id) {
        return jobMapper.delete(MapParameter.getInstance().addId(id).getMap());
    }

    @Override
    public int update(Job job) {
        Map<String, Object> map = MapParameter.getInstance().add(BeanMapUtils.beanToMapForUpdate(job)).addId(job.getId()).getMap();
        return jobMapper.update(map);
    }

    @Override
    public List<Job> query(Job job) {
        return jobMapper.query(BeanMapUtils.beanToMap(job));
    }

    @Override
    public Job detail(Integer id) {
        return jobMapper.detail(MapParameter.getInstance().addId(id).getMap());
    }

    @Override
    public Job detailByStudent(Integer stuId) {
        return jobMapper.detail(MapParameter.getInstance().add("stuId",stuId).getMap());
    }

    @Override
    public int count(Job job) {
        return jobMapper.count(BeanMapUtils.beanToMap(job));
    }

}
