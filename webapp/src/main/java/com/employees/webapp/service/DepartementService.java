package com.employees.webapp.service;

import com.employees.webapp.model.Departement;
import com.employees.webapp.repository.DepartementProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class DepartementService {

    @Autowired
    private DepartementProxy departementProxy;

    public Departement getDepartement(final Long id) {
        System.out.println("DepartementService *** getDepartement(Long) ");
        return departementProxy.getDepartement(id);
    }
    public Iterable<Departement> getDepartements() {
        return departementProxy.getDepartements();
    }

    public void deleteDepartement(final Long id) {
        departementProxy.deleteDepartement(id);
    }

    public Departement saveDepartement(Departement departement){
        Departement savedDepartement;
        departement.setDescription(departement.getDescription().toUpperCase());
        if(departement.getId()==null){
            savedDepartement = departementProxy.saveDepartement(departement);
        }
        else {
            savedDepartement = departementProxy.updateDepartement(departement);
        }
        return savedDepartement;
    }

}
