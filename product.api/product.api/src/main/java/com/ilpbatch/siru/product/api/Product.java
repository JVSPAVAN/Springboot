package com.ilpbatch.siru.product.api;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TCS_Products")
public class Product {

	@Id
	@GeneratedValue
	@Column(name = "product_id")
	private int productId;
	@Column(name = "product_name")
	private String productName;
	@Column(name = "product_description")
	private String prodDespt;
	

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProdDespt() {
		return prodDespt;
	}

	public void setProdDespt(String prodDespt) {
		this.prodDespt = prodDespt;
	}

	public Product(int productId, String productName, String prodDespt) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.prodDespt = prodDespt;
	}
	
	public Product() {
		super();
	}
	
	
}
