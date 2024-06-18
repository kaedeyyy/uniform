package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.example.demo.entity.Account;
import com.example.demo.entity.UserDetail;

@Mapper
public interface AccountMapper {
	//新しいアカウントをINSERT
	int insertNewAccount(Account account); 
	
	//アカウントに紐づくユーザー情報の新規登録
	void insertUserDetail(UserDetail userDetail);
	
	//アカウント情報を取得
	Account findByEmail(String mail);
}
