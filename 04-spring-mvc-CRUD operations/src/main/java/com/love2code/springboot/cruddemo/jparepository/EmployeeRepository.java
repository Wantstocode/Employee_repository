package com.love2code.springboot.cruddemo.jparepository;

import com.love2code.springboot.cruddemo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
