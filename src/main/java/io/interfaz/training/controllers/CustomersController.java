
package io.interfaz.training.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.interfaz.training.entities.Customers;
import io.interfaz.training.services.CustomersService;

@RestController
public class CustomersController {
	@Autowired
	public CustomersService customerService;

	@GetMapping("/customers")
	public List<Customers> all() {
		return customerService.getAll();
	}

	@GetMapping("/customers/{id}")
	public Optional<Customers> productId(@PathVariable int id) {
		return customerService.getById(id);
	}

	@PostMapping("/customers")
	public Customers newOrder(@RequestBody Customers newMerchant) {
		return customerService.createCustomer(newMerchant);
	}

	@DeleteMapping("/customers/{id}")
	public void deleteOrder(@PathVariable int id) {
		customerService.deleteCustomer(id);
	}

	@PutMapping("/customers/{id}")
	public Customers replaceCustomer(@RequestBody Customers newCustomer, @PathVariable int id) {
		return customerService.getById(id).map(customer -> {
			customer.setCountryID(newCustomer.getCountryID());
			customer.setEmail(newCustomer.getEmail());
			customer.setOrders(newCustomer.getOrders());
			customer.setStatus(newCustomer.getStatus());
			return customerService.createCustomer(customer);
		}).orElseGet(() -> {
			newCustomer.setId(id);
			return customerService.createCustomer(newCustomer);
		});
	}

}
