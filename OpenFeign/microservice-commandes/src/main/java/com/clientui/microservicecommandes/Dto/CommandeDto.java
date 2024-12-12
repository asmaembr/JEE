package com.clientui.microservicecommandes.Dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class CommandeDto {
    LocalDate date;
    String adresse;
    List<Long> products = new ArrayList<>();
}
