package com.cydeo.controller;


import com.cydeo.bootstrap.DataGenerator;
import com.cydeo.model.Employee;
import com.cydeo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService; //for dependency injection

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/register")
    public String createEmployee(Model model){

        model.addAttribute("employee", new Employee());
        model.addAttribute("stateList", DataGenerator.getAllStates());

        return "/employee/employee-create";

    }

    @PostMapping("/insert")
    public String insertEmployee(@ModelAttribute("employee") @Valid Employee employee, BindingResult bindingResult, Model model){ //added @Valid to make controller be aware of the validations in Employee class
        //you need to add BindingResult parameter after the object

        if (bindingResult.hasErrors()){ //if there is any error in Employee obj fileds related with validation
            model.addAttribute("stateList", DataGenerator.getAllStates());
            return "employee/employee-create";
        }
        employeeService.saveEmployee(employee);
        return "redirect:/employee/list"; //it will redirect this to below method (page as a result)
        //with redirect we are using endpoints
    }

    @GetMapping("/list")
    public String listEmployees(Model model){
        model.addAttribute("employeeList", employeeService.readAllEmployees());

        return "employee/employee-list"; //without redirect we are usuing html file paths
    }
}
