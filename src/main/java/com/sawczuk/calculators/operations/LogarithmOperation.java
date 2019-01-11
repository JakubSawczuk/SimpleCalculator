package com.sawczuk.calculators.operations;

import com.sawczuk.calculators.IOperationStrategy;
import org.springframework.stereotype.Service;

@Service
public class LogarithmOperation implements IOperationStrategy{
    @Override
    public double doOperation(double value, double result) {
        if (Double.isInfinite(Math.log(result) / Math.log(value))
                || Double.isNaN(Math.log(result) / Math.log(value)) || (Math.log(result) / Math.log(value) == -0)) {
            throw new ArithmeticException("Inncoret param in log operation");
        }

        return Math.log(result) / Math.log(value);
    }
}
