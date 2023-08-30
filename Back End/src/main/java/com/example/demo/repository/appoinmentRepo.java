package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.appoinment;

public interface appoinmentRepo extends JpaRepository<appoinment, Long>{

}
