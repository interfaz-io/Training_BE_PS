/**
 * 
 */
package io.interfaz.training.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jermy Calvo
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "orders_details")
@Entity
public class OrdersDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="order_id")
	private int orderID;
	
	@Column(name="product_id")
	private int productId;

	private int quantity;

	private BigDecimal price;

	@Column(name="total_amount")
	private int totalAmount;
}
