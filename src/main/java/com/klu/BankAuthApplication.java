package com.klu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankAuthApplication {

    public static void main(String[] args) {

        SpringApplication.run(
            BankAuthApplication.class, args
        );

        System.out.println("Bank Authentication Application Started!");
    }
}