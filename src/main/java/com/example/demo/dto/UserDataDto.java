package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDataDto {
	//id
	private int id;
	
	//アカウントID
	private int accountId;
	
	//名前
	private String name;
	
	//性別(M,W,N)
	private char gender;
	
	//郵便番号
	private int postralNumber;
	
	//都道府県
	private String prefecture;
	
	//住所
	private String address;
	
	//建物名
	private String building;
}
