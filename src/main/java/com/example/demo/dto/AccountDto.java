package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountDto {

	//アカウントID
	private int id;
		
	//Email
	private String email;
		
	//パスワード
	private String password;
	
	
	
}
