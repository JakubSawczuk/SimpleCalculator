package com.sawczuk.calculators;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class AddOperation implements IOperationStrategy {
    @Override
    public double doOperation(double p1, double p2) {
        return p1+p2;
    }
}
