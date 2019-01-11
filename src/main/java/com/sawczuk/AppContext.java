package com.sawczuk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.sawczuk")
public class AppContext {

    private Calculator calculator;

    @Autowired
    public AppContext(Calculator calculator) {
        this.calculator = calculator;
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class);
        AppContext appx = context.getBean(AppContext.class);
        appx.start();
    }

    private void start() {
        calculator.calculate();
    }
}
