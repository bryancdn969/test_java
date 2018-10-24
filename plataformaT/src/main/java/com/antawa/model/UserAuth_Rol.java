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
@Table(name="userAuth_rol")
public class UserAuth_Rol implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Description of the property id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ur_id;
	
	@Column
	@NotNull
	private Long userauth_id;
	
	@Column
	@NotNull
	private Long rol_id;
	
	/**
	 * Constructor.
	 */
	public UserAuth_Rol() {
		super();
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return this.ur_id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.ur_id = id;
	}

	/**
	 * @return the user id
	 */
	public Long getUserName() {
		return this.userauth_id;
	}

	/**
	 * @param ui the code to set
	 */
	public void setUserName(Long ui) {
		this.userauth_id = ui;
	}
	
	/**
	 * @return the rol id
	 */
	public Long getPassword() {
		return this.rol_id;
	}

	/**
	 * @param ri the code to set
	 */
	public void setPassword(Long ri) {
		this.rol_id = ri;
	} 

}
