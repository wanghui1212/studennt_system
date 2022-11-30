package com.hui.controller;

import com.hui.entity.Clazz;
import com.hui.entity.Subject;
import com.hui.service.ClazzService;
import com.hui.service.SubjectService;
import com.hui.utils.MapControll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
//该类表示控制器类
@Controller
//指定控制器可以处理哪些URL请求
@RequestMapping("/clazz")
public class ClazzController {

    private static final String LIST = "clazz/list";
    private static final String ADD = "clazz/add";
    private static final String UPDATE = "clazz/update";
   //自动装配
    @Autowired
    private ClazzService clazzService;
    @Autowired
    private SubjectService subjectService;
    //只接受get方式的请求
    @GetMapping("/add")
    public String create(ModelMap modelMap){
        List<Subject> subjects = subjectService.query(null);
        modelMap.addAttribute("subjects",subjects);
        return ADD;
    }
    //只接受post方式的请求
    @PostMapping("/create")
    //将java对象转为json格式的数据
    @ResponseBody
    public Map<String,Object> create(@RequestBody Clazz clazz){
        int result = clazzService.create(clazz);
        if(result<=0){
            return MapControll.getInstance().error().getMap();
        }
        return MapControll.getInstance().success().getMap();
    }

    @PostMapping("/delete/{id}")
    @ResponseBody
    public Map<String,Object> delete(@PathVariable("id") Integer id){
        int result = clazzService.delete(id);
        if(result<=0){
            return MapControll.getInstance().error().getMap();
        }
        return MapControll.getInstance().success().getMap();
    }

    @PostMapping("/delete")
    @ResponseBody
    public Map<String,Object> delete(String ids){
        int result = clazzService.delete(ids);
        if(result<=0){
            return MapControll.getInstance().error().getMap();
        }
        return MapControll.getInstance().success().getMap();
    }

    @PostMapping("/update")
    @ResponseBody
    public Map<String,Object> update(@RequestBody Clazz clazz){
        int result = clazzService.update(clazz);
        if(result<=0){
            return MapControll.getInstance().error().getMap();
        }
        return MapControll.getInstance().success().getMap();
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Integer id, ModelMap modelMap){
        Clazz clazz = clazzService.detail(id);
        List<Subject> subjects = subjectService.query(null);
        modelMap.addAttribute("clazz",clazz);
        modelMap.addAttribute("subjects",subjects);
        return UPDATE;
    }

    @PostMapping("/query")
    @ResponseBody
    public Map<String,Object> query(@RequestBody Clazz clazz){
        List<Clazz> list = clazzService.query(clazz);
        List<Subject> subjects = subjectService.query(null);
        //设置subject
        list.forEach(entity->{
            subjects.forEach(subject -> {
                if(entity.getSubjectId() == subject.getId()){
                    entity.setSubject(subject);
                }
            });
        });
        Integer count = clazzService.count(clazz);
        return MapControll.getInstance().success().page(list,count).getMap();
    }

    @GetMapping("/list")
    public String list(){
        return LIST;
    }

}
