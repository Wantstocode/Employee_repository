package com.love2code.springboot.cruddemo.controller;
import com.love2code.springboot.cruddemo.model.Employee;
import com.love2code.springboot.cruddemo.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeServices employeeServices;

    //inject employeee service

    @Autowired
    public EmployeeController(EmployeeServices theemployeeservice){
        employeeServices=theemployeeservice;
    }

    @GetMapping("/addform")
    public String showFormForAdd(Model theModel){
        Employee theEmployee=new Employee();
        theModel.addAttribute("employee",theEmployee);
        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String add(@ModelAttribute ("employee")Employee theEmployee ){

        employeeServices.save(theEmployee);
        return "redirect:/employees/list";
    }

    @GetMapping("/list")
    public String findAll(Model theModel){
        List<Employee> employeesList=employeeServices.findAll();
        theModel.addAttribute("theEmployees",employeesList);
        return "employees/employee-list";
    }

    @GetMapping("/update")
    public String update(@RequestParam("employeeid") int employeeId,Model theModel){
        Employee theEmployee=employeeServices.findById(employeeId);
        theModel.addAttribute("employee",theEmployee);
        return "employees/employee-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeid") int employeeId,Model theModel){
        Employee theEmployee=employeeServices.findById(employeeId);
        if(theEmployee==null)
            throw new RuntimeException("employee not found with id"+ employeeId);
        employeeServices.deleteById(employeeId);

        return "redirect:/employees/list";
    }
}
