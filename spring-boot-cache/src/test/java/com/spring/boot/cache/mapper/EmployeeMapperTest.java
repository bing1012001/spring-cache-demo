package com.spring.boot.cache.mapper;

import com.spring.boot.cache.entities.Employee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeMapperTest {

    @Resource
    private EmployeeMapper employeeMapper;


    @Before
    public void setup() {
        Assert.assertNotNull(employeeMapper);
    }

    @Test
    public void test() {
        Employee employee = employeeMapper.getEmployeeById("9b887a84-ff7c-47e1-929a-0bb78f317792");
        Assert.assertNotNull(employee);
        Assert.assertEquals("Test1", employee.getLastName());
    }
}
