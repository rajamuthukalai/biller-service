package com.sannu.billerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sannu.billerservice.model.Biller;

public interface BillerRepository extends JpaRepository<Biller, Long> {	
	Biller findByName(String name);
}