package com.jia.springboot.modules.service.serviceImpl;

import com.jia.springboot.modules.dao.StudentInfoMapper;
import com.jia.springboot.modules.pojo.StudentInfo;
import com.jia.springboot.modules.service.StudentInfoService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by jia on 2018/3/13.
 */
@CacheConfig(cacheNames = "studentInfo")
@Service
public class StudentInfoServiceImpl implements StudentInfoService{
    @Resource
    private StudentInfoMapper studentInfoMapper;
    @Override
    @CachePut(key = "#studentInfo.id")
    public StudentInfo save(StudentInfo studentInfo) {
        System.out.println("保存 id="+studentInfo.getId()+"的数据");
        this.studentInfoMapper.insert(studentInfo);
        return studentInfo;
    }

    @Override
    @CachePut(key = "#studentInfo.id")
    public StudentInfo update(StudentInfo studentInfo) {
        System.out.println("修改 id="+studentInfo.getId()+"的数据");
        studentInfoMapper.update(studentInfo);
        return studentInfo;
    }

    @Override
    @CacheEvict(key="#id") //获取缓存为id的缓存
    public void delete(Integer id) {
        System.out.println("删除 id="+id+"的数据");
        studentInfoMapper.deleteById(id);
    }

    @Override
    @Cacheable(key="#id") //清空缓存为id的缓存
    public StudentInfo get(Integer id) {
        System.out.println("获取 id="+id+"的数据");
        StudentInfo studentInfo = studentInfoMapper.getById();
        return studentInfo;
    }
}
