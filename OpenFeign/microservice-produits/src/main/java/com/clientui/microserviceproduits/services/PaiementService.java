package com.clientui.microserviceproduits.services;

import com.clientui.microserviceproduits.repositories.PaiementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaiementService {
    @Autowired
    private PaiementRepository paiementRepository;
}
