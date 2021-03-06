/**
 * 
 */
package io.interfaz.training.repos;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.interfaz.training.entities.Customers;

/**
 * @author Jermy Calvo
 *
 */
@RepositoryRestResource(collectionResourceRel = "customers", path = "customers")
public interface CustomersRepository extends CrudRepository<Customers, Integer>{

	List<Customers> findAll(Sort sort);
	
	List<Customers> findByFirstNameContainingIgnoreCase(String name);

	List<Customers> findByEmailContainingIgnoreCase(String email);

}
