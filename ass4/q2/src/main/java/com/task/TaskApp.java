package com.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskApp {
    public static void main(String[] args) {
        SpringApplication.run(TaskApp.class, args);
        System.out.println("Task API: http://localhost:8081/api/tasks");
    }
}
