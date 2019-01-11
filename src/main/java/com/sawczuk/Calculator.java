package com.sawczuk;

import com.sawczuk.calculators.IOperationStrategy;
import com.sawczuk.enums.OperationsE;
import com.sawczuk.intputfiles.InputData;
import com.sawczuk.intputfiles.InputReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class Calculator {
    private static final Logger LOGGER = Logger.getLogger(Calculator.class.getName());

    private InputReader inputReader;
    private List<InputData> inputDataList;
    private Map<String, IOperationStrategy> operationStrategies;

    @Autowired
    public Calculator(InputReader inputReader, Map<String, IOperationStrategy> operationStrategies) {
        this.inputReader = inputReader;
        this.operationStrategies = operationStrategies;
    }

    public void calculate() {
        inputDataList = inputReader.readFileData();
        LOGGER.log(Level.INFO, "RESULT is: " + returnResult());
    }

    private double returnResult() {
        double result = findFirstValue();
        for (InputData inputData : inputDataList) {
            String operation = inputData.getOperation();
            double value = inputData.getValue();

            if (operation.equals(OperationsE.ADDITION.getName())) {
                result = operationStrategies.get(OperationsE.ADDITION.getBeanName()).doOperation(value,result);
            } else if (operation.equals(OperationsE.SUBTRACT.getName())) {
                result = operationStrategies.get(OperationsE.SUBTRACT.getBeanName()).doOperation(value,result);
            } else if (operation.equals(OperationsE.MULTIPLY.getName())) {
                result = operationStrategies.get(OperationsE.MULTIPLY.getBeanName()).doOperation(value,result);
            } else if (operation.equals(OperationsE.DIVIDE.getName())) {
                result = operationStrategies.get(OperationsE.DIVIDE.getBeanName()).doOperation(value,result);
            } else if (operation.equals(OperationsE.POWER.getName())) {
                result = operationStrategies.get(OperationsE.POWER.getBeanName()).doOperation(value,result);
            } else if (operation.equals(OperationsE.SQUARE.getName())) {
                result = operationStrategies.get(OperationsE.SQUARE.getBeanName()).doOperation(value,result);
            } else if (operation.equals(OperationsE.LOGARITHM.getName())) {
                result = operationStrategies.get(OperationsE.LOGARITHM.getBeanName()).doOperation(value,result);
            } else {
                return result;
            }
        }
        return result;
    }

    private double findFirstValue() {
        return inputDataList.stream()
                .filter(inputData -> inputData.getOperation().equals(OperationsE.APPLY.getName()))
                .findFirst()
                .get()
                .getValue();
    }
}
