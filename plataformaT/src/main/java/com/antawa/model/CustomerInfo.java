package com.antawa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customerinfo")
public class CustomerInfo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Description of the property id.
	 */
		@Id
		@GeneratedValue(strategy= GenerationType.IDENTITY)
		private Long id;

		@Column(nullable = false,length = 150)
		private String name;
	     
		@Column(nullable = false,length = 150)
	    private String address;
	     
		@Column(nullable = false,length = 750)
	    private String email;
	 
	    public String getName() {
	        return name;
	    }
	 
	    public void setName(String name) {
	        this.name = name;
	    }
	 
	    public String getAddress() {
	        return address;
	    }
	 
	    public void setAddress(String address) {
	        this.address = address;
	    }
	 
	    public String getEmail() {
	        return email;
	    }
	 
	    public void setEmail(String email) {
	        this.email = email;
	    }
	 
	    @Override
	    public String toString() {
	        return "CustomerInfo [name=" + name + ", address=" + address + ", email=" + email + "]";
	    }
//		@Column(unique = true, nullable = false,length = 150)
//		private String to;
//		
//		@Column(unique = true, nullable = false,length = 150)
//		private String from;
//		
//		@Column(length = 50)
//		private String object;
//		
//		@Column(length = 1024)
//		private String message;
//		
//		@Column(nullable = false,length = 50)
//	 	private String date_register;
//		
//		@Column(nullable = false,length = 50)
//		private String date_send_enamil;
//		
//		@Column(nullable = false,length = 3)
//		private String estate;
//	 
//	    public String getTo() {
//	        return to;
//	    }
//	 
//	    public Long getId() {
//			return id;
//		}
//
//		public void setId(Long id) {
//			this.id = id;
//		}
//
//		public String getMessage() {
//			return message;
//		}
//
//		public void setMessage(String message) {
//			this.message = message;
//		}
//
//		public String getDate_register() {
//			return date_register;
//		}
//
//		public void setDate_register(String date_register) {
//			this.date_register = date_register;
//		}
//
//		public String getDate_send_enamil() {
//			return date_send_enamil;
//		}
//
//		public void setDate_send_enamil(String date_send_enamil) {
//			this.date_send_enamil = date_send_enamil;
//		}
//
//		public String getEstate() {
//			return estate;
//		}
//
//		public void setEstate(String estate) {
//			this.estate = estate;
//		}
//
//		public void setTo(String to) {
//	        this.to = to;
//	    }
//	 
//	    public String getFrom() {
//	        return from;
//	    }
//	 
//	    public void setFrom(String from) {
//	        this.from = from;
//	    }
//	 
//	    public String getObject() {
//	        return object;
//	    }
//	 
//	    public void setObject(String object) {
//	        this.object = object;
//	    }
//	 
//	    @Override
//	    public String toString() {
//	        return "CustomerInfo [to=" + to + ", from=" + from + ", object=" + object + ", "
//	        		+ "message=" + message +",estate=" + estate + ",date_send_enamil=" + date_send_enamil +"]";
//	    }
}
