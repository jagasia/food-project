package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Food {
	@Id
	private Long id;
	private String name;
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date expiryDate;
	@Lob
	private byte[] picture;
	public Food() {}
	public Food(Long id, String name, Date expiryDate, byte[] picture) {
		super();
		this.id = id;
		this.name = name;
		this.expiryDate = expiryDate;
		this.picture = picture;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public byte[] getPicture() {
		return picture;
	}
	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
	
}
