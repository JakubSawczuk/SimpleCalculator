package com.sawczuk;

import com.sawczuk.intputfiles.InputData;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
class CalculatorTest {

    static List<InputData> inputDataList = new ArrayList<>();
    static Calculator calculator;

    @BeforeAll
    static void init() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class);
        calculator = (Calculator) context.getBean("calculator");

        inputDataList.add(new InputData("add", 10));
        inputDataList.add(new InputData("multiply", 2));
    }

    @Test
    void returnResult() {
        inputDataList.add(new InputData("apply", 1));
        double result = calculator.returnResult(inputDataList);

        assertEquals(22, result);
    }

    @Test
    void findFirstValue() {
        assertThrows(NullPointerException.class, () -> {
            calculator.findFirstValue(inputDataList);
        });

        assertDoesNotThrow(() -> {
            inputDataList.add(new InputData("apply", 1));
            calculator.findFirstValue(inputDataList);
        });


    }
}