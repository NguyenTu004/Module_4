package com.example.thuchanh.controller;

import com.example.thuchanh.model.Employee;
import com.example.thuchanh.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeService employeeService = new EmployeeService();
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    String getHomeEmployee(ModelMap modelMap){
        modelMap.addAttribute("listEmployees",employeeService.findAllEmployees());
        return "home-employee";
    }
    @RequestMapping(value = "/create-form", method = RequestMethod.GET)
    String create(){
        return "create-employee";
    }
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String createEmployee(@RequestParam("name") String name, @RequestParam("salary") double salary ) {
        employeeService.save(name, salary);
        return "redirect:/employee/home";
    }
    @RequestMapping(value = "/update-form/{id}", method = RequestMethod.GET)
    String update(@PathVariable long id, Model model ){
        model.addAttribute("employee",employeeService.findById(id));
        return "update-employee";
    }
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    String updateEmployee(@PathVariable long id,@RequestParam("name") String name ,
                          @RequestParam("salary") double salary){
        Employee employee = employeeService.findById(id);
        employee.setName(name);
        employee.setSalary(salary);
        return "redirect:/employee/home";
    }

}
