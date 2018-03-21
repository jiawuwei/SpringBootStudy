package com.jia.springboot.modules.service;

import com.jia.springboot.modules.pojo.StudentInfo;

/**
 * Created by jia on 2018/3/13.
 */
public interface StudentInfoService {
    StudentInfo save(StudentInfo studentInfo);

    StudentInfo update(StudentInfo studentInfo);

    void delete(Integer id);

    StudentInfo get(Integer id);
}
