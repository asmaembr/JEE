package com.clientui.microserviceproduits.services;

import com.clientui.microserviceproduits.models.Commande;
import com.clientui.microserviceproduits.repositories.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CommandeService {
    @Autowired
    CommandeRepository commandeRepository;

    public List<Commande> findAll() {
        return commandeRepository.findAll();
    }

    public List<Commande>findCommandesByDate(LocalDate date) {
        return commandeRepository.findCommandesByDateBefore(date);
    }

    public Commande save(Commande commande) {
        return commandeRepository.save(commande);
    }
}
