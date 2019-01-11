package com.sawczuk;

import com.sawczuk.calculators.AddOperation;
import com.sawczuk.calculators.MultiplyOperation;
import com.sawczuk.enums.OperationsE;
import jdk.internal.util.xml.impl.Input;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class Calculator {
    static final Logger LOGGER = Logger.getLogger(Calculator.class.getName());
    private InputReader inputReader;
    private List<InputData> inputDataList;

    @Autowired
    private AddOperation addOperation;
    @Autowired
    private MultiplyOperation multiplyOperation;


    @Autowired
    public Calculator(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    public void calculate() {
        inputDataList = inputReader.readFileData();
        double result = returnResult();
        LOGGER.log(Level.INFO, "RESULT is: " + result);
    }

    private double returnResult() {
        double result = findFirstValue();

        for (InputData inputData : inputDataList) {
            String operation = inputData.getOperation();
            double value = inputData.getValue();

            if (operation.equals(OperationsE.ADDITION.getName())) {
                result = addOperation.doOperation(value, result);
            }else if(operation.equals(OperationsE.MULTIPLY.getName())){
                result = multiplyOperation.doOperation(value, result);
            }else{
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
