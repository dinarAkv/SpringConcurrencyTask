package com.study.task.task4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-context.xml"})
public class BeanScopeTest {

    @Autowired
    public Animal animal1; // Singleton scope.

    @Autowired
    public Animal animal2;

    @Autowired
    public Book book1; // Prototype scope.

    @Autowired
    public Book book2;

    @Autowired
    public Book book3;

    @Test
    public void testBeanScopes() {
        int beanCreationAnimalExpected = 1;
        assertTrue(beanCreationAnimalExpected == Animal.getBeanCreationCounter());

        int beanCreationBookExpected = 3;
        assertTrue(beanCreationBookExpected == Book.getBeanCreationCounter());
    }
}
