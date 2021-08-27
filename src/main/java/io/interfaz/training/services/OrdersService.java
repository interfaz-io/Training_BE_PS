package io.interfaz.training.services;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.interfaz.training.entities.Orders;
import io.interfaz.training.entities.OrdersDetails;
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

	public Orders updateOrder(Orders orderRequest, int identifier) {
		getTotals(orderRequest);
		return getById(identifier).map(order -> {
			order.setDetails(orderRequest.getDetails());
			order.setIva(orderRequest.getIva());
			order.setPurchaseDate(orderRequest.getPurchaseDate());
			order.setSubtotal(orderRequest.getSubtotal());
			order.setTotal(orderRequest.getTotal());
			return createOrder(order);
		}).orElseGet(() -> {
			return null;
		});
	}

	private void getTotals(Orders order) {
		List<OrdersDetails> list = order.getDetails();
		BigDecimal subTotal = new BigDecimal(0);
		for (Iterator<OrdersDetails> iterator = list.iterator(); iterator.hasNext();) {
			OrdersDetails ordersDetails = (OrdersDetails) iterator.next();
			subTotal.add(BigDecimal.valueOf(ordersDetails.getTotalAmount()));
			System.out.println(subTotal);
		}
		order.setSubtotal(subTotal);
		order.setTotal(subTotal.add(subTotal.multiply(order.getIva())));
	}

	public List<Orders> getAll() {
		return (List<Orders>) ordersRespository.findAll();
	}

	public Optional<Orders> getById(int id) {
		return ordersRespository.findById(id);
	}

	public List<Orders> getOrderByIdClient(int id) {
		return ordersRespository.findByCustomerId(id);
	}

	public void deleteOrder(int id) {
		ordersRespository.deleteById(id);
	}
}
