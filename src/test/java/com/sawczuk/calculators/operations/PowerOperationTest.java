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
public class PowerOperationTest {

    @Autowired
    private IOperationStrategy powerOperation;

    @Test
    public void doOperation() {
        assertDoesNotThrow(() -> {
            assertEquals(100, powerOperation.doOperation(2, 10));
            assertNotEquals(100, powerOperation.doOperation(2, 11));
        });
    }
}