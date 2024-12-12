package com.clientui.microserviceproduits.Dto;

import com.clientui.microserviceproduits.models.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommandeDto {
    Long id;
    LocalDate date;
    Double total;
    String adresse;
    List<Long> products= new ArrayList<>();
}
