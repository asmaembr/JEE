package com.myhr.api_sd.api_sd.controller;

import com.myhr.api_sd.api_sd.model.Departement;
import com.myhr.api_sd.api_sd.service.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/departements")
public class DepartementController {

    @Autowired
    private DepartementService departementService;

    @GetMapping
    public Iterable<Departement> getDepartements(){
        return departementService.getDepartments();
    }

    @GetMapping("{id}")
    public Optional<Departement> getDepartement(@PathVariable Long id){
        return departementService.getDepartement(id);
    }

    @PostMapping
    public Departement saveDepartement(@RequestBody Departement departement){
        return departementService.saveDepartement(departement);
    }

    @PutMapping
    public  Departement updateDepartement(@RequestBody Departement departement){
        return departementService.saveDepartement(departement);
    }
    @DeleteMapping("{id}")
    public void deleteDepartement (@PathVariable Long id){
        departementService.deleteDepartement(id);
    }

}
