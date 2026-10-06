package com.erp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ErpApp {
    public static void main(String[] args) {
        SpringApplication.run(ErpApp.class, args);
        System.out.println("ERP: http://localhost:8080/api/erp/");
    }
}
