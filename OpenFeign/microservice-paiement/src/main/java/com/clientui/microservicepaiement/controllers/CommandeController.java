package com.clientui.microservicepaiement.controllers;

import com.clientui.microserviceproduits.Dto.CommandeDto;
import com.clientui.microserviceproduits.models.Commande;
import com.clientui.microserviceproduits.services.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class CommandeController {
    @Autowired
    private CommandeService commandeService;

    @GetMapping("/commandes")
    public List<Commande> Commandes() {
        return commandeService.findAll();
    }

    @GetMapping("/commandes/{date}")
    public List<Commande> Commandes(@PathVariable LocalDate date) {
        return commandeService.findCommandesByDate(date);
    }

    @PostMapping("/commandes")
    public Commande addCommande(@RequestBody CommandeDto commande) {
        return commandeService.save(commande);
    }
}
