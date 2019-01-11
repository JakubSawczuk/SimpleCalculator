package com.sawczuk.enums;

public enum OperationsE {
    ADDITION("add", "addOperation"),
    MULTIPLY("multiply", "multiplyOperation"),
    DIVIDE("divide", "divideOperation"),
    SUBTRACT("subtract", "subtractOperation"),
    POWER("power", "powerOperation"),
    SQUARE("square", "squareOperation"),
    LOGARITHM("log", "logarithmOperation"),
    APPLY("apply", null);

    private String name;
    private String beanName;

    OperationsE(String name, String beanName) {
        this.name = name;
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }

    public String getName() {
        return name;
    }
}
