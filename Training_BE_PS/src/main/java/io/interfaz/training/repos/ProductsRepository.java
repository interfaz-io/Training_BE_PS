/**
 * 
 */
package io.interfaz.training.repos;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.interfaz.training.pojos.Customers;
import io.interfaz.training.pojos.Products;

/**
 * @author tthornton
 *
 */
public interface ProductsRepository {
	@RepositoryRestResource(collectionResourceRel = "products", path = "products")
	public interface CustomersRepository extends CrudRepository<Customers, Integer>{

		List<Products> findAll(Sort sort);
		
	}
}
