package vn.ute.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import vn.ute.entity.Product;
import vn.ute.repository.ProductRepository;

public class ProductServicesImpl {
	@Autowired
	private ProductRepository repo;
	public void ProductServiceImpl (ProductRepository repo) {
	this.repo = repo;
	}
	public List<Product> listAll() {
	return repo.findAll();
	}
	public Product save (Product product) {
	return repo.save(product);
	}
	public Product get (Long id) {
	return repo.findById(id);
	}
	public void delete (Long id) {
	repo.deleteById(id);
	}

}
