
package io.interfaz.training.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.interfaz.training.entities.Orders;
import io.interfaz.training.services.OrdersService;

@RestController
public class OrdersController {
	@Autowired
	public OrdersService ordersService;

	@GetMapping("/orders")
	public List<Orders> all() {
		return ordersService.getAll();
	}

	@GetMapping("/orders/{id}")
	public Optional<Orders> orderId(@PathVariable int id) {
		return ordersService.getById(id);
	}
	
	@GetMapping("/orders/customer/{id}")
	public List<Orders> orderCustomerId(@PathVariable int id) {
		return ordersService.getOrderByIdClient(id);
	}

	@PostMapping("/orders")
	public Orders newOrder(@RequestBody Orders newOrder) {
		return ordersService.saveOrder(newOrder);
	}

	@DeleteMapping("/orders/{id}")
	public void deleteOrder(@PathVariable int id) {
		ordersService.deleteOrder(id);
	}

	@PatchMapping("/orders/{id}")
	public Orders replaceOrder(@RequestBody Orders newOrder, @PathVariable int id) {
		return ordersService.updateOrder(newOrder, id);
	}

}
