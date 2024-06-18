package com.example.demo;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.AccountDao;
import com.example.demo.entity.Account;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private final AccountDao accountDao;
	
	public UserDetailsServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountDao.findByEmail(username);
                //.orElseThrow(() -> new UsernameNotFoundException(email));
        
        //UserDetailを返す
        return User.withUsername(account.getMail())
                .password(account.getPass())
                .build();
    }
	
	
}
