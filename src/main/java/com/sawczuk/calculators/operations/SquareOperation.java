package com.sawczuk.calculators.operations;

import com.sawczuk.calculators.IOperationStrategy;
import org.springframework.stereotype.Service;

@Service
public class SquareOperation implements IOperationStrategy {
    @Override
    public double doOperation(double value, double result) {
        if (Double.isNaN(Math.pow(result, (1.0 / value))) || Double.isInfinite(Math.pow(result, 1.0 / value))) {
            throw new ArithmeticException("Inncoret param in square operation");
        }

        return Math.pow(result, (1.0 / value));
    }
}
