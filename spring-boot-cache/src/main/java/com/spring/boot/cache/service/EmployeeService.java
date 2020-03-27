package com.spring.boot.cache.service;

import com.spring.boot.cache.entities.Employee;
import com.spring.boot.cache.mapper.EmployeeMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
//@CacheConfig(cacheNames = "emp") when this one is defined, all the cache usage doesn't need to add cacheNames or value.
public class EmployeeService {

    @Resource
    private EmployeeMapper employeeMapper;

    /**
     * "#root.args[0]" is to load the first parameter as key
     * "#id" is using ID as the cache key
     * "#root.method + '[' + #id + ']'" is using getEmployeeById[#id] as cache key
     * @param id
     * @return
     */
    @Cacheable(cacheNames = "emp", key = "#id" )
    public Employee getEmployeeById(String id) {
        Employee employee = employeeMapper.getEmployeeById(id);
        log.info(employee.toString());
        return employee;
    }

    @CachePut(value = "emp", key = "#employee.id")
    public Employee addEmployee(Employee employee) {
        employeeMapper.addEmployee(employee);
        return employee;
    }

    /**
     * cacheput working procedure is to do all the things first, and then add the return object into cache
     * @param employee
     * @return
     */
    @CachePut(cacheNames = "emp", key = "#employee.id" /*"#result.id" it is same as employee.id, but it is using the returning object*/)
    public Employee updateEmployee(Employee employee) {
        employeeMapper.updateEmployee(employee);
        return employee;
    }

    public List<Employee> getAllEmployee() {
        List<Employee> allEmployees = employeeMapper.getAllEmployees();
        allEmployees.stream()
                    .forEach(x -> log.info(x.toString()));
        return allEmployees;
    }

    @CacheEvict(cacheNames = "emp", key = "#id")
    public void deleteEmployee(String id) {
        employeeMapper.deleteEmployee(id);

    }
    @Caching(
            cacheable = {
                    @Cacheable(cacheNames = "emp", key = "#lastName")
            },
            put = {
                    @CachePut(cacheNames = "emp", key = "#result.id"),
                    @CachePut(value = "emp", key = "#result.email")
            }
    )
    public Employee getEmployeeByName(String lastName) {
        return employeeMapper.getEmployeeByname(lastName);
    }
}
