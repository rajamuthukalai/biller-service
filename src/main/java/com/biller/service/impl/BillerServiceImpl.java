package com.biller.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.biller.exception.BillerNotFoundException;
import com.biller.model.Biller;
import com.biller.repository.BillerRepository;
import com.biller.service.BillerService;

@Service
@Transactional
public class BillerServiceImpl implements BillerService {
	
	@Autowired
	private BillerRepository billerRepository;

	@Override
	public List<Biller> getBillers() {
		return billerRepository.findAll();
	}

	@Override
	public Biller getBiller(Long id) throws BillerNotFoundException {
		Biller biller = billerRepository.findOne(id);
		if (biller == null) {
			throw new BillerNotFoundException(id);
		}
		return biller;
	}

	@Override
	public Biller getBiller(String name) {
		return billerRepository.findByName(name);
	}

	@Override
	public Biller createBiller(Biller biller) {
		return billerRepository.save(biller);
	}

	@Override
	public Biller updateBiller(Biller biller) {
		return billerRepository.save(biller);
	}

	@Override
	public boolean deleteBiller(Long id) throws BillerNotFoundException {
		boolean isDeleted = false;		
		try {
			Biller biller = billerRepository.findOne(id);
			if (biller == null) {
				throw new BillerNotFoundException(id);
			}
			billerRepository.delete(id);
			isDeleted = true;
		} catch (Exception e) {
			System.err.println("Exception occurred while deleting biller with id: " + id);
		}
		return isDeleted;
	}
	
}