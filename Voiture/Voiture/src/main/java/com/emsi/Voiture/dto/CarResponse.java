package com.emsi.Voiture.dto;

import com.emsi.Voiture.entites.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarResponse {
    private int id;
    private  String brand;
    private String model;
    private  String matricule;
    private Client client;

}
