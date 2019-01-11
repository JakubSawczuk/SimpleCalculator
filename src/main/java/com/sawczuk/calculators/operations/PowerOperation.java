package com.sawczuk.calculators.operations;

import com.sawczuk.calculators.IOperationStrategy;
import org.springframework.stereotype.Service;

@Service
public class PowerOperation implements IOperationStrategy {
    @Override
    public double doOperation(double p1, double p2) {
        return Math.pow(p2, p1);
    }
}
