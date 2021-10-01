package controller;

import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DogBreeds;

/**
 * Servlet implementation class AddDogServley
 */
@WebServlet("/addDogServlet")
public class AddDogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AddDogServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String breed = request.getParameter("Breed");
		String name = request.getParameter("Name");	
		
		DogBreeds newDog = new DogBreeds(breed, name);
		DogBreedHelp dao = new DogBreedHelp();
		dao.addADog(newDog);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		
		doGet(request, response);
	}

}
