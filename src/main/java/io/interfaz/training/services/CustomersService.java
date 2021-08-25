
package io.interfaz.training.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.interfaz.training.entities.Customers;
import io.interfaz.training.repos.CustomersRepository;

/**
 * 
 * @author kcambronero
 *
 */
@Service
public class CustomersService {
	@Autowired
	private CustomersRepository customerRespository;

	public Customers createCustomer(Customers customer) {
		return customerRespository.save(customer);
	}

	public Customers updateCustomer(Customers customerRequest, int identifier) {
		return getById(identifier).map(customer -> {
			customer.setCountryID(customerRequest.getCountryID());
			customer.setEmail(customerRequest.getEmail());
			//customer.setOrders(customerRequest.getOrders());
			customer.setStatus(customerRequest.getStatus());
			return createCustomer(customer);
		}).orElseGet(() -> {
			return createCustomer(customerRequest);
		});
	}

	public List<Customers> getAll() {
		return (List<Customers>) customerRespository.findAll();
	}

	public Optional<Customers> getById(int id) {
		return customerRespository.findById(id);
	}

	public void deleteCustomer(int id) {
		customerRespository.deleteById(id);
	}
}
