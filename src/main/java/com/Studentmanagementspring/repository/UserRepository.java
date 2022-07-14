package com.Studentmanagementspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

	import com.Studentmanagementspring.entity.User;

	public interface UserRepository extends JpaRepository<User,Long> {
	    @Query("SELECT u FROM User u WHERE u.username = ?1")
	    public User getUserByUsername(String username);
	}


