package com.sawczuk.calculators.operations;

import com.sawczuk.AppContext;
import com.sawczuk.calculators.IOperationStrategy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ContextConfiguration(classes = AppContext.class, loader = AnnotationConfigContextLoader.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class SubtractOperationTest {

    @Autowired
    private IOperationStrategy subtractOperation;

    @Test
    public void doOperation() {
        assertEquals(10, subtractOperation.doOperation(15, 25));
        assertNotEquals(3, subtractOperation.doOperation(10, 8));
    }
}