package com.spring.boot.cache.redis;

import com.spring.boot.cache.entities.Employee;
import com.spring.boot.cache.mapper.EmployeeMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;
import sun.tools.jconsole.inspector.XObject;

import javax.annotation.Resource;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private RedisTemplate<String, Employee> empRedisTemplate;

    @Resource
    private EmployeeMapper employeeMapper;


    @Before
    public void setup() {
        Assert.assertNotNull(redisTemplate);
        Assert.assertNotNull(stringRedisTemplate);
        Assert.assertNotNull(employeeMapper);
    }

    @Test
    public void test() {
        stringRedisTemplate.opsForValue().set("k1", "test1");
        redisTemplate.opsForValue().set("k2","12345");
        String k2 = (String)redisTemplate.opsForValue().get("k2");
        log.info(k2);


    }

    @Test
    public void testSet() {
        Employee employee = employeeMapper.getEmployeeById("9b887a84-ff7c-47e1-929a-0bb78f317792");
        log.info(employee.toString());
        redisTemplate.opsForValue().set("emp-01", employee);
        Employee employee1 = (Employee) redisTemplate.opsForValue().get("emp-01");
        log.info(employee1.toString());

        empRedisTemplate.opsForValue().set("emp-02", employee);
        Employee employee2 = (Employee) empRedisTemplate.opsForValue().get("emp-02");
        log.info(employee2.toString());


    }

}
