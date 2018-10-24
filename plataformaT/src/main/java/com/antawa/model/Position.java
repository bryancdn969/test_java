package com.antawa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "data")
public class Position implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Description of the property id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	@NotNull
	private Float latitude;

	@Column(unique = true)
	@NotNull
	private Float longitude;

	/**
	 * Constructor.
	 */
	public Position() {
		super();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the code
	 */
	public Float getLat() {
		return latitude;
	}

	/**
	 * @param lat the code to set
	 */
	public void setCode(Float lat) {
		this.latitude = lat;
	}

	/**
	 * @return the name
	 */
	public Float getLng() {
		return longitude;
	}

	/**
	 * @param lng the name to set
	 */
	public void setName(Float lng) {
		this.longitude = lng;
	}
		
}
