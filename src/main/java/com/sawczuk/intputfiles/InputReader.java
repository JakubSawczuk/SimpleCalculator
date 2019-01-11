package com.sawczuk.intputfiles;

import com.sawczuk.enums.OperationsE;
import com.sawczuk.exceptions.OperationException;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class InputReader {
    static final Logger LOGGER = Logger.getLogger(InputReader.class.getName());

    public List<InputData> readFileData() {
        List<InputData> inputDataList = new ArrayList<>();
        try {
            Path path = Paths.get(getClass().getClassLoader().getResource("example.txt").toURI());
            BufferedReader r = Files.newBufferedReader(path, StandardCharsets.UTF_8);
            r.lines().forEach(s -> {
                inputDataList.add(splitLine(s));
            });

        } catch (URISyntaxException e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        } catch (IOException e1) {
            LOGGER.log(Level.SEVERE, e1.toString(), e1);
        } catch (NumberFormatException e2) {
            LOGGER.log(Level.SEVERE, e2.toString(), e2);
        }

        if (!ifExistApply(inputDataList)) {
            throw new OperationException("Field does not have the operation: APPLY");
        }

        return inputDataList;
    }

    private InputData splitLine(String line) {
        String[] params = line.split("\\s+");
        boolean isExistOperation = Arrays.stream(OperationsE.values())
                .anyMatch(operationsE -> operationsE.getName().equals(params[0]));

        if (!isExistOperation) {
            throw new OperationException("Fail operation - check calculators input");
        }
        return new InputData(params[0], Double.parseDouble(params[1]));
    }

    private boolean ifExistApply(List<InputData> inputDataList) {
        return inputDataList.parallelStream()
                .anyMatch(inputData -> inputData.getOperation().equals(OperationsE.APPLY.getName()));
    }
}
