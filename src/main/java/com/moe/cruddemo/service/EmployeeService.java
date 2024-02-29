package com.moe.cruddemo.service;

import com.moe.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}
