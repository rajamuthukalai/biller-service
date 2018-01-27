package com.biller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biller.model.Biller;

public interface BillerRepository extends JpaRepository<Biller, Long> {	
	Biller findByName(String name);
}