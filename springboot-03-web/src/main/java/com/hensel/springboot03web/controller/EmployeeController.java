package com.hensel.springboot03web.controller;

import com.hensel.springboot03web.dao.DepartmentDao;
import com.hensel.springboot03web.dao.EmployeeDao;
import com.hensel.springboot03web.pojo.Department;
import com.hensel.springboot03web.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.Collection;

@Controller
public class EmployeeController {
    EmployeeDao employeeDao;
    DepartmentDao departmentDao;
    @Autowired
    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
    @Autowired
    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @RequestMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getEmployees();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model) {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "emp/add";
    }
    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    @GetMapping("/emp/{id}")
    public String toUpdateEmp(@PathVariable("id") Integer id, Model model) {
        //查出原来数据

        Employee e = employeeDao.getEmployeeById(id);
        model.addAttribute("emp",e );

        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "emp/update";
    }
    @PostMapping("/updateEmp/{id}")
    public String updateEmp(@PathVariable("id") Integer id, Employee employee) {
        System.out.println(id.toString()+employee);
        employeeDao.modify(id,employee);
        return "redirect:/emps";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        System.out.println(id);
        employeeDao.delete(id);
        return "redirect:/emps";
    }

    @RequestMapping("/user/logout")
    public String logOut(HttpSession session) {
        session.invalidate();
        return "redirect:/index.html";
    }
}
