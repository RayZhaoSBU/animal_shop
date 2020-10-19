package com.mercury.AnimalShop.security;

import com.mercury.AnimalShop.bean.User;
import com.mercury.AnimalShop.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User u=userDao.findByUsername(username);
		if(u==null) {
			throw new UsernameNotFoundException("User name is not exist!");
		}
		
		
		return u;
	}

}
