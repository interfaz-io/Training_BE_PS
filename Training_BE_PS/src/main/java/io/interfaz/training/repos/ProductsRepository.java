/**
 * 
 */
package io.interfaz.training.repos;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.interfaz.training.pojos.Products;

/**
 * @author tthornton
 *
 */
@RepositoryRestResource(collectionResourceRel = "products", path = "products")
public interface ProductsRepository extends CrudRepository<Products, Integer> {
		List<Products> findAll(Sort sort);
		
	}

