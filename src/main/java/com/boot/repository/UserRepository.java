package com.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.boot.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	 @Query(value="select * from user where user_name=?1 and password=?2",nativeQuery=true)
	 public   User loginUser(String username,String password);
	
}
