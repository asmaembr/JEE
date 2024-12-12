package com.clientui.microservicecommandes.services;

import com.clientui.microserviceproduits.Dto.PaiementDto;
import com.clientui.microserviceproduits.models.Paiement;
import com.clientui.microserviceproduits.repositories.PaiementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaiementService {
    @Autowired
    private PaiementRepository paiementRepository;
    @Autowired
    private CommandeService commandeService;

    public List<Paiement> findAll() {
        return paiementRepository.findAll();
    }

    public List<Paiement> findByClientName(String name) {
        return paiementRepository.findPaiementByClientName(name);
    }

    public Paiement save(PaiementDto paiement) {
        Paiement paiementObj = new Paiement();
        paiementObj.setCommande(commandeService.findById(paiement.getCommandeId()));
        paiementObj.setClientName(paiement.getClientName());
        return paiementRepository.save(paiementObj);
    }
}
