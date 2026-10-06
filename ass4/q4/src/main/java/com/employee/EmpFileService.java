package com.employee;

import org.springframework.stereotype.Service;
import java.io.*;
import java.util.*;

@Service
public class EmpFileService {
    private static final String FILE = "employees.txt";

    public void save(Employee emp) throws IOException {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE, true)))) {
            out.println(emp.toFileLine());
        }
        System.out.println("Saved: " + emp);
    }

    public List<Employee> getAll() throws IOException {
        List<Employee> list = new ArrayList<>();
        File f = new File(FILE);
        if (!f.exists()) return list;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) list.add(Employee.fromFileLine(line));
            }
        }
        return list;
    }

    public List<Employee> byDept(String dept) throws IOException {
        List<Employee> result = new ArrayList<>();
        for (Employee e : getAll()) {
            if (e.getDeptName().equalsIgnoreCase(dept)) result.add(e);
        }
        return result;
    }
}
