package com.employees.webapp.repository;

import com.employees.webapp.CustomProperties;
import com.employees.webapp.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
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
        System.out.println("EmployeeProxy *** getEmployeesUrl : " + getEmployeesUrl);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Employee>> response =
                restTemplate.exchange(
                        getEmployeesUrl,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<Iterable<Employee>>() {
                        }
                        );
        System.out.println("EmployeeProxy *** getEmployees response.getBody() : " + response.getBody());
        log.debug("Get Employees call "+response.getStatusCode().toString());
        return response.getBody();
    }

    public Employee getEmployee(final Long id){
        String baseApiUrl=props.getApiUrl();
        String getEmployeeUrl = baseApiUrl + "/employees/"+id;
        System.out.println("EmployeeProxy *** getEmployeeUrl : " + getEmployeeUrl);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Employee> response =
                restTemplate.exchange(
                        getEmployeeUrl,
                        HttpMethod.GET,
                        null,
                        Employee.class
                );
        System.out.println("EmployeeProxy *** getEmployee response.getBody() : " + response.getBody());
        log.debug("Get Employee call "+response.getStatusCode().toString());
        return response.getBody();
    }

    public Employee saveEmployee(Employee employee){
        String baseApiUrl=props.getApiUrl();
        String saveEmployeeUrl = baseApiUrl + "/employees";
        System.out.println("EmployeeProxy *** saveEmployeeUrl : " + saveEmployeeUrl);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Employee> response =
                restTemplate.exchange(
                        saveEmployeeUrl,
                        HttpMethod.POST,
                        new HttpEntity<>(employee),
                        Employee.class
                );

        System.out.println("EmployeeProxy *** saveEmployee response.getBody() : " + response.getBody());
        log.debug("Save Employee call "+response.getStatusCode().toString());
        return response.getBody();
    }

    public Employee updateEmployee(Employee employee){
        String baseApiUrl=props.getApiUrl();
        String updateEmployeeUrl = baseApiUrl + "/employees";
        System.out.println("EmployeeProxy *** updateEmployeeUrl : " + updateEmployeeUrl);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Employee> response =
                restTemplate.exchange(
                        updateEmployeeUrl,
                        HttpMethod.PUT,
                        new HttpEntity<>(employee),
                        Employee.class
                );
        System.out.println("EmployeeProxy *** updateEmployee response.getBody() : " + response.getBody());
        log.debug("Update Employee call "+response.getStatusCode().toString());
        return response.getBody();
    }

    public void deleteEmployee(final Long id){
        String baseApiUrl=props.getApiUrl();
        String deleteEmployeeUrl = baseApiUrl + "/employees/"+id;
        System.out.println("EmployeeProxy *** deleteEmployeeUrl : " + deleteEmployeeUrl);

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
