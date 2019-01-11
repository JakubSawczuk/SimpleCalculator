package com.sawczuk.calculators.operations;

import com.sawczuk.calculators.IOperationStrategy;
import org.springframework.stereotype.Service;

@Service
public class LogarithmOperation implements IOperationStrategy{
    @Override
    public double doOperation(double p1, double p2) {
        return Math.log(p2) / Math.log(p1);
    }
}
