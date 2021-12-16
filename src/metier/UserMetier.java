package metier;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import dao.UserDao;
import domain.SessionKey;
import domain.User;

public class UserMetier {

	
	public static boolean login(String login, String password, HttpServletRequest request) {
		HttpSession session = request.getSession();
		List<User> users = UserDao.getUsers(); 

		if(users.isEmpty()) {// if no user 
			// check admin admin
			if(User.getDefault().getLogin().equals(login) && User.getDefault().getPassword().equals(password)) {
				session.setAttribute(SessionKey.currentUser.label, User.getDefault());
				return true;
			}
			return false;
		} else {
			User found = UserDao.login(login, password);
			if(found != null) {
				session.setAttribute(SessionKey.currentUser.label, found);
				return true;
			}
			return false;
		}
	}
	
	public static void logout(HttpServletRequest request) {
//		request.getSession().removeAttribute("currentUser");
//		request.getSession().removeAttribute("updatePayload");
//		request.getSession().removeAttribute("addPayload");
		for (SessionKey key : SessionKey.values()) {
			request.getSession().removeAttribute(key.label);
		}
		
	}
	
	public static boolean addUser(HttpServletRequest request, User payload, String passwordConfirm) {
		request.getSession().setAttribute(SessionKey.addPayload.label, payload);
		if(
				payload.getNom() != null && !"".equals(payload.getNom()) &&
				payload.getLogin() != null && !"".equals(payload.getLogin()) &&
				payload.getPrenom() != null && !"".equals(payload.getPrenom()) &&
				payload.getPassword() != null && !"".equals(payload.getPassword()) &&
				passwordConfirm.equals(payload.getPassword())
		) {
			payload.setId(UserDao.getUsers().size()+1);
			boolean result = UserDao.addUser(payload);
			if(result) {
				request.getSession().removeAttribute(SessionKey.addPayload.label);
			}
			return result;
		}
		return false;
	}

	public static boolean updateUser(HttpServletRequest request, User payload) {
		//request.getSession().setAttribute(SessionKey.updatePayload.label, payload);
		if(
				payload.getNom() != null && !"".equals(payload.getNom()) &&
				payload.getLogin() != null && !"".equals(payload.getLogin()) &&
				payload.getPrenom() != null && !"".equals(payload.getPrenom())
		) {
			boolean result = UserDao.updateUser(payload);
//			if(result) {
//				request.getSession().removeAttribute(SessionKey.updatePayload.label);
//			}
			return result;
		}
		return false;
	}
}
