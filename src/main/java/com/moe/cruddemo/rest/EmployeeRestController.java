package com.moe.cruddemo.rest;

import com.moe.cruddemo.entity.Employee;
import com.moe.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeRestController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping({"/", ""})
    public List<Employee> getAllEmployees() {
        return employeeService.getAll();
    }

    @GetMapping("/{employeeId}")
    public Employee getById(@PathVariable Integer employeeId) {
        return employeeService.findById(employeeId);
    }
}
