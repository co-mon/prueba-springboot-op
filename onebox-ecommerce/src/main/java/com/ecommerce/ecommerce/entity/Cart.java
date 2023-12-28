package com.ecommerce.ecommerce.entity;

import java.util.ArrayList;
import java.util.List;

public class Cart {

	private int id;
    private List<Product> products = new ArrayList<>();;
    private long ttl;
    

    public Cart() {
        this.ttl = System.currentTimeMillis() + (10 * 60 * 1000); // 10 minutos en milisegundos
    }
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public long getTtl() {
		return ttl;
	}
	public void setTtl(long ttl) {
		this.ttl = ttl;
	}
    
}
