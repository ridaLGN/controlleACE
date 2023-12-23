package com.emsi.Voiture.service;

import com.emsi.Voiture.dto.CarResponse;
import com.emsi.Voiture.entites.Car;
import com.emsi.Voiture.entites.Client;
import com.emsi.Voiture.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private RestTemplate restTemplate;
    private final  String URL = "http://localhost:8888/SERVICE-CLIENT";

    public List<CarResponse> findAll(){
        List<Car> cars = carRepository.findAll();
        ResponseEntity<Client[]> response = restTemplate.getForEntity(this.URL+"/api/client",Client[].class);
        Client[] clients = response.getBody();
        return  cars.stream().map((Car car)-> mapToCarResponse(car , clients)).toList();
    }
    public CarResponse mapToCarResponse (Car car , Client[] clients){
        Client foundClient = Arrays.stream(clients)
                .filter(client -> Objects.equals(client.getId(), car.getClient_id()))
                .findFirst()
                .orElse(null);
        return  CarResponse.builder()
                .id(car.getId())
                .brand(car.getBrand())
                .client(foundClient)
                .matricule(car.getMatricule())
                .model(car.getModel())
                .build();
    }
    public  CarResponse findByID(int id) throws Exception{
        Car car = carRepository.findById(id).orElseThrow(()-> new Exception("Invalid Car id"));
        Client client = restTemplate.getForObject(this.URL+"/api/client"+car.getClient_id(), Client.class);
        return  CarResponse.builder()
                .id(car.getId())
                .brand(car.getBrand())
                .client(client)
                .model(car.getModel())
                .matricule(car.getMatricule())
                .build();
    }
}
