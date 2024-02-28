package com.demo.entities;

import java.util.Date;

public class Product {
	
	private int id ;
	private String name;
	private String photo;
	private boolean status;
	private Date created;
	private double price;
	
	public Product(int id, String name, String photo, boolean status, Date created, double price) {
		super();
		this.id = id;
		this.name = name;
		this.photo = photo;
		this.status = status;
		this.created = created;
		this.price = price;
	}

	public Product() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
}
