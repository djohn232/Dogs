package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewAllDogsServlet
 */
@WebServlet("/viewAllDogsServlet")
public class ViewAllDogsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ViewAllDogsServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DogBreedHelp dao = new DogBreedHelp();
		request.setAttribute("allDogs", dao.showAllDogs());
		String path = "/dog-list.jsp";
		if(dao.showAllDogs().isEmpty()){
		path = "/index.html";
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/dog-list.jsp"; //unsure if this should be here or not 
		getServletContext().getRequestDispatcher(path).forward(request,response);
		doGet(request, response);
	}

}
