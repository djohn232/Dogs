import java.util.List;

/**
 * @author Delanie Johnson - dmjohnson33
 * CIS175 - Fall 2021
 * Oct 7, 2021
 */

/**
 * @author delan
 *
 */
public class AdoptionListDetailsTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Adopter greg = new Shopper("Greg");
		
		AdoptionDetailsHelper ldh = new AdoptionDetailsHelper();
		Adopter barney = new ListItem("Pitbull, Barney");
		Adopter jewel = new ListItem("Shitzu", "Jewel");
		List<Adopter> greglist = new ArrayList<Adopter>();
		gregList.add(barney);
		gregList.add(jewel);
		
		ListDetails gregList = new ListDetails("Greg's Adoption List", LocalDate.now(), greg);
		greglist.setListOfItems(gregList);
		ldh.insertNewListDetails(gregList);
		
		List<Adopter> allLists = ldh.getLists();
		for(Adopter a: allLists) {
			System.out.println(a.toString());
		}
		
	}
}
		

