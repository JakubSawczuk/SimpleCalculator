package com.sawczuk.intputfiles;

import com.sawczuk.AppContext;
import com.sawczuk.exceptions.OperationException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
class InputReaderTest {

    @Autowired
    static InputReader inputReader;

    @BeforeAll
    static void init() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class);
        inputReader = (InputReader) context.getBean("inputReader");
    }

    @Test
    void readFileData() {
        assertDoesNotThrow(() -> {
            inputReader.readFileData();
        });
    }

    @Test
    void splitLine() {
        assertDoesNotThrow(() -> {
            inputReader.splitLine("apply 1");
        });

        assertThrows(OperationException.class, () -> {
            inputReader.splitLine("applyy 1");
        });
    }

    @Test
    void ifExistApply() {
        List<InputData> inputDataList = new ArrayList<>();
        inputDataList.add(new InputData("add", 10));
        boolean ifNotExistsApply = inputReader.ifExistApply(inputDataList);

        inputDataList.add(new InputData("apply", 1));
        boolean ifExistApply = inputReader.ifExistApply(inputDataList);

        assertEquals(false, ifNotExistsApply);
        assertEquals(true, ifExistApply);
    }

    @Test
    void getResourcePath() {
        assertDoesNotThrow(() -> {
            Paths.get(getClass().getClassLoader().getResource("example.txt").toURI());
        });
    }
}