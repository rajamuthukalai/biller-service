package com.sannu.billerservice.service;

import java.util.List;

import com.sannu.billerservice.exception.BillerNotFoundException;
import com.sannu.billerservice.model.Biller;

public interface BillerService {
	List<Biller> getBillers();
	Biller getBiller(Long id) throws BillerNotFoundException;
	Biller getBiller(String name);
	Biller createBiller(Biller biller);
	Biller updateBiller(Biller biller);
	boolean deleteBiller(Long id) throws BillerNotFoundException;
}