package com.chainsys.product.service;

import java.util.Set;
import java.util.List;
import com.chainsys.product.dao.ProductDAO;
import com.chainsys.product.dao.ProductDAOImpl;
import com.chainsys.product.exception.ProductNotFoundException;
import com.chainsys.product.model.Product;

public class ProductServiceImpl implements ProductService {
	private static ProductDAO dao;

	public ProductServiceImpl() {
		dao = new ProductDAOImpl();
	}

	@Override
	public Set<Product> findAll() {
		return dao.findAll();
	}

	@Override
	public Product findById(int id) throws ProductNotFoundException {
		Product Product = dao.findById(id);
		if (Product == null) {
			throw new ProductNotFoundException("Product Id Not Found");
		} else {
			return Product;
		}
	}
	
	public Product findByName(String name) throws ProductNotFoundException {
		Product Product = dao.findByName(name);
		if (Product == null) {
			throw new ProductNotFoundException("Product Name Not Found");
		} else {
			return Product;
		}
	}
	public Product displayId(int id) throws ProductNotFoundException {
		Product Product = dao.displayId(id);
		if (Product == null) {
			throw new ProductNotFoundException("Product Id Not Found");
		} else {
			return Product;
		}
	}
	public List<String> displayName() {
		return dao.displayName();
	}
	public List<Integer> displayId() {
		return dao.displayId();
	}
	@Override
	public void save(Product Product) {
		dao.save(Product);

	}

	@Override
	public void update(Product Product) throws ProductNotFoundException {
		Product result = dao.findById(Product.getId());
		if (result == null) {
			throw new ProductNotFoundException("Product Id Not Found");
		} else {
			dao.update(Product);
		}

	}
	
	
	public void updateDate(Product Product) throws ProductNotFoundException {
		Product result = dao.findById(Product.getId());
		if (result == null) {
			throw new ProductNotFoundException("Product Id Not Found");
		} else {
			dao.updateDate(Product);
		}

	}

	@Override
	public void delete(int id) throws ProductNotFoundException {
		Product Product = dao.findById(id);
		if (Product == null) {
			throw new ProductNotFoundException("Product doesn't exist!!");
		} else {
			dao.delete(id);
		}
	}

}
