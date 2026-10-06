package com.hr;

import java.util.ArrayList;
import java.util.List;

public class EmpService {
    private List<Employee> list = new ArrayList<>();

    public void add(Employee emp) {
        list.add(emp);
        System.out.println("Added: " + emp);
    }

    public void remove(int empId) {
        list.removeIf(e -> e.getEmpId() == empId);
        System.out.println("Removed id: " + empId);
    }

    public Employee find(int empId) {
        for (Employee e : list) {
            if (e.getEmpId() == empId) return e;
        }
        return null;
    }

    public List<Employee> getAll() { return list; }

    public void display() {
        System.out.println("\n--- All Employees ---");
        for (Employee e : list) System.out.println(e);
    }
}
