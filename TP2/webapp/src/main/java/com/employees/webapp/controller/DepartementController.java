package com.employees.webapp.controller;

import com.employees.webapp.model.Departement;
import com.employees.webapp.model.Employee;
import com.employees.webapp.service.DepartementService;
import com.employees.webapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/departements")
public class DepartementController {

    @Autowired
    private DepartementService service ;

    @GetMapping()
    public String departements(Model model) {
        Iterable<Departement> listdepartement = service.getDepartements();
        model.addAttribute("departements", listdepartement);
        return "departement";
    }

    @PostMapping("/deleteDepartement/{id}")
    public String deleteDepartement(@PathVariable("id") final Long id) {
        service.deleteDepartement(id);
        return "redirect:/departements";
    }

    @PostMapping("/saveDepartement")
    public String saveDepartement(@ModelAttribute Departement departement) {
        service.saveDepartement(departement);
        return "redirect:/departements";
    }
    @GetMapping({"/createDepartement/{id}", "/createDepartement"})
    public String createDepartement(@PathVariable(required = false) Long id, Model model) {
        if (id != null) {
            model.addAttribute("departement", service.getDepartement(id));
        } else {
            model.addAttribute("departement", new Departement());
        }
        return "FormDepartement";
    }




}
