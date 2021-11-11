/**
 * @author Delanie Johnson - dmjohnson33
 * CIS175 - Fall 2021
 * Sep 16, 2021
 */
package controller;

import javax.persistence.EntityManager; 
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import model.DogBreeds;

/**
 * @author delan
 *
 */
public class DogBreedHelp {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("DogBreeds");

	public void addADog(DogBreeds db) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(db);
		em.getTransaction().commit();
		em.close();
	}
	
	public void deleteADog(DogBreeds toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<DogBreeds> typedQuery = em.createQuery("select db from DogBreeds db where db.breed = :selectedBreed and db.name = :selectedName",DogBreeds.class);
		typedQuery.setParameter("selectedBreed", toDelete.getBreed());
		typedQuery.setParameter("selectedName",	toDelete.getName());
		typedQuery.setMaxResults(1);
		DogBreeds result	=	typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public List<DogBreeds>showAllDogs(){
		EntityManager em = emfactory.createEntityManager();
		List<DogBreeds> allItems = em.createQuery("SELECT i FROM DogBreeds i").getResultList();
		return allItems;
	}
	
	/**
	 * @param toEdit
	 */
	public void updateBreed(DogBreeds toEdit) {
		EntityManager em =emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	/**
	 * @param storeName
	 * @return
	 */
	public List<DogBreeds> searchForNameByBreed(String breed) {
		EntityManager	em	=	emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<DogBreeds> typedQuery	= em.createQuery("select db	from DogBreeds db where db.breed = :selectedBreed",DogBreeds.class);
		typedQuery.setParameter("selectedBreed", breed);
		List<DogBreeds>	foundDogs	=	typedQuery.getResultList();
		em.close();
		return foundDogs;		
	}

	/**
	 * @param itemName
	 * @return
	 */
	public List<DogBreeds> searchForBreedbyName(String itemName) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param idToEdit
	 * @return
	 */
	public DogBreeds searchForBreedById(int idToEdit) {
		EntityManager	em	=	emfactory.createEntityManager();
		em.getTransaction().begin();
		DogBreeds	findDog	=	em.find(DogBreeds.class,	idToEdit);
		em.close();
		return	findDog;
		
		
	}
	public	void	cleanUp(){
		emfactory.close();
		}
}
