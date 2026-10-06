package com.example.studentmanagement;

import java.util.ArrayList;
import java.util.regex.Pattern;

import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    private ArrayList<Student> students = new ArrayList<>();

    // Add Student
    @PostMapping("/students")
    public String addStudent(@RequestBody Student student) {

        // Validate roll number
        if (student.getRollNo() <= 0) {
            return "Roll number must be greater than 0.";
        }

        // Validate name
        if (student.getName() == null || 
        !Pattern.matches("^[A-Za-z ]+$", student.getName().trim()))
            {
            return "Student name must contain at least 3 characters.";
        }

        // Validate email
        if (student.getEmail() == null ||
            !Pattern.matches(
                "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$",
                student.getEmail())) {

            return "Please enter a valid email address.";
        }

        // Validate course
        if (student.getCourse() == null ||
            student.getCourse().trim().isEmpty()) {

            return "Course cannot be empty.";
        }

        // Validate semester
        if (student.getSemester() < 1 ||
            student.getSemester() > 6) {

            return "Semester must be between 1 and 6.";
        }

        // Check duplicate roll number
        for (Student s : students) {

            if (s.getRollNo() == student.getRollNo()) {
                return "Student with this roll number already exists.";
            }
        }

        students.add(student);

        return "Student added successfully.";
    }


    // Display all students
    @GetMapping("/students")
    public ArrayList<Student> getAllStudents() {

        return students;
    }


    // Search student by roll number
    @GetMapping("/students/{rollNo}")
    public Object getStudent(@PathVariable int rollNo) {

        for (Student student : students) {

            if (student.getRollNo() == rollNo) {
                return student;
            }
        }

        return "Student not found.";
    }


    // Delete student
    @DeleteMapping("/students/{rollNo}")
    public String deleteStudent(@PathVariable int rollNo) {

        for (Student student : students) {

            if (student.getRollNo() == rollNo) {

                students.remove(student);

                return "Student deleted successfully.";
            }
        }

        return "Student not found.";
    }
}