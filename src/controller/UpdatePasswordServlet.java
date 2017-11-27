package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import dbHelpers.UpdateQuery;
import model.User;
import utilities.PasswordService;

/**
 * Servlet implementation class UpdatePasswordServlet
 */
@WebServlet({ "/UpdatePasswordServlet", "/UpdatePassword" })
public class UpdatePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UpdatePasswordServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// get the data
				String password = request.getParameter("password"); 
				PasswordService ps = new PasswordService();
				String newPassword = ps.encrypt(password);
				String addedOrUpdated = request.getParameter("addedOrUpdated"); 
				
				// Set up the session object and String for password
				User user = (User) request.getSession().getAttribute("user");
				user.setLastUpdated(addedOrUpdated);
				user.setPassword(newPassword);
			
				 
				// Create an UpdateQuery object and use it to update the book
				UpdateQuery uq = new UpdateQuery("chemistrydatabase", "root", ""); //Removed password for security reasons
				uq.doUpdatePassword(newPassword, user);
				
				// Pass control on to the ReadServlet
				String url = "/read";
				
				RequestDispatcher dispatcher = request.getRequestDispatcher(url);
				dispatcher.forward(request, response);
		
	}

}
