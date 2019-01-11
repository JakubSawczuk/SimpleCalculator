package com.sawczuk.calculators.operations;

import com.sawczuk.calculators.IOperationStrategy;
import org.springframework.stereotype.Service;

@Service
public class SquareOperation implements IOperationStrategy {
    @Override
    public double doOperation(double p1, double p2) {
        if (p1 < 0 || Double.isNaN(Math.pow(p2, (1 / p1))) || Double.isInfinite(Math.pow(p2, 1 / p1))) {
            throw new ArithmeticException("Inncoret param in square operation");
        }

        return Math.pow(p2, (1 / p1));
    }
}
