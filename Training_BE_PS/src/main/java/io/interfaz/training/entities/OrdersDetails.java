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
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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

	@Column(name = "order_id")
	private int orderId;

	private int quantity;

	private BigDecimal price;

	@Column(name = "total_amount")
	private int totalAmount;

	@OneToOne()
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	private Products products;

}
