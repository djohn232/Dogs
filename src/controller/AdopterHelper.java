/**
 * @author Delanie Johnson - dmjohnson33
 * CIS175 - Fall 2021
 * Oct 7, 2021
 */

/**
 * @author delan
 *
 */
public class AdopterHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Dogs");
	
	public void insertAdopter(Adopter a) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
		em.close();
		}
	
	public List<Dogs> showAllAdopters() {
		EntityManager em = emfactory.createEntityManager();
		List<Dogs> allAdopters = em.createQuery("SELECT a FROM Adopter a").getResultList();
		return allAdopters;
		}
}
