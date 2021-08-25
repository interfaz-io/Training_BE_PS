
package io.interfaz.training.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	public Optional<Customers> getById(@PathVariable int id) {
		return customerService.getById(id);
	}
	
	@GetMapping("/customers/search/{name}")
	public List<Customers> getCustomersByName(@PathVariable String name) {
		return customerService.getCustomersByName(name);
	}

	@PostMapping("/customers")
	public Customers newCustomer(@RequestBody Customers newMerchant) {
		return customerService.createCustomer(newMerchant);
	}

	@DeleteMapping("/customers/{id}")
	public void deleteCustomer(@PathVariable int id) {
		customerService.deleteCustomer(id);
	}

	@PatchMapping("/customers/{id}")
	public Customers replaceCustomer(@RequestBody Customers newCustomer, @PathVariable int id) {
		return customerService.updateCustomer(newCustomer, id);
	}

}
