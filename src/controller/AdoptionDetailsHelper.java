import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Adopter;
import model.AdoptionListDetails;

/**
 * @author Delanie Johnson - dmjohnson33
 * CIS175 - Fall 2021
 * Oct 7, 2021
 */

/**
 * @author delan
 *
 */


public class AdoptionDetailsHelper {
	
	public class ListDetailsHelper {
		static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Dogs");
		
		public void insertNewListDetails(DogBreedHelp a) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			em.persist(a);
			em.getTransaction().commit();
			em.close();
		}
		
		public List<StartDogBreeds> getLists() {
			EntityManager em = emfactory.createEntityManager();
			List<StartDogBreeds> allDetails = em.createQuery("SELECT d FROM ListDetails d").getResultList();
			return allDetails;
		}
	}

}
