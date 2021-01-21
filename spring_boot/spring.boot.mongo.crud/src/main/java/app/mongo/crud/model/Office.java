package app.mongo.crud.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="office")
public class Office {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	
	@NotEmpty(message = "Contact should not be left blank")
    @Size(min=3, max=50, message = "The contact should be in the range of 3 -> 50")
	private String contact;
	
	private String buildingName;
	private String address;
	private String postcode;
	private String city;
	private int size;
	private String tel;
	private String email;
	
	public Office() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Office(String id, String contact, String buildingName, String address, String postcode, String city,
			int size, String tel, String email) {
		super();
		this.id = id;
		this.contact = contact;
		this.buildingName = buildingName;
		this.address = address;
		this.postcode = postcode;
		this.city = city;
		this.size = size;
		this.tel = tel;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Office [id=" + id + ", contact=" + contact + ", buildingName=" + buildingName + ", address=" + address
				+ ", postcode=" + postcode + ", city=" + city + ", size=" + size + ", tel=" + tel + ", email=" + email
				+ "]";
	}

}
