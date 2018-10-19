package com.antawa.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "position")
public class Map implements UserDetails {
	
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

	@Column(unique = true)
	@NotNull
	private String address;

	/**
	 * Constructor.
	 */
	public Map() {
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

	/**
	 * @return the status
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param dir the status to set
	 */
	public void setAddress(String dir) {
		this.address = dir;
	}
	
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

}
