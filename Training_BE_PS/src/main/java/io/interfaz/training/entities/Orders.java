	
/**
 * 
 */
package io.interfaz.training.entities;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "orders")
@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name ="customer_id")
	private int customerId;
	
	@Column(name ="purchase_date")
	private Date purchaseDate;
	
	private BigDecimal subtotal;
	
	private BigDecimal iva;
	
	private BigDecimal total;
	
	@OneToMany(mappedBy ="order_id")
	private List<OrdersDetails> details ;
}