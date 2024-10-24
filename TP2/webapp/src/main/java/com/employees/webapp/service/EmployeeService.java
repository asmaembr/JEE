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

    public Employee getEmployee(final Integer id) {
        return employeeProxy.getEmployee(id);
    }

}
