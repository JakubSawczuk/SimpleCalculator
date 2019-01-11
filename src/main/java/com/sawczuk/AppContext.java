package com.sawczuk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.GenericApplicationContext;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;

@ComponentScan(basePackages = "com.sawczuk")
public class AppContext {

    Calculator calculator;

    @Autowired
    public AppContext(Calculator calculator) {
        this.calculator = calculator;
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class);
        AppContext appx = context.getBean(AppContext.class);
        appx.start();
    }

    private void start(){
        calculator.calculate();
    }
}
