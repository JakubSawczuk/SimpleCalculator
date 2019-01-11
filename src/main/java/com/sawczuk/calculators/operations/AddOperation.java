package com.sawczuk.calculators.operations;

import com.sawczuk.calculators.IOperationStrategy;
import org.springframework.stereotype.Service;

@Service
public class AddOperation implements IOperationStrategy {
    @Override
    public double doOperation(double value, double result) {
        return value + result;
    }
}
