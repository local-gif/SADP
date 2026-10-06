package com.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Scanner;

@SpringBootApplication
public class EmpApp implements CommandLineRunner {
    @Autowired
    private EmpFileService service;

    public static void main(String[] args) {
        SpringApplication.run(EmpApp.class, args);
    }

    public void run(String... args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n=== Employee Flat File ===");
        System.out.print("Eno: ");
        int eno = Integer.parseInt(sc.nextLine());
        System.out.print("Ename: ");
        String ename = sc.nextLine();
        System.out.print("Designation: ");
        String desig = sc.nextLine();
        System.out.print("DeptName: ");
        String dept = sc.nextLine();
        System.out.print("Salary: ");
        double sal = Double.parseDouble(sc.nextLine());
        service.save(new Employee(eno, ename, desig, dept, sal));
        System.out.println("\nAll employees:");
        for (Employee e : service.getAll()) System.out.println(e);
    }
}
