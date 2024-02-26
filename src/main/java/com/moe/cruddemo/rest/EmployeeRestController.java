package com.moe.cruddemo.rest;

import com.moe.cruddemo.dao.EmployeeDAO;
import com.moe.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeRestController {
    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeRestController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @GetMapping("")
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAll();
    }

    @GetMapping("/{employeeId}")
    public Employee getById(@PathVariable Integer employeeId) {
        return employeeDAO.findById(employeeId);
    }
}
