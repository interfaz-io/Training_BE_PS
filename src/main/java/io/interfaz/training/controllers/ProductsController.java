package io.interfaz.training.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.interfaz.training.entities.Products;
import io.interfaz.training.services.ProductsService;
/**
 * 
 * @author kcambronero
 *
 */
@RestController
public class ProductsController {
	@Autowired
	public ProductsService productsService;
	
	@GetMapping("/products")
	public List<Products> all(){
		return productsService.getAll();
	}
	@GetMapping("/products/{id}")
	public Optional<Products> productId(@PathVariable int id) {
		return productsService.getById(id);
	}
	@PostMapping("/Products")
	public Products newProduct(@RequestBody Products newProduct) {
		return productsService.createProduct(newProduct);
	}
	@DeleteMapping("/products/{id}")
	public void deleteProduct(@PathVariable int id) {
		productsService.deleteProduct(id);
	}
	@PutMapping("/products/{id}")
	public Products replaceProduct(@RequestBody Products newProduct, @PathVariable int id) {
		return productsService.getById(id)
				.map(product ->{
					product.setDescription(newProduct.getDescription());
					product.setPrice(newProduct.getPrice());
					product.setStatus(newProduct.getStatus());
					return productsService.createProduct(product);
				})
				.orElseGet(()->{
					newProduct.setId(id);
					return productsService.createProduct(newProduct);
				});
	}
	
}