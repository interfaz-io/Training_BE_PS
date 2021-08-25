/**
 * 
 */
package io.interfaz.training.repos;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.interfaz.training.entities.Products;

/**
 * @author tthornton
 *
 */
@RepositoryRestResource(collectionResourceRel = "products", path = "products")
public interface ProductsRepository extends PagingAndSortingRepository<Products, Integer> {
		List<Products> findAll(Sort sort);
		
		
		List<Products> findByNameContainingIgnoreCase(String name);
	}