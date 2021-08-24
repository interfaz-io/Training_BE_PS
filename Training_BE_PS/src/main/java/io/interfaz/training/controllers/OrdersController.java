
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

import io.interfaz.training.entities.Orders;
import io.interfaz.training.services.OrdersService;

@RestController
public class OrdersController {
	@Autowired
	public OrdersService ordersService;
	
	@GetMapping("/orders")
	public List<Orders> all(){
		return ordersService.getAll();
	}
	@GetMapping("/orders/{id}")
	public Optional<Orders> productId(@PathVariable int id) {
		return ordersService.getById(id);
	}
	@PostMapping("/addOrder")
	public Orders newOrder(@RequestBody Orders newOrder) {
		return ordersService.createOrder(newOrder);
	}
	@DeleteMapping("/orders/{id}")
	public void deleteOrder(@PathVariable int id) {
		ordersService.deleteOrder(id);
	}
	
	@PutMapping("/orders/{id}")
	public Orders replaceOrder(@RequestBody Orders newOrder, @PathVariable int id) {
		return ordersService.getById(id)
				.map(order ->{
					order.setCustomers(newOrder.getCustomers());
					order.setDetails(newOrder.getDetails());
					order.setIva(newOrder.getIva());
					order.setPurchaseDate(newOrder.getPurchaseDate());
					order.setSubtotal(newOrder.getSubtotal());
					order.setTotal(newOrder.getTotal());
					return ordersService.createOrder(order);
				})
				.orElseGet(()->{
					newOrder.setId(id);
					return ordersService.createOrder(newOrder);
				});
	}
	
	
}
