package com.Studentmanagementspring.service;

import com.Studentmanagementspring.repository.UserRepository;
import com.Studentmanagementspring.entity.User;
import com.Studentmanagementspring.security.MyUserDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailServiceImpl implements UserDetailsService {

	   @Autowired
	    private UserRepository userRepository;
	     
	    @Override
	    public UserDetails loadUserByUsername(String username)
	            throws UsernameNotFoundException {
	        User user = userRepository.getUserByUsername(username);
	        
	        if (user == null) {
	            throw new UsernameNotFoundException("Could not find user");
	        }
	        System.out.println("username:"+user.getUsername()+"password"+user.getPassword());
	        return new MyUserDetails(user);
	    }

}


