package com.hensel.springboot03web.service;

import com.hensel.springboot03web.pojo.Employee;

import java.util.Collection;

public interface EmployeeService {
    public Collection<Employee> getEmployees();
    public Employee getEmployeesById(Integer id);
}
