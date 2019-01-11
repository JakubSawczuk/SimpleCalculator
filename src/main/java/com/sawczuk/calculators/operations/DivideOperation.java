package com.sawczuk.calculators.operations;

import com.sawczuk.calculators.IOperationStrategy;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class DivideOperation implements IOperationStrategy {
    static final Logger LOGGER = Logger.getLogger(DivideOperation.class.getName());

    @Override
    public double doOperation(double p1, double p2) {
        if(Double.isInfinite(p2/p1)){
            throw new ArithmeticException("Divide by 0");
        }
        return p2/p1;
    }
}
