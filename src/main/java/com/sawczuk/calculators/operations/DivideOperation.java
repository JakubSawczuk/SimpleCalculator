package com.sawczuk.calculators.operations;

import com.sawczuk.calculators.IOperationStrategy;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class DivideOperation implements IOperationStrategy {
    static final Logger LOGGER = Logger.getLogger(DivideOperation.class.getName());

    @Override
    public double doOperation(double value, double result) {
        if (Double.isInfinite(result / value)) {
            throw new ArithmeticException("Not divide by 0");
        }
        return result / value;
    }
}
