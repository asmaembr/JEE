package com.employees.webapp.controller;

import com.employees.webapp.model.Employee;
import com.employees.webapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService service ;

    @GetMapping({"/", "employees"})
    public String employees(Model model) {
        System.out.println("EmployeeController *** employees(Model) ");
        Iterable<Employee> listEmployee = service.getEmployees();
        model.addAttribute("employees", listEmployee);
        return "home";
    }

    @PostMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable("id") final Long id) {
        System.out.println("EmployeeController *** deleteEmployee(Long) ");
        service.deleteEmployee(id);
        return "redirect:/";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute Employee employee) {
        service.saveEmployee(employee);
        return "redirect:/";
    }
    @GetMapping({"/createEmployee/{id}", "/createEmployee"})
    public String createEmployee(@PathVariable(required = false) Long id, Model model) {
        if (id != null) {
            model.addAttribute("employee", service.getEmployee(id));
        } else {
            model.addAttribute("employee", new Employee());
        }
        return "FormEmployee";
    }






}
