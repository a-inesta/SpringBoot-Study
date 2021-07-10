package com.hensel.springboot03web.dao;

import com.hensel.springboot03web.pojo.Department;
import com.hensel.springboot03web.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//员工Dao
@Repository
@Mapper
public class EmployeeDao {

    //模拟数据

    private static Map<Integer, Employee> employees = null;
    private DepartmentDao departmentDao;

    @Autowired
    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    static {
        employees = new HashMap<>();
        employees.put(1001, new Employee(1001, "AA", "23232323@qq.com", 1, new Department(101, "教学部")));
        employees.put(1002, new Employee(1002, "BB", "23232123@qq.com", 0, new Department(102, "市场部")));
        employees.put(1003, new Employee(1003, "CC", "23232446@qq.com", 0, new Department(103, "教研部")));
        employees.put(1004, new Employee(1004, "DD", "23877323@qq.com", 0, new Department(104, "后勤部")));
        employees.put(1005, new Employee(1005, "EE", "23212323@qq.com", 1, new Department(105, "运营部")));

    }
    private static Integer initId = 1006;

    public void save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }

    public void delete(Integer id) {
        employees.remove(id);
    }

    public Collection<Employee> getEmployees() {
        return employees.values();
    }
    public Employee getEmployeeById(Integer id) {
        return employees.get(id);
    }

    public void modify(Integer id, Employee employee) {
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(id,employee);
    }
}
