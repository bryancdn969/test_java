package com.antawa.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


@Entity
@Table(name = "users")
@Scope("session")
public  class User implements UserDetails{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static enum Role{ USER }
	/**
	 * Description of the property id.
	 */
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	/**
	 * Description of the property email.
	 */
	@Column(unique = true)
	private String username;
	/**
	 * Description of the property password.
	 */
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	/**
	 * Description of the property role , to grant authority to the user .
	 */
    private String  role;
    /**
	 * Description of the property full name.
	 */
    private String fullName;

    public User(){
    	
    }
    
    public User(String username,String password,String fullName){
    	this.username=username;
    	this.password= password;
    	this.fullName=fullName;
    }
    
	@JsonIgnore
	@Override
	public boolean isEnabled() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(role));
		return authorities;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role +
				 ",]";
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}
	

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Long getId() {
		return id;
	}
}
//public class User implements Serializable {
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//
//	private Long id;
//	private String username ;
//	private String password ;
//	private boolean enabled;
//	private String fullName;
//	private Set<Role> roles = new HashSet<Role>(0);
//	
//	public User(){	
//    }
//	
//	public User(String username,String password,String fullName, Boolean enabled){
//    	this.username=username;
//    	this.password= password;
//    	this.fullName=fullName;
//    	this.enabled=enabled;
//    }
//    
//    public User(String username,String password,String fullName, Boolean enabled, Set<Role> roles){
//    	this.username=username;
//    	this.password= password;
//    	this.fullName=fullName;
//    	this.enabled=enabled;
//    	this.roles=roles;
//    }
//    
//	/**
//	 * Description of the property id.
//	 */
//	@Id
//	@GeneratedValue(strategy= GenerationType.IDENTITY)
//	@Column(name = "id", unique = true, nullable = false)
//	public Long getId() {
//		return this.id;
//	}
//	
//	public void setId(Long id) {
//		this.id = id;
//	}
//	
//	/**
//	 * Description of the property user_name or email.
//	 */
//	@Column(name = "username", unique = true, nullable = false,length = 30)
//	public String getUsername() {
//		return this.username;
//	}
//	
//	public void setUsername(String username) {
//		this.username = username;
//	}
//	
//	/**
//	 * Description of the property password.
//	 */
//	@JsonProperty(access = Access.WRITE_ONLY)
//	@Column(name = "password", unique = true, nullable = false,length = 8)
//	public String getPassword() {
//		return password;
//	}
//	
//	public void setPassword(String password) {
//		this.password = password;
//	}
//	
//	/**
//	 * Description of the property full_name.
//	 */
//	@Column(name = "full_name", unique = true, nullable = false,length = 50)
//	public String getFullName() {
//		return fullName;
//	} 	
//	
//	public void setFullName(String fullName) {
//		this.fullName = fullName;
//	}
//	
//	/**
//	 * Description of the property enabled.
//	 */
//	@Column(name = "enabled", nullable = false)
//	public boolean isActive(){
//		return this.enabled;
//	}
//
//	public void setActive(boolean active){
//		this.enabled = active;
//	}
//	
//	/**
//	 * Description of the property many to many with roles.
//	 */
//	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinTable(name = "role_users", joinColumns = { 
//			@JoinColumn(name = "roles_id", nullable = false, updatable = false) }, 
//			inverseJoinColumns = { @JoinColumn(name = "users_id", 
//					nullable = false, updatable = false) })
//	public Set<Role> getRoles() {
//		return this.roles;
//	}
//
//	public void setRoles(Set<Role> roles) {
//		this.roles = roles;
//	}
//	
//}
