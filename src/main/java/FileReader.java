import enums.OperationsE;
import exceptions.OperationException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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
public class FileReader {
    static final Logger LOGGER = Logger.getLogger(FileReader.class.getName());

    public List<InputData> readFileData() {
        List<InputData> inputDataList = new ArrayList<>();
        try {
            Path path = Paths.get(getClass().getClassLoader().getResource("data.txt").toURI());
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

        inputDataList.forEach(inputData ->
                System.out.println(inputData.getOperation() + " " + inputData.getNumber()));

        return inputDataList;
    }

    private InputData splitLine(String line) {
        String[] params = line.split(" ");
        boolean isExistingOperation = Arrays.stream(OperationsE.values())
                .anyMatch(operationsE -> operationsE.getName().equals(params[0]));
        if (!isExistingOperation) {
            throw new OperationException();
        }
        return new InputData(params[0], Double.parseDouble(params[1]));
    }
}
