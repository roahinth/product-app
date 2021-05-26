package com.chainsys.product.dao;
import java.util.List;

import java.util.Set;

import com.chainsys.product.model.Product;

public interface ProductDAO {
	Set<Product> findAll();

	Product findById(int id);
	
	Product findByName(String name);
	Product displayId(int id);
	void save(Product product);

	void update(Product product);
	void updateDate(Product product);
	void delete(int id);
	
	public List<String> displayName();
	public List<Integer> displayId();
}