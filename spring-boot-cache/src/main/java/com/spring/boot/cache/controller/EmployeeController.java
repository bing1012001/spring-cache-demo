package com.spring.boot.cache.controller;

import com.spring.boot.cache.entities.Employee;
import com.spring.boot.cache.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class EmployeeController {

    @Resource
    private EmployeeService employeeService;

    @GetMapping("/getEmployeeById/{id}")
    public Employee getEmployeeById(@PathVariable("id") String id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/update")
    public Employee updateEmployee(Employee employee) {
        return employeeService.updateEmployee(employee);
    }


    @GetMapping("/add")
    public Employee addEmployee(Employee employee) {
        return employeeService.addEmployee(employee);

    }

}
