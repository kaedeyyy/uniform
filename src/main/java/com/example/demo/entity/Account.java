package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {
	//アカウントID
	private int account_id;
			
	//Email
	private String mail;
			
	//パスワード
	private String pass;
		
}
