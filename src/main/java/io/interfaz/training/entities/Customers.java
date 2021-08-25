/**
 * 
 */
package io.interfaz.training.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "customers")
@Entity
public class Customers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@Column(name = "country_id")
	private int countryID;

	
	@Column(name = "first_name")
	private String firstName;

	
	@Column(name = "last_name")
	private String lastName;

	
	private String email;

	
	private String status;
	
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
//	@OneToMany(fetch = FetchType.LAZY)
//	@JoinColumn(name = "customer_id")
//	private List<Orders> orders ;

}
