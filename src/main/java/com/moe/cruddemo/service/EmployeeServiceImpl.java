package com.moe.cruddemo.service;

import com.moe.cruddemo.dao.EmployeeRepository;
import com.moe.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    //constructor injection - EmployeeDAO
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {

        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if (optionalEmployee.isPresent())
            return optionalEmployee.get();
        else
            throw new RuntimeException("Employee not found with id : " + id);
    }

    //transactional boundaries in service layer, not in DAO layer for best practice
    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    //transactional boundaries in service layer , not in DAO layer for best practice
    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
