package com.hensel.springboot03web.service.serviceImpl;

import com.hensel.springboot03web.dao.DepartmentDao;
import com.hensel.springboot03web.pojo.Department;
import com.hensel.springboot03web.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentDao departmentDao;
    @Autowired
    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public Collection<Department> getDepartments() {
        return departmentDao.getDepartments();
    }

    @Override
    public Department getDepartmentById(Integer id) {
        return departmentDao.getDepartmentById(id);
    }
}
