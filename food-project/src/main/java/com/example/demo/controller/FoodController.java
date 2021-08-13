package com.example.demo.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.Food;
import com.example.demo.service.FoodService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@RestController
@CrossOrigin({"*"})
@MultipartConfig
public class FoodController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private FoodService fs;
	
	@PostMapping("/food")
	public Food addFood(@RequestParam("id")Long id, @RequestParam("name") String name, @RequestParam("expiryDate") String expiryDate, @RequestParam("picture") MultipartFile file, MultipartHttpServletRequest request) throws IOException, ParseException {
		Food food=new Food();
		food.setId(id);
		food.setName(name);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		food.setExpiryDate(sdf.parse(expiryDate));
		byte[] picture = file.getBytes();
		food.setPicture(picture);
		log.info("The picture file has "+picture.length+" bytes");
		return fs.create(food);
	}
	@GetMapping("/food")
	public List<Food> getAllFoods() {
		return fs.read();
	}
	@GetMapping("/food/{id}")
	public Food findFoodById(@PathVariable("id") Long id) {
		return fs.read(id);
	}
	@PutMapping("/food")
	public Food modifyFood(@RequestParam("id")Long id, @RequestParam("name") String name, @RequestParam("expiryDate") String expiryDate, @RequestParam("picture") MultipartFile file) throws IOException, ParseException {
		Food food=new Food();
		food.setId(id);
		food.setName(name);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		food.setExpiryDate(sdf.parse(expiryDate));
		byte[] picture = file.getBytes();
		food.setPicture(picture);
		return fs.update(food);
	}
	@DeleteMapping("/food/{id}")
	public void removeFood(@PathVariable("id") Long id) {
		fs.delete(id);
	}
	
}
