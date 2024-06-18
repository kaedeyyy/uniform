package com.example.demo.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Account;
import com.example.demo.entity.UserDetail;
import com.example.demo.mapper.AccountMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AccountService {
	private final AccountMapper accountMapper;
	private final PasswordEncoder passwordEncoder;
	
	//アカウントの新規登録
	@Transactional
	public Account insertNewAccount(Account account) {
		
		//パスワードのハッシュ化
		account.setPass(makeHash(account.getPass()));
		accountMapper.insertNewAccount(account);
		
		Account insertAccount = new Account();
		insertAccount.setAccount_id(account.getAccount_id());
		insertAccount.setMail(account.getMail());
		
		return insertAccount;
		//ロールバックテスト用
		//throw new RuntimeException();
	}
	
	//パスワード暗号化ロジック
	private String makeHash(String password) {
		
		String hashString = passwordEncoder.encode(password);
		return hashString;
		
	}

	//アカウントに紐づくユーザ情報の新規登録
	@Transactional
	public void insertUserDetail(UserDetail userDetail) {
		accountMapper.insertUserDetail(userDetail);
		
		//ロールバックテスト用
		//throw new RuntimeException();
	}
	
	//メール情報でアカウントを取得
	public Account findByEmail(String mail) {
		return accountMapper.findByEmail(mail);
		
	}
}
