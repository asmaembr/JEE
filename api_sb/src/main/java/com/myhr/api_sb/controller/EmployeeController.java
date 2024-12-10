package com.myhr.api_sb.controller;

import com.myhr.api_sb.model.Employee;
import com.myhr.api_sb.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@EnableCircuitBreaker
@Configuration
@EnableHystrixDashboard
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Hystrix

    @GetMapping("/employees")
    public Iterable<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/employees/{id}")
    public Optional<Employee> getEmployee(@PathVariable final Long id) {
        return employeeService.getEmployee(id);
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee( @RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }
    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable final Long id) {
        employeeService.deleteEmployee(id);
    }




}
