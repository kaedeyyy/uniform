package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class SignupResponse {
	@JsonProperty("message")
	private String message;
	
	@JsonProperty("account")
	private AccountResponse accountResponse;
}
