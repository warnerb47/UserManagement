package dao;

import java.util.ArrayList;
import java.util.List;
import domain.User;
import java.sql.*;

public class UserDao {

	private static DaoFactory daoFactory = DaoFactory.getInstance();
	public static ArrayList<User> users = new ArrayList<User>();
	public static int lastId = 0;
	
	
	public static boolean addUser(User user) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        int id = user.getId();

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO users(id ,nom, prenom, login, password) VALUES(?, ?, ?, ?, SHA2(?, 256));");
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, user.getNom());
            preparedStatement.setString(3, user.getPrenom());
            preparedStatement.setString(4, user.getLogin());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

	}
	
	public static List<User> getUsers(){
        List<User> users = new ArrayList<User>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT id, nom, prenom, login, password FROM users;");

            while (resultat.next()) {
                String nom = resultat.getString("nom");
                String prenom = resultat.getString("prenom");
                String login = resultat.getString("login");
                String password = resultat.getString("password");
                int id = resultat.getInt("id");

                User user = new User(id, nom, prenom, login, password);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
	
	public static User getUser(int idUser) {
        User user = null;
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("SELECT id, nom, prenom, login, password FROM users WHERE id=?;");
            preparedStatement.setInt(1, idUser);
            resultat = preparedStatement.executeQuery();

            if(resultat.next()) {
                String nom = resultat.getString("nom");
                String prenom = resultat.getString("prenom");
                String login = resultat.getString("login");
                String password = resultat.getString("password");
                int id = Integer.parseInt(resultat.getString("id"));
                user = new User(id, nom, prenom, login, password);
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
		return user;
	}
	
	public static User login(String loginPayload, String passwordPayload) {
        User user = null;
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("SELECT id, nom, prenom, login, password FROM users WHERE (login=? and password=SHA2(?, 256));");
            preparedStatement.setString(1, loginPayload);
            preparedStatement.setString(2, passwordPayload);
            resultat = preparedStatement.executeQuery();

            if(resultat.next()) {
                String nom = resultat.getString("nom");
                String prenom = resultat.getString("prenom");
                String login = resultat.getString("login");
                String password = resultat.getString("password");
                int id = Integer.parseInt(resultat.getString("id"));
                user = new User(id, nom, prenom, login, password);
            }
    		return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
	}
	
	public static boolean updateUser(User payload) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        int resultat = 0;
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("Update  users Set nom=?, prenom=?, login=? WHERE id=?;");
            preparedStatement.setString(1, payload.getNom());
            preparedStatement.setString(2, payload.getPrenom());
            preparedStatement.setString(3, payload.getLogin());
            preparedStatement.setInt(4, payload.getId());
            resultat = preparedStatement.executeUpdate();

            return resultat != 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
	}
	
	public static boolean deleteUser(int id) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        int resultat = 0;
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("Delete FROM users WHERE id=?;");
            preparedStatement.setInt(1, id);
            resultat = preparedStatement.executeUpdate();
            return resultat != 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
	}
}


