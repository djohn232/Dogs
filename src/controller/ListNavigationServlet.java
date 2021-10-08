package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListDetails;

/**
 * Servlet implementation class ListNavigationServlet
 */
@WebServlet("/listNavigationServlet")
public class ListNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListNavigationServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdoptionDetailsHelper dao = new AdoptionDetailsHelper();
		String action = request.getParameter("doThisToList");
		
		if (action == null) {
			getServletContext().getRequestDispatcher("viewAllListsServlet").forward(request, response);
		} else if (action.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ListDetails listToDelete = dao.searchForListDetailsById(tempId); 
				dao.deleteList(listToDelete);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to click a button");
			} finally {
				getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
			}
		} else if (action.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				DogBreeds listToEdit = dao.searchForBreedById(tempId);

				request.setAttribute("listToEdit", listToEdit);
				request.setAttribute("month", listToEdit.getAdoptionDate().getMonthValue());
				request.setAttribute("date", listToEdit.getAdoptionDate().getDayOfMonth());
				request.setAttribute("year", listToEdit.getAdoptionDate().getYear());

				DogBreedHelp daoForItems = new DogBreedHelp();
				request.setAttribute("allItems", daoForItems.showAllDogs());
					if(daoForItems.showAllDogs().isEmpty()){
						request.setAttribute("allItems", " ");
					}
					getServletContext().getRequestDispatcher("/edit-dog.jsp").forward(request, response);
				} catch (NumberFormatException e) {
				getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
				}
		} else if (action.equals("add")) {
			getServletContext().getRequestDispatcher("/new-list.html").forward(request, response);
		}
		
		doGet(request, response);
	}

}

