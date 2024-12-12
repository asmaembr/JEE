package com.clientui.microservicecommandes.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Commande {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        Long id;
        @DateTimeFormat(pattern = "DD-MM-YYYY")
        LocalDate date;
        Double total;

        @ManyToMany
        List<Product> products= new ArrayList<>();

        String adresse;
}
