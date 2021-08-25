package io.interfaz.training.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.interfaz.training.entities.Products;
import io.interfaz.training.repos.ProductsRepository;

/**
 * 
 * @author kcambronero
 *
 */
@Service
public class ProductsService {
	@Autowired
	private ProductsRepository productsRespository;

	public Products createProduct(Products products) {
		return productsRespository.save(products);
	}

	public Products updateProduct(Products productsRequest, int identifier) {
		return getById(identifier).map(product -> {
			product.setDescription(productsRequest.getDescription());
			product.setPrice(productsRequest.getPrice());
			product.setStatus(productsRequest.getStatus());
			return createProduct(product);
		}).orElseGet(() -> {
			return createProduct(productsRequest);
		});
	}

	public List<Products> getAll() {
		return (List<Products>) productsRespository.findAll();
	}

	public List<Products> getSimilar(String name) {
		return productsRespository.findByNameContainingIgnoreCase(name);
	}
	
	public Optional<Products> getById(int id) {
		return productsRespository.findById(id);
	}

	public void deleteProduct(int id) {
		productsRespository.deleteById(id);
	}

}
