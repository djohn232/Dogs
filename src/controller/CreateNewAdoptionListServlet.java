package controller;

import java.io.IOException;  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class CreateNewListServlet
 */
@WebServlet("/createNewAdoptionListServlet")
public class CreateNewAdoptionListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewAdoptionListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdopterHelper adh = new AdopterHelper();
		String adopterName = request.getParameter("adopterName");
		System.out.println("Adopter Name: "+ adopterName);
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String adopterName = request.getParameter("adopterName");
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year),
					Integer.parseInt(month), Integer.parseInt(day));
		}catch(NumberFormatException ex) {
			ld = LocalDate.now();
		}
		
		String[] selectedDogs = request.getParameterValues("allDogsToAdd");
		List<DogBreeds> selectedDogsInList = new ArrayList<DogBreeds>();
		
		//make sure something was selected – otherwise we get a null pointer exception
		if (selectedItems != null && selectedItems.length > 0) {
			for(int i = 0; i<selectedDogs.length; i++) {
				System.out.println(selectedDogs[i]);
				ListItem c = adh.searchForBreedById(Integer.parseInt(selectedItems[i]));
				selectedItemsInList.add(c);
			}
		}
		
		Adopter adopter = new Adopter(adopterName);
		DogBreeds db = new DogBreeds(listName, ld,shopper);
		
		db.setListOfItems(selectedItemsInList);
		AdoptionDetailsHelper adhl = new AdoptionDetailsHelper();
		adhl.insertNewListDetails(db);
		
		System.out.println("Yes!");
		System.out.println(sld.toString());
		getServletContext().getRequestDispatcher("viewAllListsServlet").forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
