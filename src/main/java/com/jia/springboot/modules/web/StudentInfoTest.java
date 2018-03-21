package com.jia.springboot.modules.web;

import com.jia.springboot.modules.dao.StudentInfoMapper;
import com.jia.springboot.modules.pojo.StudentInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by jia on 2018/3/13.
 */
//SpringJUnit4ClassRunner
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentInfoTest {
    @Resource
    private StudentInfoMapper studentInfoMapper;
    @Test
    public void testGetById() {
        StudentInfo studentInfo = this.studentInfoMapper.getById();
        System.out.println(studentInfo);
    }

}
