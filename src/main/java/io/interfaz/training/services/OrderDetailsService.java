package io.interfaz.training.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.interfaz.training.entities.Orders;
import io.interfaz.training.entities.OrdersDetails;
import io.interfaz.training.repos.OrderDetailsRepository;

/**
 * 
 * @author kcambronero
 *
 */
@Service
public class OrderDetailsService {
	@Value("${IVA}")
	private double IVA;
	@Autowired
	private OrderDetailsRepository ordersRespository;
	@Autowired
	private OrdersService ordersService;

	public OrdersDetails createOrder(OrdersDetails orderDeatils) {
		getTotalAmount(orderDeatils);
		getTotalOrder(orderDeatils.getOrder(), orderDeatils);
		return ordersRespository.save(orderDeatils);
	}

	private void getTotalAmount(OrdersDetails orderDeatils) {
		orderDeatils.setTotalAmount(
				BigDecimal.valueOf(orderDeatils.getQuantity()).multiply(orderDeatils.getPrice()).intValue());
	}

	private void getTotalOrder(int id, OrdersDetails ordersDetails) {
		Orders order = ordersService.getById(id).get();
		BigDecimal subTotal = BigDecimal.ZERO;
		subTotal = subTotal.add(BigDecimal.valueOf(ordersDetails.getTotalAmount()));
		order.setSubtotal(order.getSubtotal().add(subTotal));
		BigDecimal tempIva = subTotal.multiply(BigDecimal.valueOf(IVA));
		order.setIva(order.getIva().add(tempIva));
		order.setTotal(order.getTotal().add(subTotal.add(tempIva)));
	}

	public OrdersDetails updateOrder(OrdersDetails orderDeatils, int identifier) {
		orderDeatils.setId(identifier);
		getTotalAmount(orderDeatils);
		getTotalOrder(orderDeatils.getOrder(), orderDeatils);
		return ordersRespository.save(orderDeatils);
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
