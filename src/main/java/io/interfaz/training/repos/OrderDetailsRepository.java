package io.interfaz.training.repos;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import io.interfaz.training.entities.OrdersDetails;


@RepositoryRestResource(collectionResourceRel = "ordersdetails", path = "ordersdetails")
public interface OrderDetailsRepository extends CrudRepository<OrdersDetails, Integer> {

	List<OrdersDetails> findAll(Sort sort);
	
	List<OrdersDetails> findAllByOrder(int id);



}
