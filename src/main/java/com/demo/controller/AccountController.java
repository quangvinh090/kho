package com.demo.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.entities.Account;
import com.demo.services.CertService;
import com.demo.services.LanguageService;
import com.demo.services.RectangleService;

@Controller
@RequestMapping("account")
public class AccountController {
	
	@Autowired
	private CertService certService;
	@Autowired
	private LanguageService languageService;
	
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String register(ModelMap modelMap) {
		Account account = new Account();
		account.setUsername("cogminh");
		account.setDescription("chieu co 5ti");
		account.setDob(new Date());
		account.setStatus(true);
		account.setLanguages(new int[] {1, 3, 5});
		account.setGender("m");
		account.setCert(2);
		modelMap.put("account", account);
		modelMap.put("languages", languageService.findAll());
		modelMap.put("certs", certService.findAll());
		return "account/register";
	}
	
	
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String register(@ModelAttribute("account") Account account) {
		System.out.println("Account info");
		System.out.println("username: " + account.getUsername());
		System.out.println("password: " + account.getPassword());
		System.out.println("description: " + account.getDescription());
		System.out.println("details: " + account.getDetails());
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("dob: " + simpleDateFormat.format(account.getDob()));
		System.out.println("status: " + account.isStatus());
		if(account.getLanguages() != null && account.getLanguages().length > 0) {
			System.out.println("Languages: " + account.getLanguages().length);
			for( int language : account.getLanguages()) {
				System.out.println(language);
			}
		}
		System.out.println("gender " + account.getGender());
		System.out.println("cert " + account.getCert());
		return "redirect:/account/register";
	}
	
	
	
}