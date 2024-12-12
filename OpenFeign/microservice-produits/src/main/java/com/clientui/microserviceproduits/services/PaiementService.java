package com.clientui.microserviceproduits.services;

import com.clientui.microserviceproduits.models.Paiement;
import com.clientui.microserviceproduits.repositories.PaiementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaiementService {
    @Autowired
    private PaiementRepository paiementRepository;

    public List<Paiement> findAll() {
        return paiementRepository.findAll();
    }

    public List<Paiement> findByClientName(String name) {
        return paiementRepository.findPaiementByClientName(name);
    }

    public void save(Paiement paiement) {
          paiementRepository.save(paiement);
    }
}
