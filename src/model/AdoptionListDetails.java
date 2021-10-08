/**
 * @author Delanie Johnson - dmjohnson33
 * CIS175 - Fall 2021
 * Oct 7, 2021
 */

/**
 * @author delan
 *
 */
@Entity
public class AdoptionListDetails {
	@Id
	@GeneratedValue
	private int id; 
	private String listName;
	private LocalDate adoptionDate;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Adopter adopter; 
	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER) 
	private List<AdoptionList> adoptionList;
	
	public AdoptionListDetails(int id, String listName, LocalDate adoptionDate,
			Adopter adopter, List<AdoptionList> adoptionList) {
	}
	public AdoptionListDetails(String listName, LocalDate adoptionDate,
			Adopter adopter, List<AdoptionList> adoptionList) {
	}
	public AdoptionListDetails(String listName, LocalDate adoptionDate,
			Adopter adopter) {
	}

}
