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
@Table(name="rol")
public class Rol implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Description of the property id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_rol;
	
	@Column(unique = true)
	@NotNull
	private String rol;
	
	@Column(unique = true)
	private String description;
	
//	@ManyToMany(fetch = FetchType.LAZY,
//            cascade = {
//                CascadeType.ALL
//            },
//            mappedBy = "rol")
//    private Set<UserAuth> usersAuths = new HashSet<>();

	/**
	 * Constructor.
	 */
	public Rol() {
		super();
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return this.id_rol;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id_rol = id;
	}

	/**
	 * @return the user rol
	 */
	public String getRol() {
		return this.rol;
	}

	/**
	 * @param rol the code to set
	 */
	public void setRol(String rol) {
		this.rol = rol;
	}
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * @param des the code to set
	 */
	public void setDescription(String des) {
		this.description = des;
	}
	
	/**
	 * @return the user usersAuths
	 */
//	public Set<UserAuth> getUserAuth() {
//		return this.usersAuths;
//	}
//
//	/**
//	 * @param ua the code to set
//	 */
//	public void setUserAuth(Set<UserAuth> ua) {
//		this.usersAuths = ua;
//	}
}
