/**
 * 
 */
package io.interfaz.training.repos;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.interfaz.training.pojos.Orders;

/**
 * @author tthornton
 *
 */
public interface OrdersRepository {

	@RepositoryRestResource(collectionResourceRel = "orders", path = "orders")
	public interface CustomersRepository extends CrudRepository<Orders, Integer>{

		List<Orders> findAll(Sort sort);
		
	}
	
}
