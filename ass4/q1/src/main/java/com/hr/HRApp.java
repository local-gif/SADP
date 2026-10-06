package com.hr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HRApp {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        EmpService service = ctx.getBean(EmpService.class);
        System.out.println("=== HR App ===\n");
        service.add(new Employee(101, "Rahul", "Developer", "IT", 50000));
        service.add(new Employee(102, "Priya", "HR Manager", "HR", 60000));
        service.add(new Employee(103, "Amit", "Accountant", "Finance", 45000));
        service.display();
        System.out.println("\nFind 102: " + service.find(102));
        service.remove(103);
        service.display();
        ((AnnotationConfigApplicationContext) ctx).close();
    }
}
