package com.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmpController {
    @Autowired
    private EmpFileService service;

    @PostMapping
    public String add(@RequestBody Employee emp) throws Exception {
        service.save(emp);
        return "Saved to flat file";
    }

    @GetMapping
    public List<Employee> getAll() throws Exception {
        return service.getAll();
    }

    @GetMapping("/dept/{deptName}")
    public List<Employee> byDept(@PathVariable String deptName) throws Exception {
        return service.byDept(deptName);
    }
}
