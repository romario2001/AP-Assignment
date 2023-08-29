package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.consult;

public interface consultRepo extends JpaRepository<consult, Long>{
	@Query(value = "SELECT * FROM consult WHERE name = :name AND password = :password", nativeQuery = true)
    consult findByEmailAndPassword(@Param("name") String name, @Param("password") String password);
}
