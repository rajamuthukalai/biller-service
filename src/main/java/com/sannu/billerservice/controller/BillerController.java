package com.sannu.billerservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sannu.billerservice.exception.BillerNotFoundException;
import com.sannu.billerservice.model.Biller;
import com.sannu.billerservice.model.CustomError;
import com.sannu.billerservice.service.BillerService;

@RestController
@RequestMapping(path = "/api")
@CrossOrigin("*")
public class BillerController {

	@Autowired
	private BillerService billerService;


	@GetMapping(path="/billers")
	public List<Biller> getBillers() {
		return billerService.getBillers();
	}

	@GetMapping(path="/biller/{id}")
	public Biller getBillers(@PathVariable(required=true) long id) throws BillerNotFoundException {
		return billerService.getBiller(id);
	}


	@PutMapping(path="/biller/{id}")
	public Biller updateBillers(@Valid  @RequestBody Biller biller) {
		return billerService.updateBiller(biller);
	}

	@DeleteMapping(path="/biller/{id}")
	public void deleteBiller(@PathVariable(required=true) Long id) {
		try {
			billerService.deleteBiller(id);
		} catch (BillerNotFoundException e) {
			
		}
	}

	@PostMapping(path="/biller")
	public Biller createBillers(@Valid @RequestBody Biller biller) {
		return billerService.createBiller(biller);
	}
	
	@ExceptionHandler(BillerNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public CustomError billerNotFound(BillerNotFoundException e) {
		long billerId = e.getBillerId();
		return new CustomError(4, "Biller [" + billerId + "] not found");
	}

}