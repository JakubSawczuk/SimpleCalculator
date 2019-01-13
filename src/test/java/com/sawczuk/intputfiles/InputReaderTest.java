package com.sawczuk.intputfiles;

import com.sawczuk.AppContext;
import com.sawczuk.exceptions.OperationException;
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
public class InputReaderTest {

    @Autowired
    private InputReader inputReader;

    @Test
    public void readFileData() {
        assertDoesNotThrow(() -> {
            inputReader.readFileData();
        });
    }

    @Test
    public void splitLine() {
        assertDoesNotThrow(() -> {
            assertTrue(inputReader.splitLine("apply 1").equals(new InputData("apply", 1)));
        });

        assertThrows(OperationException.class, () -> {
            assertTrue(inputReader.splitLine("applyy 1") == null);
        });
    }

    @Test
    public void ifExistApply() {
        List<InputData> inputDataList = new ArrayList<>();
        inputDataList.add(new InputData("add", 10));
        boolean ifNotExistsApply = inputReader.ifExistApply(inputDataList);

        inputDataList.add(new InputData("apply", 1));
        boolean ifExistApply = inputReader.ifExistApply(inputDataList);

        assertEquals(false, ifNotExistsApply);
        assertEquals(true, ifExistApply);
    }

    @Test
    public void getResourcePath() {
        assertDoesNotThrow(() -> {
            inputReader.getResourcePath("example.txt");
        });
    }
}