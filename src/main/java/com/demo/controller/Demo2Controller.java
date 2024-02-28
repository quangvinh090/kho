package com.demo.controller;



import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.demo.helpers.FileHelper;

@Controller
@RequestMapping({"demo2", "", "/"})//có một đường dẫn
public class Demo2Controller {
	@RequestMapping(value = {"index", ""}, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		
		return "demo2/index";
	}
	
	@RequestMapping(value = "searchByKeyword", method = RequestMethod.GET)
	public String searchByKeyword(@RequestParam("keyword") String keyword) {
			System.out.println("Keyword: " + keyword);
			return "redirect:/demo2/index";
		}
	@RequestMapping(value = "searchByPrices", method = RequestMethod.GET)
	public String searchByPrices(@RequestParam("min") double min, @RequestParam("max") double max) {
			System.out.println("Min: " + min);
			System.out.println("Max: " + max);
			return "redirect:/demo2/index";
		}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(@RequestParam("emails") String[] emails) {
			for(String email : emails) {
				System.out.println(email);
			}
			return "redirect:/demo2/index";
		}
	@RequestMapping(value = "update2", method = RequestMethod.POST)
	public String update(@RequestParam("quantities") int[] quantities) {
			for(int quantity : quantities) {
				System.out.println(quantity);
			}
			return "redirect:/demo2/index";
		}
	
	@RequestMapping(value = "upload", method = RequestMethod.GET)//có thể sử dụng nhiều đường dẫn chỉ cần có {}
	public String upload(ModelMap modelMap) {
		
		return "demo2/index2";
	}
	
	@RequestMapping(value = "upload", method = RequestMethod.POST)//có thể sử dụng nhiều đường dẫn chỉ cần có {}
	public String upload(@RequestParam("file") MultipartFile file, ModelMap modelMap) {
		System.out.println("File Info");
		System.out.println("name: " + file.getOriginalFilename());
		System.out.println("Size: " + file.getSize());
		System.out.println("Type: " + file.getContentType());
		
		try {
			File folderImage = new File(new ClassPathResource(".").getFile().getPath() + "/static/images");
			String  fileName = FileHelper.generateFileName(file.getOriginalFilename());
			Path path = Paths.get(folderImage.getAbsolutePath() + File.separator + fileName);
			System.out.println(folderImage.getAbsolutePath() + File.separator + fileName);
			//separator tùy theo hệ điều hành để thêm dấu / hay \
			Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("new file Name: "  + fileName);
			modelMap.put("filename", fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "demo2/result1";
	}
	
	@RequestMapping(value = "uploads", method = RequestMethod.POST)//có thể sử dụng nhiều đường dẫn chỉ cần có {}
	public String uploads(@RequestParam("files") MultipartFile[] files, ModelMap modelMap) {
		List<String> fileNames = new ArrayList<String>(); 
		System.out.println("File Info");
		System.out.println("Files: " + files.length);
		for(MultipartFile file : files) {
			System.out.println("name: " + file.getOriginalFilename());
			System.out.println("Size: " + file.getSize());
			System.out.println("Type: " + file.getContentType());
			try {
				File folderImage = new File(new ClassPathResource(".").getFile().getPath() + "/static/images");
				String  fileName = FileHelper.generateFileName(file.getOriginalFilename());
				Path path = Paths.get(folderImage.getAbsolutePath() + File.separator + fileName);
				//separator tùy theo hệ điều hành để thêm dấu / hay \
				Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
				fileNames.add(fileName);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		modelMap.put("filenames", fileNames);
		return "demo2/result2";
	}
	
}
