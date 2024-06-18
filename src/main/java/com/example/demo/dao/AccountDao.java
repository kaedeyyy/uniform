package com.example.demo.dao;

import org.springframework.stereotype.Service;
import com.example.demo.entity.Account;
import com.example.demo.mapper.AccountMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AccountDao {
private final AccountMapper accountMapper;
	
	//ユーザー情報を取得するメソッド
	public Account findByEmail(String email) {
		
		return accountMapper.findByEmail(email);
	}

}
