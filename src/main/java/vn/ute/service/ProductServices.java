package vn.ute.service;

import java.util.List;

import vn.ute.entity.Product;

public interface ProductServices {
  
	void delete(Long id);
	Product get(Long id);
	Product save (Product product);
	List<Product> listAll();
}
