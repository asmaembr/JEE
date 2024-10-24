package com.employees.webapp.model;

import lombok.Data;

@Data
public class Employee {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
