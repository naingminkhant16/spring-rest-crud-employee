package com.moe.cruddemo.dao;

import com.moe.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAll();

    Employee findById(Integer id);
}
