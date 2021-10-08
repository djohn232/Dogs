/**
 * @author Delanie Johnson - dmjohnson33
 * CIS175 - Fall 2021
 * Oct 7, 2021
 */
package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author delan
 *
 */
@Entity
@Table(name = "adopter")

public class Adopter {

	@Id
	@GeneratedValue
	private int id;
	private String adopterName;
	
	public Adopter() {
		super();
	}
	
	public Adopter(int id, String adopterName) {
		super();
		this.id= id;
		this.adopterName = adopterName;
	}
	
	public Adopter(String adopterName) {
		super();
		this.adopterName = adopterName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdopterName() {
		return adopterName;
	}

	public void setAdopterName(String adopterName) {
		this.adopterName = adopterName;
	}

	@Override
	public String toString() {
		return "Adopter [id=" + id + ", adopterName=" + adopterName + "]";
	}
	
}
