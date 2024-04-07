package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ItemController {
	@GetMapping("/helloAPI")
	public String getItem() {
		String strHello = "Hello!";
		return strHello;
	}
	
//	@PostMapping("/item/insert")
//	public boolean Result(@RequestBody List<User> users) {
//
//		userService.insert(users);
//		return true;
//	}
}
