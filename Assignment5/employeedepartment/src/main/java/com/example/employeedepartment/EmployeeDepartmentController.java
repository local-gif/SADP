package com.example.employeedepartment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeDepartmentController {

    private static final String FILE_NAME = "employees.txt";


    @GetMapping("/employees/department/{deptName}")
    public ArrayList<String> getEmployeesByDepartment(
            @PathVariable String deptName) {

        ArrayList<String> employees = new ArrayList<>();

        try {

            BufferedReader reader =
                    new BufferedReader(new FileReader(FILE_NAME));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length == 5) {

                    String employeeDepartment =
                            data[3].trim();

                    if (employeeDepartment.equalsIgnoreCase(deptName)) {

                        employees.add(line);
                    }
                }
            }

            reader.close();

        } catch (IOException e) {

            employees.add("Error reading employee file.");
        }

        if (employees.isEmpty()) {

            employees.add(
                "No employees found in department: " + deptName
            );
        }

        return employees;
    }
}