package com.love2code.springboot.cruddemo.services;

import com.love2code.springboot.cruddemo.model.Employee;

import java.util.List;

public interface EmployeeServices {
    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}
