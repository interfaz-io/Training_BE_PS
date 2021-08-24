/**
 * 
 */
package io.interfaz.training.repos;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.interfaz.training.entities.Orders;

/**
 * @author tthornton
 *
 */
@RepositoryRestResource(collectionResourceRel = "orders", path = "orders")
public interface OrdersRepository extends CrudRepository<Orders, Integer> {

		List<Orders> findAll(Sort sort);
	}
	

