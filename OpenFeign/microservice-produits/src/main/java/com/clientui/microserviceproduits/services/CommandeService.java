package com.clientui.microserviceproduits.services;

import com.clientui.microserviceproduits.Dto.CommandeDto;
import com.clientui.microserviceproduits.models.Commande;
import com.clientui.microserviceproduits.models.Product;
import com.clientui.microserviceproduits.repositories.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CommandeService {
    @Autowired
    CommandeRepository commandeRepository;

    @Autowired
    private ProductService productService;

    public List<Commande> findAll() {
        return commandeRepository.findAll();
    }

    public List<Commande>findCommandesByDate(LocalDate date) {
        return commandeRepository.findCommandesByDateBefore(date);
    }

    public Commande save(CommandeDto commande) {

        Commande commandeObj = new Commande();
        commandeObj.setAdresse(commande.getAdresse());
        commandeObj.setDate(commande.getDate());
        commande.getProducts().forEach(
                product -> commandeObj
                        .getProducts()
                        .add(productService
                                .findById(product)
                        ));
        commandeObj.setTotal(commandeObj.getProducts()
                .stream()
                .mapToDouble(Product::getPrice)
                .sum());

        return commandeRepository.save(commandeObj);
    }
}
