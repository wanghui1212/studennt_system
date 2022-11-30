package com.hui.service.impl;

import com.github.pagehelper.PageHelper;
import com.hui.mapper.ClazzMapper;
import com.hui.entity.Clazz;
import com.hui.service.ClazzService;
import com.hui.utils.BeanMapUtils;
import com.hui.utils.MapParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;

    @Override
    public int create(Clazz pi) {
        return clazzMapper.create(pi);
    }

    @Override
    public int delete(Integer id) {
        return clazzMapper.delete(MapParameter.getInstance().addId(id).getMap());
    }

    @Override
    public int delete(String ids) {
        int flag = 0;
        for (String str : ids.split(",")) {
            flag = clazzMapper.delete(MapParameter.getInstance().addId(Integer.parseInt(str)).getMap());
        }
        return flag;
    }

    @Override
    public int update(Clazz clazz) {
        return clazzMapper.update(MapParameter.getInstance().add(BeanMapUtils.beanToMapForUpdate(clazz)).addId(clazz.getId()).getMap());
    }

    @Override
    public List<Clazz> query(Clazz clazz) {
        if(clazz != null && clazz.getPage() != null){
            PageHelper.startPage(clazz.getPage(),clazz.getLimit());
        }
        return clazzMapper.query(BeanMapUtils.beanToMap(clazz));
    }

    @Override
    public Clazz detail(Integer id) {
        return clazzMapper.detail(MapParameter.getInstance().addId(id).getMap());
    }

    @Override
    public int count(Clazz clazz) {
        return clazzMapper.count(BeanMapUtils.beanToMap(clazz));
    }

}
