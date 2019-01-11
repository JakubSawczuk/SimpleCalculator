package com.sawczuk.intputfiles;

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
