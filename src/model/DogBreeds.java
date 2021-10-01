/**
 * @author Delanie Johnson - dmjohnson33
 * CIS175 - Fall 2021
 * Sep 16, 2021
 */
package model;

/**
 * @author delan
 *
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dogs")
public class DogBreeds {
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	
	@Column(name="BREED")
	private String breed;
	
	@Column(name="NAME")

	private String name;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DogBreeds() {
		super(); //default
	}
	
	public DogBreeds(String breed, String name) {
		this.breed = breed;
		this.name = name;
	}
	
	public String returnDogBreeds() {
		return this.breed + " named " + this.name;
		}
}
