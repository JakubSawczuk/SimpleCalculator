package com.sawczuk.intputfiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
public class InputData {
    private String operation;
    private double value;

    public InputData(String operation, double value) {
        this.operation = operation;
        this.value = value;
    }

    public String getOperation() {
        return operation;
    }

    public double getValue() {
        return value;
    }

}
