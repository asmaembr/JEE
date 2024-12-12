package com.clientui.microserviceproduits.services;

import com.clientui.microserviceproduits.repositories.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandeService {
    @Autowired
    CommandeRepository commandeRepository;
}
