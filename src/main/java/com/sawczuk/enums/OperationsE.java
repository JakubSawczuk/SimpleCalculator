package com.sawczuk.enums;

public enum OperationsE {

    ADDITION("add"),
    MULTIPLY("multiply"),
    DIVIDE("divide"),
    SUBTRACT("subtract"),
    POWER("power"),
    SQUARE("square"),
    LOGARITHM("log"),
    APPLY("apply");

    private String name;

    OperationsE(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
