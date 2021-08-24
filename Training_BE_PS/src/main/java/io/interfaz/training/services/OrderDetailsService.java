package io.interfaz.training.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.interfaz.training.entities.Orders;
import io.interfaz.training.entities.OrdersDetails;
import io.interfaz.training.repos.OrderListRepository;
/**
 * 
 * @author kcambronero
 *
 */
@Service
public class OrderDetailsService {
	@Autowired
	private OrderListRepository ordersRespository;
	
	public OrdersDetails createOrder(OrdersDetails order) {
		
		return ordersRespository.save(order);
	}
	
	public List<OrdersDetails> getAll(){
		return (List<OrdersDetails>) ordersRespository.findAll();
	}
	
	public Optional<OrdersDetails> getById(int id) {
		return ordersRespository.findById(id);
	}
	
	public void deleteOrder(int id) {
		ordersRespository.deleteById(id);
	}
}