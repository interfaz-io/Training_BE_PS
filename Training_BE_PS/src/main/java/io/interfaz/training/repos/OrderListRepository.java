package io.interfaz.training.repos;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import io.interfaz.training.entities.OrdersDetails;


@RepositoryRestResource(collectionResourceRel = "ordersdetails", path = "ordersdetails")
public interface OrderListRepository extends CrudRepository<OrdersDetails, Integer> {

	List<Merchant> findAll(Sort sort);

}
