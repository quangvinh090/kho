package com.demo.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.entities.Product;

@Service
public class ProductServiceImpl implements ProductService{

	
	
	@Override
	public Product find() {
		
		return new Product(1, "Product 01", "product1.jpg", true, new Date(), 2);
	}

	@Override
	public List<Product> findAll() {
		List<Product> products = new ArrayList<Product>();
		products.add(new Product(1, "Nike ", "product1.jpg", true, new Date(), 9));
		products.add(new Product(2, "Adidas ", "product2.jpg", false, new Date(), 19));
		products.add(new Product(3, "Airforce", "product3.jpg", true, new Date(), 29));
		products.add(new Product(4, "crook ", "product4.jpg", false, new Date(), 39));
		return products;
	}

	@Override
	public Product findById(int id) {
		List<Product> products = findAll();
		for(Product product : products) {
			if(product.getId() == id) {
				return product;
			}
		}
		return null;
	}

	@Override
	public List<Product> searchByKeyWord(String keyword) {
		List<Product> result = new ArrayList<Product>();
		for(Product product : findAll()) {
			if(product.getName().toLowerCase().contains(keyword)) {
				result.add(product);
			}
		}
		return result;
	}

	@Override
	public List<Product> searchByPrice(int min, int max) {
		List<Product> result = new ArrayList<Product>();
		for(Product product : findAll()) {
			if(product.getPrice()<= max && product.getPrice() >= min) {
				result.add(product);
			}
		}
		return result;
	}

}
