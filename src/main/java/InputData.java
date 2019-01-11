import org.springframework.stereotype.Service;

public class InputData {
    private String operation;
    private double number;

    public InputData(String operation, double number) {
        this.operation = operation.toLowerCase();
        this.number = number;
    }

    public double getNumber() {
        return number;
    }

    public String getOperation() {
        return operation;
    }
}
