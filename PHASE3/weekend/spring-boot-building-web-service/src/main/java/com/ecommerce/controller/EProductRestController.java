package com.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.EProduct;
import com.ecommerce.repositry.EProductRepositry;

@RestController
@RequestMapping("api/product/v1")
public class EProductRestController {
	
	@Autowired
	private final EProductRepositry eProductRepositry = null;	
		
	@GetMapping(value="/list", produces="application/json")
	public List<EProduct> listOfProducts() {
		
		List<EProduct> products = eProductRepositry.findAll();
		
		return products;			
	}
	
	@GetMapping(value="/details/{id}", produces="application/json")
	public EProduct getProducts(@PathVariable("id") long id) {
		
		Optional<EProduct> productFromRepo = eProductRepositry.findById(id);
		
		if(productFromRepo.isPresent()) {
			EProduct product = productFromRepo.get();
			return product;		
		}
		
		return null;		
			
	}
	
	@GetMapping(value="/delete/{id}", produces="application/json")
	public void deleteProducts(@PathVariable("id") long id) {
		
		Optional<EProduct> productFromRepo = eProductRepositry.findById(id);
		
		if(productFromRepo.isPresent()) {
			eProductRepositry.deleteById(id);
		}		
			
	}
	

}
