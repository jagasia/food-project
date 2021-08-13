package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Food;
import com.example.demo.repository.FoodRepository;

@Service
public class FoodService {
	@Autowired
	private FoodRepository fr;

	public Food create(Food food) {
		return fr.save(food);
	}
	public List<Food> read() {
		return fr.findAll();
	}
	public Food read(Long id) {
		return fr.findById(id).get();
	}
	public Food update(Food food) {
		return fr.save(food);
	}
	public void delete(Long id) {
		fr.delete(read(id));
	}
	
}
