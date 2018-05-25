package com.study.task.task3;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/*"})
public class SpringConflictsResolveTest {

    @Autowired
    @Qualifier("person1")
    public Person personJack;

    @Autowired
    @Qualifier("person2")
    public Person personAlex;


    @Test
    public void testBeansQualifier() {
        Person person1Expected = new Person("Jack", 31);
        Person person2Expected = new Person("Alex", 28);
        assertEquals(person1Expected, personJack);
        assertEquals(person2Expected, personAlex);
    }

    @Autowired
    public Person person3;

    @Test
    public void testConstructorArgsOrderByIndex() {
        Person person3Expected = new Person("Jack", 31 + 10);
        assertEquals(person3Expected, person3);
    }

    @Autowired
    public Person person4;

    @Test
    public void testConstructorArgsOrderByType() {
        Person person4Expected = new Person("Maria", 21, false);
        assertEquals(person4Expected, person4);
    }

    @Autowired
    public Country country;

    @Test
    public void testInjectByType() {
        Country countryExpected = new Country("France", 66900000);
        assertEquals(countryExpected, country);
    }

    @Autowired
    public Weapon sword;

    @Test
    public void testPrimaryAnnotation() {
        assertTrue(sword instanceof Sword);
    }

    @Autowired(required = false)
    public Car car1;


}
