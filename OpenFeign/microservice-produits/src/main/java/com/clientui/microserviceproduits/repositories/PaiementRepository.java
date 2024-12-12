package com.clientui.microserviceproduits.repositories;

import com.clientui.microserviceproduits.models.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaiementRepository extends JpaRepository<Paiement, Long> {
    Paiement findPaiementByClientName(String clientName);
}
