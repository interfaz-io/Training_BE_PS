package io.interfaz.training.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.interfaz.training.entities.Orders;
import io.interfaz.training.repos.OrdersRepository;
/**
 * 
 * @author kcambronero
 *
 */
@Service
public class OrdersService {
	@Autowired
	private OrdersRepository ordersRespository;
	
	public Orders createOrder(Orders order) {
		
		return ordersRespository.save(order);
	}
	
	public List<Orders> getAll(){
		return (List<Orders>) ordersRespository.findAll();
	}
	
	public Optional<Orders> getById(int id) {
		return ordersRespository.findById(id);
	}
	
	public void deleteOrder(int id) {
		ordersRespository.deleteById(id);
	}
}
