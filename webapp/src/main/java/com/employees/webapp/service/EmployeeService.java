package com.employees.webapp.service;

import com.employees.webapp.model.Employee;
import com.employees.webapp.repository.EmployeeProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class EmployeeService {

    @Autowired
    private EmployeeProxy employeeProxy;

    public Employee getEmployee(final Long id) {
        return employeeProxy.getEmployee(id);
    }
    public Iterable<Employee> getEmployees() {
        return employeeProxy.getEmployees();
    }

    public void deleteEmployee(final Long id) {
        employeeProxy.deleteEmployee(id);
    }

    public Employee saveEmployee(Employee employee){
        Employee savedEmployee;
        employee.setLastName(employee.getLastName().toUpperCase());
        if(employee.getId()==null){
            savedEmployee = employeeProxy.saveEmployee(employee);
        }
        else {
            savedEmployee = employeeProxy.updateEmployee(employee);
        }
        return savedEmployee;
    }

}
