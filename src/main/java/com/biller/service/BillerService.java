package com.biller.service;

import java.util.List;

import com.biller.exception.BillerNotFoundException;
import com.biller.model.Biller;

public interface BillerService {
	List<Biller> getBillers();
	Biller getBiller(Long id) throws BillerNotFoundException;
	Biller getBiller(String name);
	Biller createBiller(Biller biller);
	Biller updateBiller(Biller biller);
	boolean deleteBiller(Long id) throws BillerNotFoundException;
}