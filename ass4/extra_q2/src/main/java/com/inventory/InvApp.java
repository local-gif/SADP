package com.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InvApp {
    public static void main(String[] args) {
        SpringApplication.run(InvApp.class, args);
        System.out.println("Inventory: http://localhost:8080/api/inventory");
    }
}
