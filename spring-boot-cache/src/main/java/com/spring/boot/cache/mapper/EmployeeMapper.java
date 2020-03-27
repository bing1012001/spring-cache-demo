package com.spring.boot.cache.mapper;

import com.spring.boot.cache.entities.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    @Select("SELECT * FROM EMPLOYEE WHERE ID = #{id}")
    public Employee getEmployeeById(String id);

    @Update("UPDATE employee SET last_name = #{lastName}, email = #{email}, gender = #{gender}, department_id = #{department.id}, birthday = #{birthday} WHERE id = #{id}")
    public void updateEmployee(Employee employee);

    @Insert("INSERT INTO EMPLOYEE (ID, LAST_NAME, EMAIL, GENDER, DEPARTMENT_ID, BIRTHDAY) VALUES (#{id}, #{lastName}, #{email}, #{gender}, #{department.id},#{birthday}) ")
    public void addEmployee(Employee employee);

    @Delete("DELETE FROM EMPLOYEE WHERE ID=#{id}")
    void deleteEmployee(String id);

    @Select("SELECT * FROM EMPLOYEE")
    List<Employee> getAllEmployees();

    @Select("SELECT * FROM employee where last_name = #{lastName}")
    public Employee getEmployeeByname(String lastName);
}
