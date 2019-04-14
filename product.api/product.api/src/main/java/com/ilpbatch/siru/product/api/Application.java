package com.ilpbatch.siru.product.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ProductController products = new ProductController();
		
		SpringApplication.run(Application.class, args);
		System.out.println(products.getProduct());
		
		}

}
