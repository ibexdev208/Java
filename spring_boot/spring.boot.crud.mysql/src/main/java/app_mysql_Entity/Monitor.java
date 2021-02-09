package app_mysql_Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

@Entity
@Table(name="monitor")
public class Monitor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "brand")
	private String brand;

	@Column(name = "resolution")
	private int resolution;

	@Column(name = "size")
	private int size;

	@Column(name = "model")
	private String model;

	@Column(name = "colour")
	private String colour;

	public Monitor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Monitor(long id, String brand, int resolution, int size, String model, String colour) {
		super();
		this.id = id;
		this.brand = brand;
		this.resolution = resolution;
		this.size = size;
		this.model = model;
		this.colour = colour;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getResolution() {
		return resolution;
	}

	public void setResolution(int resolution) {
		this.resolution = resolution;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	@Override
	public String toString() {
		return "Monitor [id=" + id + ", brand=" + brand + ", resolution=" + resolution + ", size=" + size + ", model="
				+ model + ", colour=" + colour + "]";
	}
}
