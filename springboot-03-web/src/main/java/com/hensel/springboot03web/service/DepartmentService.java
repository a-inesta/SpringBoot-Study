package com.hensel.springboot03web.service;

import com.hensel.springboot03web.dao.DepartmentDao;
import com.hensel.springboot03web.pojo.Department;

import java.util.Collection;

public interface DepartmentService {

    public Collection<Department> getDepartments();
    public Department getDepartmentById(Integer id);
}
