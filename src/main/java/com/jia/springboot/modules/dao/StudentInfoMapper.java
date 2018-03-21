package com.jia.springboot.modules.dao;

import com.jia.springboot.modules.pojo.StudentInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by jia on 2018/3/13.
 */
@Mapper
public interface StudentInfoMapper {
    public void insert(StudentInfo studentInfo);

    public StudentInfo getById();

    public void update(StudentInfo studentInfo);

    public void deleteById(Integer id);
}
