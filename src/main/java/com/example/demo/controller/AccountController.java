package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AccountDto;
import com.example.demo.service.AccountService;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class AccountController {
	
	//アカウント情報
	private final AccountService accountService;
	
	//アカウント情報登録
	@PostMapping(value = "/signup")
	public boolean signupResult(@RequestBody AccountDto accountDto) {
		accountService.insertNewAccount(accountDto);
		return true;
	}
	
	
}
