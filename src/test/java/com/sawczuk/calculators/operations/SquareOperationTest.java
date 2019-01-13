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
public class SquareOperationTest {

    @Autowired
    private IOperationStrategy squareOperation;

    @Test
    public void doOperation() {
        assertDoesNotThrow(() -> {
            assertEquals(10, squareOperation.doOperation(2, 100));
            assertNotEquals(20, squareOperation.doOperation(2, 101));
        });
    }
}