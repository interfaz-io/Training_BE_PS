
/**
 * 
 */
package io.interfaz.training.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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

	@JsonBackReference
	@ManyToOne()
	@JoinColumn(name = "customer_id")
	private Customers customer;

	@Column(name = "purchase_date")
	private Date purchaseDate;

	private BigDecimal subtotal;

	private BigDecimal iva;

	private BigDecimal total;

	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "order", fetch = FetchType.LAZY)
	private List<OrdersDetails> details;
}
