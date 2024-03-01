package com.moe.cruddemo.rest;

import com.moe.cruddemo.entity.Employee;
import com.moe.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeRestController {
    private EmployeeService employeeService;

    //constructor injection - EmployeeService
    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //get all employees
    @GetMapping({"/", ""})
    public List<Employee> getAllEmployees() {
        return employeeService.getAll();
    }

    //get employee by id
    @GetMapping("/{employeeId}")
    public Employee getEmployeeById(@PathVariable Integer employeeId) {
        Employee employee = employeeService.findById(employeeId);
        if (employee == null) {
            throw new RuntimeException("Employee id not found: " + employeeId);
        }
        return employee;
    }

    //add mapping for POST/employee - add new employee
    @PostMapping("")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        //also just in case they pass an id in JSON ... set id to 0
        //this is to force a save of new item ... instead of update
        employee.setId(0);
        Employee insertedEmployee = employeeService.save(employee);
        return insertedEmployee;
    }

    //add mapping for PUT/employee - update existing employee
    @PutMapping("")
    public Employee updateEmployee(@RequestBody Employee employee) {
        Employee updatedEmployee = employeeService.save(employee);
        return updatedEmployee;
    }

    //delete mapping for DELETE/employee/{employeeId} - delete by Id
    @DeleteMapping("/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        Employee tempEmployee = employeeService.findById(employeeId);
        //throw exception if null
        if (tempEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        employeeService.deleteById(employeeId);
        
        return "Deleted employee id - " + employeeId;
    }
}
