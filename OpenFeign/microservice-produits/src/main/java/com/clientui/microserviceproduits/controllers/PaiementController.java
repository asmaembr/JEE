package com.clientui.microserviceproduits.controllers;

import com.clientui.microserviceproduits.models.Paiement;
import com.clientui.microserviceproduits.models.Product;
import com.clientui.microserviceproduits.services.PaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class PaiementController {
    @Autowired
    private PaiementService paiementService;

    @GetMapping("/paiement")
    public List<Paiement> Paiement() {
        return paiementService.findAll();
    }

    @GetMapping("/paiement/{name}")
    public List<Paiement> Paiement(@PathVariable String name) {
        return paiementService.findByClientName(name);
    }

    @PostMapping("/paiement")
    public Paiement addPaiement(@RequestBody Paiement paiement) {
        return paiementService.save(paiement);
    }
}
