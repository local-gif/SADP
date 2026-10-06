package com.hr;

public class Employee {
    private int empId;
    private String name;
    private String designation;
    private String department;
    private double salary;

    public Employee() { }

    public Employee(int empId, String name, String designation, String department, double salary) {
        this.empId = empId;
        this.name = name;
        this.designation = designation;
        this.department = department;
        this.salary = salary;
    }

    public int getEmpId() { return empId; }
    public void setEmpId(int empId) { this.empId = empId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public String toString() {
        return "Employee[id=" + empId + ", name=" + name + ", designation=" + designation
                + ", dept=" + department + ", salary=" + salary + "]";
    }
}
