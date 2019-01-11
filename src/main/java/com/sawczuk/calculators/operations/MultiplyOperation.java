package com.sawczuk.calculators.operations;

import com.sawczuk.calculators.IOperationStrategy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class MultiplyOperation implements IOperationStrategy {
    @Override
    public double doOperation(double p1, double p2) {
        return p1*p2;
    }
}
