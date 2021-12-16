package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import domain.User;
import metier.UserMetier;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/add")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/WEB-INF/add.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext()
		.getRequestDispatcher(VUE)
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String prenom = request.getParameter("prenom");
		prenom = (prenom == null)? "" : prenom;

		String nom = request.getParameter("nom");
		nom = (nom == null)? "" : nom;

		String login = request.getParameter("login");
		login = (login == null)? "" : login;

		String password = request.getParameter("password");
		password = (password == null)? "" : password;
		
		String confirmPassword = request.getParameter("confirmPassword");
		confirmPassword = (confirmPassword == null)? "" : confirmPassword;
		
		User newUser = new User(0, nom, prenom, login, password);
		boolean result = UserMetier.addUser(request, newUser, confirmPassword);
		if(result) {
			response.sendRedirect(request.getContextPath());
		} else {
			response.sendRedirect("add?error=Erreur lors de l'ajout d'un utilisateur Vérifier les informations saisies");
		}
	}

}
