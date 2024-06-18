package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Account;
import com.example.demo.entity.AccountResponse;
import com.example.demo.entity.UserDetail;
import com.example.demo.service.AccountService;
import com.example.demo.entity.SignupResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class AccountController {
	
	//アカウント情報
	private final AccountService accountService;
	
	//アカウント情報登録
	@PostMapping(value = "/signup")
	@CrossOrigin(origins = "http://localhost:5173")
	public SignupResponse signupResult(@RequestBody Account account) {
		
		String message = "";
		AccountResponse accountResponse = new AccountResponse();
		
		Account checkAccount = accountService.findByEmail(account.getMail());
		if(checkAccount == null) {
			//アカウント情報が存在しない場合
			Account insertAccount = accountService.insertNewAccount(account);
			
			//レスポンスデータ作成
			message = "Registerd Completed!";
			
			accountResponse.setId(insertAccount.getAccount_id());
			accountResponse.setMail(insertAccount.getMail());
			
		} else {
			message = "Register Failed";
		}
		
		return new SignupResponse(
				message,accountResponse
				);
		
		//return "Registerd Completed!";
		//return new ResponseEntity<>("Registerd Completed!", HttpStatus.OK);
	}
	
	//アカウントに紐づくユーザー情報の新規登録
	@PostMapping(value = "/signup/register")
	public boolean registerResult(@RequestBody UserDetail userDetail) {
		accountService.insertUserDetail(userDetail);
		return true;
	}
	
	
}
