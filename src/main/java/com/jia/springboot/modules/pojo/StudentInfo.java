/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/csstj/csstj">csstj</a> All rights reserved.
 */
package com.jia.springboot.modules.pojo;
/**
 * 学生管理Entity
 *
 * @author yjz
 * @version 2017-07-05
 */
public class StudentInfo{

    private static final long serialVersionUID = 1L;
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}