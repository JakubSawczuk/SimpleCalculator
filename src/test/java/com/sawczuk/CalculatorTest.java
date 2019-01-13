package com.sawczuk;

import com.sawczuk.intputfiles.InputData;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = AppContext.class, loader = AnnotationConfigContextLoader.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class CalculatorTest {
    private static List<InputData> inputDataList = new ArrayList<>();

    @Autowired
    private Calculator calculator;

    @BeforeClass
    public static void init() {
        inputDataList.add(new InputData("add", 10));
        inputDataList.add(new InputData("multiply", 2));
    }

    @Test
    public void returnResult() {
        inputDataList.add(new InputData("apply", 1));
        double result = calculator.returnResult(inputDataList);

        assertEquals(22, result);
    }

    @Test
    public void findFirstValue() {
        assertThrows(NullPointerException.class, () -> {
            calculator.findFirstValue(inputDataList);
        });

        assertDoesNotThrow(() -> {
            inputDataList.add(new InputData("apply", 1));
            calculator.findFirstValue(inputDataList);
        });
    }
}