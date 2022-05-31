package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Login;
@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {
	@Query("Select u from Login u WHERE u.username=:username AND u.password=:password")
	Login findByUsernamePassword(String username,String password);
	

}
