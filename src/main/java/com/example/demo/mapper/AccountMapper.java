package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.AccountDto;

@Mapper
public interface AccountMapper {
	//新しいアカウントをINSERT
	void insertNewAccount(AccountDto accountDto); 
}
