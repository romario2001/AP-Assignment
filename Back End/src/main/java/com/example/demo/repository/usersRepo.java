package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.users;

public interface usersRepo extends JpaRepository<users, Long >{

}
