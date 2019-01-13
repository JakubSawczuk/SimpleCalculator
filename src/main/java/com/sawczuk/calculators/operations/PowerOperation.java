package com.sawczuk.calculators.operations;

import com.sawczuk.calculators.IOperationStrategy;
import org.springframework.stereotype.Service;

@Service
public class PowerOperation implements IOperationStrategy {
    @Override
    public double doOperation(double value, double result) {
        if (Double.isInfinite(Math.pow(result, value)) || Double.isNaN(Math.pow(result, value))) {
            throw new ArithmeticException("Incorrect param in log operation");
        }

        return Math.pow(result, value);
    }
}
