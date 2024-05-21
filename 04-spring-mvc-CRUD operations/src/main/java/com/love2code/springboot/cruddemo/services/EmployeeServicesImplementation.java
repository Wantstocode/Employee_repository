package com.love2code.springboot.cruddemo.services;

import com.love2code.springboot.cruddemo.model.Employee;
import com.love2code.springboot.cruddemo.jparepository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServicesImplementation implements EmployeeServices{
    private EmployeeRepository employeeRepository;

    //inject employee DAO
    @Autowired
    public EmployeeServicesImplementation(EmployeeRepository theEmployeeRepository){
        employeeRepository=theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {

        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);
        Employee theEmployee;

        if(result!=null) {
            theEmployee = result.get();
            return theEmployee;
        }
        else
            return null;
    }

    @Override
    @Transactional
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }

}
