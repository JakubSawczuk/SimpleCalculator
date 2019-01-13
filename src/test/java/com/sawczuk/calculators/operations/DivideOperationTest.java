package com.sawczuk.calculators.operations;

import com.sawczuk.AppContext;
import com.sawczuk.calculators.IOperationStrategy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = AppContext.class, loader = AnnotationConfigContextLoader.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class DivideOperationTest {

    @Autowired
    private IOperationStrategy divideOperation;

    @Test
    public void doOperation() {
        assertEquals(10, divideOperation.doOperation(2, 20));
        assertNotEquals(20, divideOperation.doOperation(4, 50));
        assertThrows(ArithmeticException.class, () -> divideOperation.doOperation(0, 50));
    }
}