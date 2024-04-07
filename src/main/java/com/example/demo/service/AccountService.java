package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dto.AccountDto;
import com.example.demo.mapper.AccountMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AccountService {
	private final AccountMapper accountMapper;
	
	//アカウントの新規登録
	public void insertNewAccount(AccountDto accountDto) {
		accountMapper.insertNewAccount(accountDto);
	}
}
