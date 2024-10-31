package com.employees.webapp.controller;

import com.employees.webapp.repository.DepartementProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class DepartementController {
    @Autowired
    private DepartementProxy departementProxy;




}
