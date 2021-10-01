/**
 * @author Delanie Johnson - dmjohnson33
 * CIS175 - Fall 2021
 * Sep 16, 2021
 */

/**
 * @author delan
 *
 */
import java.util.List; 
import java.util.Scanner;
import controller.DogBreedHelp;
import model.DogBreeds;


public class StartDogBreeds {

		static Scanner in = new Scanner(System.in);
		static DogBreedHelp dbh = new DogBreedHelp();

		private static void addADog() {
			System.out.print("Enter a Dog Breed: ");
			String breed = in.nextLine();
			System.out.print("Enter a Dog Name:  ");
			String name = in.nextLine();
			
			DogBreeds toAdd = new DogBreeds(breed, name);
			dbh.addADog(toAdd);
		}

		private static void deleteADog() {
			System.out.print("Enter the breed to delete: ");
			String breed = in.nextLine();
			System.out.print("Enter the name to delete: ");
			String name = in.nextLine();
			DogBreeds	toDelete	=	new	DogBreeds(breed, name);
			dbh.deleteADog(toDelete);
		}

		private static void editADog() {
			System.out.println("How would you like to find the dog? ");
			System.out.println("1. Search by Breed");
			System.out.println("2. Search by Name");
			int searchBy = in.nextInt();
			in.nextLine();
			List<DogBreeds> foundDogs;
			if (searchBy == 1) {
				System.out.print("Enter the breed: ");
				String breedName = in.nextLine();
				foundDogs	=	dbh.searchForNameByBreed(breedName);
				
			} else {
				System.out.print("Enter the name: ");
				String dogName = in.nextLine();
				foundDogs	=	dbh.searchForBreedbyName(dogName);
			}

			if (!foundDogs.isEmpty()) {
				System.out.println("Found Results.");
				for (DogBreeds l : foundDogs) {
					System.out.println(l.getId() + " : " + l.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				DogBreeds toEdit = dbh.searchForBreedById(idToEdit);
				System.out.println("Retrieved " + toEdit.getBreed() + " from " + toEdit.getName());
				System.out.println("1 : Update Breed");
				System.out.println("2 : Update Name");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Breed: ");
					String newStore = in.nextLine();
					toEdit.setBreed(newStore);
				} else if (update == 2) {
					System.out.print("New Name: ");
					String newItem = in.nextLine();
					toEdit.setName(newItem);
				}

				dbh.updateBreed(toEdit);

			} else {
				System.out.println("error, no results!");
			}
		}

		public static void main(String[] args) {
			runDogMenu();
		}

		public static void runDogMenu() {
			boolean goAgain = true;
			System.out.println("Welcome to the ARL!");
			while (goAgain) {
				System.out.println("*  Select an Action:");
				System.out.println("*  1. Add a dog");
				System.out.println("*  2. Edit a dog");
				System.out.println("*  3. Delete a dog");
				System.out.println("*  4. View the list");
				System.out.println("*  5. Leave for the day");
				System.out.print("*  Enter Here: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addADog();
				} else if (selection == 2) {
					editADog();
				} else if (selection == 3) {
					deleteADog();
				} else if (selection == 4) {
					viewTheList();
				} else {
					dbh.cleanUp();
					System.out.println(" See You Soon! ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			List<DogBreeds> allDogs = dbh.showAllDogs();
			for(DogBreeds oneDog : allDogs) {
				System.out.println(oneDog.returnDogBreeds());
			}
		}

	}