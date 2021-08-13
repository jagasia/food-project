package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long>{

}
