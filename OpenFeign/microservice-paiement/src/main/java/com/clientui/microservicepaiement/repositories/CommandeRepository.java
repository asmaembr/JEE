package com.clientui.microservicepaiement.repositories;

import com.clientui.microserviceproduits.models.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CommandeRepository  extends JpaRepository<Commande, Long> {
List<Commande> findCommandesByDateBefore(LocalDate dateBefore);
}
