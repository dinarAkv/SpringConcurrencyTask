package com.study.task.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring-servlet.xml"})
@ContextConfiguration(locations = {"classpath:spring/*"})
public class CashServiceImplTest {

    @Autowired
    CashService cashService;

    @Test
    public void getValue() {
        System.out.println("Yes");
        System.out.println(cashService);
    }
}