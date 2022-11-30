package com.hui.service.impl;

import com.github.pagehelper.PageHelper;
import com.hui.entity.User;
import com.hui.mapper.UserMapper;
import com.hui.service.UserService;
import com.hui.utils.BeanMapUtils;
import com.hui.utils.MD5Utils;
import com.hui.utils.MapParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @Author wanghui
 * @Description
 * @Create 2022-11-30 1:58
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int create(User pi) {
        pi.setUserPwd(MD5Utils.getMD5(pi.getUserPwd()));
        return userMapper.create(pi);
    }

    @Override
    public int delete(Integer id) {
        return userMapper.delete(MapParameter.getInstance().addId(id).getMap());
    }
    @Override
    public int delete(String ids) {
        int flag = 0;
        for (String str : ids.split(",")) {
            flag = userMapper.delete(MapParameter.getInstance().addId(Integer.parseInt(str)).getMap());
        }
        return flag;
    }

    @Override
    public int update(User user) {
        Map<String, Object> map = MapParameter.getInstance().add(BeanMapUtils.beanToMapForUpdate(user)).addId(user.getId()).getMap();
        return userMapper.update(map);
    }

    @Override
    public List<User> query(User user) {
        if(user != null && user.getPage() != null){
            PageHelper.startPage(user.getPage(),user.getLimit());
        }
        return userMapper.query(BeanMapUtils.beanToMap(user));
    }

    @Override
    public User detail(Integer id) {
        return userMapper.detail(MapParameter.getInstance().addId(id).getMap());
    }

    @Override
    public int count(User user) {
        return userMapper.count(BeanMapUtils.beanToMap(user));
    }

    @Override
    public User login(String userName, String password){
        Map<String, Object> map = MapParameter.getInstance()
                .add("userName", userName)
                .add("userPwd", password)
                .getMap();
        return userMapper.detail(map);
    }

}
