/**
 * 
 */
package io.interfaz.training.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tthornton
 *
 */
@Table(name = "products")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Products {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private String description;

	private BigDecimal price;

	private String status;

	@OneToOne(mappedBy = "products")
	private OrdersDetails details;
}
