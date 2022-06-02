package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connexion {
	private static Connection cn = null;

	public static Connection getConx() {
		try {
			if (cn == null) {
				Class.forName("com.mysql.jdbc.Driver");
				 cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet_java_finale", "root", "");
				System.out.println("Connected Successfuly");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return cn;
	}
	public static void main(String args[]) {
		Connexion.getConx();
	}
}
