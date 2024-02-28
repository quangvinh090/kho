package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.services.ProductService;

@Controller
@RequestMapping("product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = { "index", "" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {

		modelMap.put("product", productService.find());
		return "product/index";
	}

	@RequestMapping(value = "index2", method = RequestMethod.GET)
	public String index2(ModelMap modelMap) {
		
		modelMap.put("products", productService.findAll());
		return "product/index2";
	}

	@RequestMapping(value = "details/{id}", method = RequestMethod.GET)
	public String details(ModelMap modelMap,@PathVariable("id") int id) {
		
		modelMap.put("product", productService.findById(id));
		return "product/index";
	}
	
	@RequestMapping(value = "searchByKeyword", method = RequestMethod.GET)
	
	public String searchByKeyword(ModelMap modelMap,@RequestParam("keyword") String keyword) {
		modelMap.put("products", productService.searchByKeyWord(keyword));
		return "demo2/index";
	}
	
@RequestMapping(value = "searchByPrices", method = RequestMethod.GET)
	
	public String searchByKeyword(ModelMap modelMap,@RequestParam("min") int min, @RequestParam("max") int max) {
		modelMap.put("products", productService.searchByPrice(min, max));
		return "demo2/index";
	}
	
}
