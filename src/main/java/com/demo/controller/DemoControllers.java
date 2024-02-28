package com.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.services.RectangleService;

@Controller
@RequestMapping({"demo", "", "/"})//có một đường dẫn

public class DemoControllers {
	@Autowired
	private RectangleService rectangleService ;
	
	@RequestMapping(value = {"index", ""}, method = RequestMethod.GET)//có thể sử dụng nhiều đường dẫn chỉ cần có {}
	public String index(ModelMap modelMap) {
		modelMap.put("id", 123);
		modelMap.put("username", "acc1");
		modelMap.put("fullname", "NullLy");
		modelMap.put("status", true);
		modelMap.put("price", 9);
		modelMap.put("quantity", 9);
		
		modelMap.put("photo", "product2.jpg");
		modelMap.put("width", 70);
		modelMap.put("height", 90);
		
		modelMap.put("today", new Date());
		
		List<String> names = new ArrayList<String>();
		names.add("Name1");
		names.add("Name2");
		names.add("Name3");
		names.add("Name4");
		modelMap.put("names", names);
		return "demo/index";
	}
	
	@RequestMapping(value =  "index2/{username}", method = RequestMethod.GET)//có thể sử dụng nhiều đường dẫn chỉ cần có {}
//	public String index2(@PathVariable("id") int id) {
//		System.out.println("Id: " + id);
//		return "demo/index2";
//	}
	public String index2(@PathVariable("username") String username) {
		System.out.println("Username: " + username);
		return "demo/index2";
	}
	
	@RequestMapping(value = {"index3/{id}/{username}"}, method = RequestMethod.GET)//có thể sử dụng nhiều đường dẫn chỉ cần có {}
	public String index3(@PathVariable("id") int id, @PathVariable String username) {
		//@PathVariable  http://localhost:8080/MyApp/user/1234
		System.out.println("Id: " + id);
		System.out.println("Username: " + username);
		return "demo/index2";
	}
	
	@RequestMapping(value = "index4", method = RequestMethod.GET)//có thể sử dụng nhiều đường dẫn chỉ cần có {}
	
	public String index4(@RequestParam("id") int id, @RequestParam("username") String username) {
		//Request Param http://localhost:8080/springmvc/hello/101?id=10&param2=20
		System.out.println("Id: " + id);
		System.out.println("Username: " + username);
		return "demo/index2";
	}
//	public String index4(@RequestParam("action") String action) {
//		System.out.println("Action: " + action);
//		return "demo/index2";
//	}
	
	
	
	@RequestMapping(value = "index5", method = RequestMethod.GET)//có thể sử dụng nhiều đường dẫn chỉ cần có {}
	public String index5(ModelMap modelMap) {
		modelMap.put("area", rectangleService.area(2, 30));
		modelMap.put("perimeter", rectangleService.perimeter(2, 10));
		return "demo/index5";
	}
	
	
	

}
