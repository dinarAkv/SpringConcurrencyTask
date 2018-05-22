package com.study.task.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/*"})
public class CashServiceImplTest {

    @Autowired
    CashService cashService;

    Map<String, String> expectedCacheVals = new HashMap<>();


    private void writeGeneratedWordsInFile() {
        EntrysGenerator entrysGenerator = new EntrysGenerator();
        entrysGenerator.generateAndWriteInFile(5, 30, "keyVal.txt");
    }

    @Before
    public void prepareToTest() {
        writeGeneratedWordsInFile();
    }


    @Test
    public void getValue() {
        System.out.println("Yes");
        writeGeneratedWordsInFile();
        System.out.println(cashService);

    }
}