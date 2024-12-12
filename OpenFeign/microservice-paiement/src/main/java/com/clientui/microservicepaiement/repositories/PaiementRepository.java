package com.clientui.microservicepaiement.repositories;

import com.clientui.microserviceproduits.models.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaiementRepository extends JpaRepository<Paiement, Long> {
    List<Paiement> findPaiementByClientName(String clientName);
}
