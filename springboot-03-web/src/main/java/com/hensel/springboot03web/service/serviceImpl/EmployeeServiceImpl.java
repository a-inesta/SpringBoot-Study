package com.hensel.springboot03web.service.serviceImpl;

import com.hensel.springboot03web.dao.EmployeeDao;
import com.hensel.springboot03web.pojo.Employee;
import com.hensel.springboot03web.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao employeeDao;

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public Collection<Employee> getEmployees() {
        return employeeDao.getEmployees();
    }

    @Override
    public Employee getEmployeesById(Integer id) {
        return employeeDao.getEmployeeById(id);
    }
}
