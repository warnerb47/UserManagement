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
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/WEB-INF/login.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext()
		.getRequestDispatcher(VUE)
		.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String login = request.getParameter("login");
		login = (login == null)? "" : login;

		String password = request.getParameter("password");
		password = (password == null)? "" : password;
		
		if(UserMetier.login(login, password, request)) {
			response.sendRedirect(request.getContextPath());
		} else {
			response.sendRedirect("login?error=login ou mot de passe incorrect");
		}

	}

}
