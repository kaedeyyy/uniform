package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDetail {
	private int id;
	private int accountId;
	private String name;
	
	//性別(W:女性,M:男性,N:その他)
	private char gender;
	
	private int postalNumber;
	private String prefecture;
	private String address;
	private String building;
}
