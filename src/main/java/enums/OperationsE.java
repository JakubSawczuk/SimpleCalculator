package enums;

public enum OperationsE {

    ADDITION("add"),
    MULTIPLY("multiply"),
    APPLY("apply");

    String name;

    OperationsE(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
