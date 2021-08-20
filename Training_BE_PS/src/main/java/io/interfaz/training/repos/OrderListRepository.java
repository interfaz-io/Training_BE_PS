package io.interfaz.training.repos;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.interfaz.training.pojos.Merchant;

@RepositoryRestResource(collectionResourceRel = "merchant", path = "merchant")
public interface OrderListRepository extends CrudRepository<Merchant, Integer> {

	List<Merchant> findAll(Sort sort);

}
