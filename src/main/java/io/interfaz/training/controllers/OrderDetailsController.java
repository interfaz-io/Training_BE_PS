package io.interfaz.training.controllers;

import java.math.BigDecimal;
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

import io.interfaz.training.entities.OrdersDetails;
import io.interfaz.training.services.OrderDetailsService;

/***
 * 
 * @author kcambronero
 *
 */
@RestController
public class OrderDetailsController {
	@Autowired
	public OrderDetailsService ordersService;

	@GetMapping("/orderDetails")
	public List<OrdersDetails> all() {
		return ordersService.getAll();
	}

	@GetMapping("/orderDetail/{id}")
	public Optional<OrdersDetails> getOrderDetails(@PathVariable int id) {
		return ordersService.getById(id);
	}
	
	@GetMapping("/details/{id}")
	public List<OrdersDetails> findAllByOrder(@PathVariable int id) {
		return ordersService.findAllByOrder(id);
	}

	@PostMapping("/orderDetails")
	public OrdersDetails newOrder(@RequestBody OrdersDetails newOrder) {
		return ordersService.createOrder(newOrder);
	}

	@DeleteMapping("/orderDetails/{id}")
	public void deleteOrder(@PathVariable int id) {
		ordersService.deleteOrder(id);
	}

	@PatchMapping("{id}/orderDetails")
	public OrdersDetails replaceOrderDetails(@RequestBody OrdersDetails newOrder, @PathVariable int id) {
		return ordersService.updateOrder(newOrder, id);
	}
}
