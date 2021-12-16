package dao;

import domain.User;

public class Test {

	public static void main(String[] args) {
		User user = new User(2, "a", "a", "a", "a");
		boolean done = UserDao.addUser(user);
		if(done) {
			System.out.println("Utilisateur créé avec succés");
		}else {
			System.out.println("Erreur lors de l'ajout d'un utilisateur");
		}
		
		
		done = UserDao.updateUser(new User(2, "b", "b", "b", "b"));
		if(done) {
			System.out.println("Utilisateur modifié avec succés");
		}else {
			System.out.println("Erreur lors de la modification d'un utilisateur");
		}
		
		User found = UserDao.login("b", "a");
		if(found != null) {
			System.out.println("Utilisateur connecté ");
		}else {
			System.out.println("Impossible de se connecter");
		}
		
		done = UserDao.deleteUser(2);
		if(done) {
			System.out.println("Utilisateur supprimé avec succés");
		}else {
			System.out.println("Erreur lors de la supression d'un utilisateur");
		}

	}

}
