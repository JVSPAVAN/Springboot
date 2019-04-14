package com.ilpbatch.siru.product.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ProductController {
	
	@Autowired
	 ProductRepository productRepository;
	
	@GetMapping(path="/get")
	public  ResponseEntity getProduct() {
		/*
		 * Product pd = new Product(1,"sai","pavan"); List<Product> list = new
		 * ArrayList<Product>(); list.add(pd);
		 * 
		 * System.out.println(pd.getProductId()+" "+pd.getProductName()+" "+pd.
		 * getProdDespt() );
		 */
		//return productRepository.findAll();	
		return ResponseEntity.status(HttpStatus.OK).body(productRepository.findAll());
	}
	
	@PostMapping(path="/save")
	public ResponseEntity putProduct(@RequestBody Product pro) {
		
		//Product p1 = new Product(9,"hello","hai");
	
		//return productRepository.save(pro);
		return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(pro));
	
	}
	
	@RequestMapping(value = "/product/remove", method = RequestMethod.POST)
	public String removeAd(@RequestParam("product_id") int id) {	    
	    productRepository.deleteById(id);	  
	    return "redirct:/list";
	}
	
	@DeleteMapping(path="/delete")
	public void deleteProduct(@RequestBody int id) throws Exception {
		Optional<Product> a = productRepository.findById(id);
		if (a.isPresent()) {
			productRepository.deleteById(id);
		}
		else throw new Exception("No product for product ID : "+id);
	}

	@PutMapping(path="/edit")
	public Product updateProduct(@RequestBody Product product) throws Exception {
	
		Optional<Product> res = productRepository.findById(product.getProductId());
			if(res.isPresent()) {
				return productRepository.save(product);
			}
		else {
			throw new Exception("No product for product ID : "+product.getProductId());
		}
		
	}
	
	
	@GetMapping("search/{name}")
	public ResponseEntity searchByName(@PathVariable("name") String name) {
		List<Product> a = productRepository.findByProductName(name);
		if (!a.isEmpty()) {
			//productRepository.findByProductName(name);
			return ResponseEntity.status(HttpStatus.OK).body(productRepository.findByProductName(name));
		}
		//return productRepository.findByProductName(name);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}

	
}
