package com.myhr.api_sd.api_sd.service;

import com.myhr.api_sd.api_sd.model.Departement;
import com.myhr.api_sd.api_sd.repository.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartementService {

    @Autowired
    private DepartementRepository departementRepository;

    public Optional<Departement> getDepartement(Long id){
        return departementRepository.findById(id);
    }

    public Iterable<Departement> getDepartments(){
        return departementRepository.findAll();
    }

    public Departement saveDepartement(Departement departement){
        return departementRepository.save(departement);
    }

    public void deleteDepartement (Long id){
        departementRepository.deleteById(id);
    }

}
