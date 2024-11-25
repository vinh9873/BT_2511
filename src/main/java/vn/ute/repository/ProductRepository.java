package vn.ute.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import vn.ute.entity.Product;

@Repository
public interface ProductRepository {

	List<Product> findAll();

	Product save(Product product);

	Product findById(Long id);

	void deleteById(Long id);

}
