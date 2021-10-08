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
import model.Adopter;
import model.AdopterHelper;

public class AdopterTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Adopter greg = new Adopter("Greg");
		Adopter john = new Adopter("John");
		
		AdopterHelper ad = new AdopterHelper();
		
		ad.insertAdopter(greg);
		ad.insertAdopter(john);
		
		List<Adopter> allAdopters = ad.showAllAdopters();
		
		for(Adopter ad: allAdopters) {
			System.out.println(ad.toString());
		}
	}
}
