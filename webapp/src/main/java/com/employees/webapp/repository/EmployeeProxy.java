package com.employees.webapp.repository;

import com.employees.webapp.CustomProperties;
import com.employees.webapp.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class EmployeeProxy {
    @Autowired
    private CustomProperties props;

    public Iterable<Employee> getEmployees(){
        String baseApiUrl=props.getApiUrl();
        String getEmployeesUrl = baseApiUrl + "/employees";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Employee>> response =
                restTemplate.exchange(
                        getEmployeesUrl,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<Iterable<Employee>>() {
                        }
                        );
        log.debug("Get Employees call "+response.getStatusCode().toString());
        return response.getBody();
    }

    public Employee getEmployee(final Long id){
        String baseApiUrl=props.getApiUrl();
        String getEmployeeUrl = baseApiUrl + "/employees/"+id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Employee> response =
                restTemplate.exchange(
                        getEmployeeUrl,
                        HttpMethod.GET,
                        null,
                        Employee.class
                );
        log.debug("Get Employee call "+response.getStatusCode().toString());
        return response.getBody();
    }

    public Employee saveEmployee(Employee employee){
        String baseApiUrl=props.getApiUrl();
        String saveEmployeeUrl = baseApiUrl + "/employees";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Employee> response =
                restTemplate.exchange(
                        saveEmployeeUrl,
                        HttpMethod.POST,
                        new HttpEntity<>(employee),
                        Employee.class
                );

        log.debug("Save Employee call "+response.getStatusCode().toString());
        return response.getBody();
    }

    public Employee updateEmployee(Employee employee){
        String baseApiUrl=props.getApiUrl();
        String updateEmployeeUrl = baseApiUrl + "/employees";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Employee> response =
                restTemplate.exchange(
                        updateEmployeeUrl,
                        HttpMethod.PUT,
                        new HttpEntity<>(employee),
                        Employee.class
                );
        log.debug("Update Employee call "+response.getStatusCode().toString());
        return response.getBody();
    }

    public void deleteEmployee(final Long id){
        String baseApiUrl=props.getApiUrl();
        String deleteEmployeeUrl = baseApiUrl + "/employees/"+id;

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.exchange(
                deleteEmployeeUrl,
                HttpMethod.DELETE,
                null,
                Void.class
        );
        log.debug("Delete Employee call ");
    }
}
