package com.hui.service.impl;

import com.github.pagehelper.PageHelper;
import com.hui.entity.Request;
import com.hui.mapper.RequestMapper;
import com.hui.service.RequestService;
import com.hui.utils.BeanMapUtils;
import com.hui.utils.MapParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestMapper requestMapper;

    @Override
    public int create(Request pi) {
        return requestMapper.create(pi);
    }

    @Override
    public int delete(Integer id) {
        return requestMapper.delete(MapParameter.getInstance().addId(id).getMap());
    }

    @Override
    public int delete(String ids) {
        int flag = 0;
        for (String str : ids.split(",")) {
            flag = requestMapper.delete(MapParameter.getInstance().addId(Integer.parseInt(str)).getMap());
        }
        return flag;
    }

    @Override
    public int update(Request request) {
        return requestMapper.update(MapParameter.getInstance().add(BeanMapUtils.beanToMapForUpdate(request)).addId(request.getId()).getMap());
    }

    @Override
    public List<Request> query(Request request) {
        if(request != null && request.getPage() != null){
            PageHelper.startPage(request.getPage(),request.getLimit());
        }
        return requestMapper.query(BeanMapUtils.beanToMap(request));
    }

    @Override
    public Request detail(Integer id) {
        return requestMapper.detail(MapParameter.getInstance().addId(id).getMap());
    }

    @Override
    public int count(Request request) {
        return requestMapper.count(BeanMapUtils.beanToMap(request));
    }

}
