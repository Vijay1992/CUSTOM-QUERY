package customer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "customers")
public class Customer {
	@Id
	@GenericGenerator(name = "cidGeneraor",strategy = "customer.CIDGenerator")
	@GeneratedValue(generator = "cidGeneraor")
	private String id;

	private String name;
	private String email;
	private String address;

	protected Customer() {
	}

	protected Customer(String name, String email, String address) {
		this.name = name;
		this.email = email;
		this.address = address;
	}

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
