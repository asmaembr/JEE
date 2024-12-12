package com.clientui.microserviceproduits.repositories;

import com.clientui.microserviceproduits.models.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository  extends JpaRepository<Commande, Long> {
}
