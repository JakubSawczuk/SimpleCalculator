package com.sawczuk.intputfiles;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InputData)) return false;
        InputData inputData = (InputData) o;
        return Double.compare(inputData.getValue(), getValue()) == 0 &&
                Objects.equals(getOperation(), inputData.getOperation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOperation(), getValue());
    }
}
