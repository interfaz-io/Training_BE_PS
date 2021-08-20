package io.interfaz.training.pojos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Victor Bolanos
 *
 */
@Data
@Table(name = "merchant")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Merchant {

	private int id;

	private String name;

	private String description;

	private String status;

	@Column(name = "creationdate")
	private Date creationDate;

}
