package com.employee;

public class Employee {
    private int eno;
    private String ename;
    private String designation;
    private String deptName;
    private double salary;

    public Employee() { }

    public Employee(int eno, String ename, String designation, String deptName, double salary) {
        this.eno = eno;
        this.ename = ename;
        this.designation = designation;
        this.deptName = deptName;
        this.salary = salary;
    }

    public int getEno() { return eno; }
    public void setEno(int eno) { this.eno = eno; }
    public String getEname() { return ename; }
    public void setEname(String ename) { this.ename = ename; }
    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }
    public String getDeptName() { return deptName; }
    public void setDeptName(String deptName) { this.deptName = deptName; }
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public String toFileLine() {
        return eno + "," + ename + "," + designation + "," + deptName + "," + salary;
    }

    public static Employee fromFileLine(String line) {
        String[] p = line.split(",");
        return new Employee(Integer.parseInt(p[0]), p[1], p[2], p[3], Double.parseDouble(p[4]));
    }

    public String toString() {
        return "Employee[Eno=" + eno + ", Ename=" + ename + ", Designation=" + designation
                + ", DeptName=" + deptName + ", Salary=" + salary + "]";
    }
}
