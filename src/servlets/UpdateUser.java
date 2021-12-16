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
 * Servlet implementation class UpdateUser
 */
@WebServlet("/update")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/WEB-INF/update.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("user");
		if(id != null && id.matches("[0-9]+") ) {
			int idUser = Integer.parseInt(id);
			User found = UserDao.getUser(idUser);
			if(found != null) {
				request.setAttribute("user", found);
				getServletContext()
				.getRequestDispatcher(VUE)
				.forward(request, response);
			} else {
				response.sendRedirect("update?error=Erreur impossible d'afficher l'utilisateur&user="+id);
			}
		} else {
			response.sendRedirect(request.getContextPath());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if(id != null && id.matches("[0-9]+") ) {
			int idUser = Integer.parseInt(id);
			
			String prenom = request.getParameter("prenom");
			prenom = (prenom == null)? "" : prenom;

			String nom = request.getParameter("nom");
			nom = (nom == null)? "" : nom;

			String login = request.getParameter("login");
			login = (login == null)? "" : login;

			String password = request.getParameter("password");
			password = (password == null)? "" : password;
			
			User payload = new User(idUser, nom, prenom, login, password);
			boolean result = UserMetier.updateUser(request, payload);
			if(result) {
				response.sendRedirect(request.getContextPath());
			} else {
				response.sendRedirect("update?error=Erreur lors de la modification d'un utilisateur&user="+id);
			}			
		} else {
			response.sendRedirect(request.getContextPath());
		}
	}

}
