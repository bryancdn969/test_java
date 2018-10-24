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
@Table(name = "user_auth")
public class UserAuth implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Description of the property id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_ua;
	
	@Column(unique = true)
	@NotNull
	private String userName;
	
	@Column(unique = true)
	@NotNull
	private String password;
	
	@Column
	@NotNull
	private Integer enabled;
	
//	@ManyToMany(fetch = FetchType.LAZY,
//            cascade = {
//                CascadeType.ALL
//            })
//    @JoinTable(name = "userAuth_rol",
//            joinColumns = { @JoinColumn(name = "userAuth_id") },
//            inverseJoinColumns = { @JoinColumn(name = "rol_id") })
//	private Set<Rol> roles = new HashSet<>();

	
	/**
	 * Constructor.
	 */
	public UserAuth() {
		super();
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return this.id_ua;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id_ua = id;
	}

	/**
	 * @return the user name
	 */
	public String getUserName() {
		return this.userName;
	}

	/**
	 * @param un the code to set
	 */
	public void setUserName(String un) {
		this.userName = un;
	}
	
	/**
	 * @return the user name
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * @param pw the code to set
	 */
	public void setPassword(String pw) {
		this.password = pw;
	}
	
	/**
	 * @return the user enables
	 */
	public Integer getEnabled() {
		return this.enabled;
	}

	/**
	 * @param en the code to set
	 */
	public void setEnabled(Integer en) {
		this.enabled = en;
	}    
	
	/**
	 * @return the user roles
	 */
//	public Set<Rol> getRoles() {
//		return this.roles;
//	}
//
//	/**
//	 * @param rol the code to set
//	 */
//	public void setRoles(Set<Rol> rol) {
//		this.roles = rol;
//	}
	
//	public UserAuth(String un, String pw, Integer en) {
//        this.userName = un;
//        this.password = pw;
//        this.enabled = en;
//    }
}
