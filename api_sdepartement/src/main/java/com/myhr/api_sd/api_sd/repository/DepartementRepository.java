package com.myhr.api_sd.api_sd.repository;

import com.myhr.api_sd.api_sd.model.Departement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartementRepository extends CrudRepository<Departement, Long> {
}
