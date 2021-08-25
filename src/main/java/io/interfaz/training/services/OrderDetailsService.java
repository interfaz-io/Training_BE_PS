package io.interfaz.training.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.interfaz.training.entities.OrdersDetails;
import io.interfaz.training.repos.OrderDetailsRepository;

/**
 * 
 * @author kcambronero
 *
 */
@Service
public class OrderDetailsService {
	@Autowired
	private OrderDetailsRepository ordersRespository;

	public OrdersDetails createOrder(OrdersDetails orderRequest) {
		orderRequest.setTotalAmount(
				BigDecimal.valueOf(orderRequest.getQuantity())
							.multiply(orderRequest
							.getPrice())
							.intValue());
		return ordersRespository.save(orderRequest);
	}

	public OrdersDetails updateOrder(OrdersDetails orderRequest, int identifier) {
		return getById(identifier).map(order -> {
			order.setPrice(orderRequest.getPrice());
			order.setProducts(orderRequest.getProducts());
			order.setQuantity(orderRequest.getQuantity());
			order.setTotalAmount(
					BigDecimal.valueOf(orderRequest.getQuantity()).multiply(orderRequest.getPrice()).intValue());
			return ordersRespository.save(order);
		}).orElseGet(() -> {
			return ordersRespository.save(orderRequest);
		});
	}

	public List<OrdersDetails> getAll() {
		return (List<OrdersDetails>) ordersRespository.findAll();
	}

	public Optional<OrdersDetails> getById(int id) {
		return ordersRespository.findById(id);
	}
	
	public List<OrdersDetails> findAllByOrder(int id) {
		return ordersRespository.findAllByOrder(id);
	}

	public void deleteOrder(int id) {
		ordersRespository.deleteById(id);
	}
}
