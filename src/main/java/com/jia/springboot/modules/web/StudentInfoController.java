package com.jia.springboot.modules.web;

import com.jia.springboot.modules.dao.StudentInfoMapper;
import com.jia.springboot.modules.pojo.StudentInfo;
import com.jia.springboot.modules.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jia on 2018/3/13.
 */
@Controller
@RequestMapping(value="studentInfo/")
public class StudentInfoController {
    @Autowired
    private StudentInfoMapper studentInfoMapper;
    @Resource
    private StudentInfoService studentInfoService;
    @RequestMapping("getOne")
    @ResponseBody
    public StudentInfo getStudentInfo(){
        StudentInfo studentInfo = studentInfoMapper.getById();
        return studentInfo;
    }

    @RequestMapping("get/{id}")
    public Map<String,Object> get(@PathVariable("id") Integer id) {
        StudentInfo department = this.studentInfoService.get(id);

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code", "200");
        map.put("msg", "获取成功");
        map.put("data", department);
        return map;
    }
    @RequestMapping("save")
    @ResponseBody
    public Map<String, Object> save(StudentInfo studentInfo){
        StudentInfo department=studentInfoService.save(studentInfo);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code", "200");
        map.put("msg", "保存成功");
        return map;
    }

    @RequestMapping("update")
    @ResponseBody
    public Map<String, Object> update(StudentInfo studentInfo){
        StudentInfo department=studentInfoService.update(studentInfo);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code", "200");
        map.put("msg", "修改成功");
        return map;
    }

    @RequestMapping("delete/{id}")
    public Map<String,Object> delete(@PathVariable("id") Integer id) {
        this.studentInfoService.delete(id);

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code", "200");
        map.put("msg", "删除成功");
        return map;
    }
}
