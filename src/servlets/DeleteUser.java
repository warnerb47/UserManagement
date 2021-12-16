package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import domain.User;

/**
 * Servlet implementation class DeleteUser
 */
@WebServlet("/delete")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("user");
		if(id != null && id.matches("[0-9]+") ) {
			int idUser = Integer.parseInt(id);
			User found = UserDao.getUser(idUser);
			if(found != null) {
				boolean result = UserDao.deleteUser(idUser);
				if(result) {
					response.sendRedirect(request.getContextPath());
				} else {
					response.sendRedirect("/?error=Erreur impossible de supprimer l'utilisateur");
				}
			} else {
				response.sendRedirect("/?error=Erreur impossible de supprimer l'utilisateur");
			}
		} else {
			response.sendRedirect(request.getContextPath());
		}
	}

}
