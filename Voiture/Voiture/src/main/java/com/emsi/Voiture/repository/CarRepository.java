package com.emsi.Voiture.repository;

import com.emsi.Voiture.entites.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository  extends JpaRepository<Car ,Integer> {
}
