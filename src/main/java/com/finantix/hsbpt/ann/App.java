package com.finantix.hsbpt.ann;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.finantix.mock.hsbc.ann.rest.AnnModelController;

@SpringBootApplication
@ComponentScan(basePackageClasses = AnnModelController.class)
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
