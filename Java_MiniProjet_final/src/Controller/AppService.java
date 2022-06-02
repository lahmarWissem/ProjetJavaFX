package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import classes.Salariee;
import database.Connexion;

public class AppService {
	public boolean ajouterSalariee(Salariee E) {
		try {
			Statement stmt = Connexion.getConx().createStatement();
			if (E.getRecrutement() < 2005)
				E.setSalaire(400);
			else
				E.setSalaire(280);
			String reqSalarie = "Insert into salariee values(" + E.getMatricule_ID() + ",'" + E.getNom() + "','"
					+ E.getEmail() + "'," + E.getRecrutement() + "," + E.getSalaire() + "," + E.getVente() + ","
					+ E.getPourcentage() + "," + E.getHSupp() + "," + E.getPHsupp() + ",'" + E.getCategorie() + "',1);";
			if (stmt.executeUpdate(reqSalarie) == 1) {

				return true;
			}
		} catch (SQLException ex) {
			System.out.println("Erreur SQL" + ex);
		}
		return false;
	}
	public boolean Updatesalariee(Salariee E) {
		try {
			Statement stmt = Connexion.getConx().createStatement();
			if (E.getRecrutement() < 2005)
				E.setSalaire(400);
			else
				E.setSalaire(280);
			String reqSalarie = "update salariee set Matricule_ID=" + E.getMatricule_ID() + ",nom='" + E.getNom() + "', email='"
					+ E.getEmail() + "', Recrutement=" + E.getRecrutement() +",Salaire="+E.getSalaire()+",Vente="+E.getVente()+",Pourcentage="+ E.getPourcentage() +",HSupp="+E.getHSupp()+",PHsupp="+E.getPHsupp()+",Categorie='"+E.getCategorie()+"' where Matricule_ID=" + E.getMatricule_ID();
			if (stmt.executeUpdate(reqSalarie) == 1) {
				return true;
			}
		} catch (SQLException ex) {
			System.out.println("Erreur SQL" + ex);
		}
		return false;
	}

	public List<Salariee> listerSalariee() {
		List<Salariee> sals = new ArrayList<>();

		try {
			String reqSal = "SELECT Matricule_ID, nom, email, Categorie,Salaire from salariee;";
			Statement stmt = Connexion.getConx().createStatement();
			ResultSet salE = stmt.executeQuery(reqSal);
			while (salE.next()) {
				sals.add(new Salariee(salE.getInt(1), salE.getString(2), salE.getString(3), salE.getString(4),
						salE.getDouble(5)));
			}
			return sals;
		} catch (SQLException e) {
			System.out.println("Erreur SQL" + e);
		}
		return null;
	}
	
	public Salariee VendeurDetailsforupdate(int ID) {
		try {
			String req = "SELECT Matricule_ID, nom, email,Categorie, Recrutement,(salaire + Vente * Pourcentage) as salaireTot,Vente  from salariee where Categorie ='vendeur'  and  Matricule_ID ="
		    + ID;
			Statement stmt = Connexion.getConx().createStatement();
			ResultSet rs = stmt.executeQuery(req);

			if (rs.next()) {
				return new Salariee (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(8), rs.getDouble(4),
						rs.getDouble(5), rs.getDouble(6));
			}

		} catch (SQLException ex) {
			System.out.println("Erreur SQL " + ex);
		}
		return null;
	}
	public Salariee EmployerDetailsforupdate(int ID) {
		try {
			String req = "SELECT Matricule_ID, nom, email,Categorie, Recrutement, (salaire + HSupp * PHSupp) as salaireTot,Hsupp  from salariee where Categorie ='employer'"
					+ "and  Matricule_ID ="+ ID;
			Statement stmt = Connexion.getConx().createStatement();
			ResultSet rs = stmt.executeQuery(req);
			if (rs.next()) {
				return new Salariee (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(8), rs.getDouble(4),
						rs.getDouble(5), rs.getDouble(6));
			}

		} catch (SQLException ex) {
			System.out.println("Erreur SQL " + ex);
		}
		return null;
	}

	public boolean deleteSalarie(int salID) {
		try {
			String req = "Delete from salariee where Matricule_ID =" + salID;
			Statement stmt = Connexion.getConx().createStatement();
			// System.out.println(stmt.executeUpdate(req));
			if (stmt.executeUpdate(req) == 1) {
				return true;
			}
		} catch (SQLException ex) {
			System.out.println("Erreur sql");
		}
		return false;
	}

	public List<Salariee> VendeurDetails() {
		List<Salariee> sals = new ArrayList<>();
		try {

			String req = "SELECT Matricule_ID, nom, email,Categorie, Recrutement,(salaire + Vente * Pourcentage) as salaireTot,Vente  from salariee where Categorie ='vendeur';";
			Statement stmt = Connexion.getConx().createStatement();
			ResultSet rs = stmt.executeQuery(req);

			while (rs.next()) {
				sals.add(new Salariee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5),
						rs.getDouble(6), rs.getDouble(7)));
			}
			return sals;

		} catch (SQLException ex) {
			System.out.println("Erreur SQL " + ex);
		}
		return null;
	}

	public List<Salariee> EmployeDetails() {
		List<Salariee> sals = new ArrayList<>();
		try {
			String req = "SELECT Matricule_ID, nom, email,Categorie, Recrutement, (salaire + HSupp * PHSupp) as salaireTot,Hsupp  from salariee where Categorie ='employer';";
			Statement stmt = Connexion.getConx().createStatement();
			ResultSet rs = stmt.executeQuery(req);

			while (rs.next()) {
				sals.add(new Salariee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5),
						rs.getDouble(6), rs.getDouble(7)));
			}
			return sals;

		} catch (SQLException ex) {
			System.out.println("Erreur SQL " + ex);
		}
		return null;
	}
	
	

	public  List<Salariee>  getsalparanciente() {
		List<Salariee> sals = new ArrayList<>();
		try {
			String reqSal = "SELECT Matricule_ID, nom, email, Categorie,Salaire from salariee ORDER by Recrutement  AppSerC;";
			Statement stmt = Connexion.getConx().createStatement();
			ResultSet salE = stmt.executeQuery(reqSal);
			while (salE.next()) {
				sals.add(new Salariee(salE.getInt(1), salE.getString(2), salE.getString(3), salE.getString(4),
					salE.getDouble(5)));
			}
			return sals;
		} catch (SQLException ex) {
			System.out.println(ex);
		}
		return null;
	}

	public Salariee MaxVendeur() {
		try {
			String req = "Select Matricule_ID, nom, email, Categorie,(salaire + Vente * Pourcentage) from salariee where Categorie='vendeur' ORDER by (salaire + Vente * Pourcentage) desc;";
			Statement stmt = Connexion.getConx().createStatement();
			ResultSet salE = stmt.executeQuery(req);
			salE.next();
			return new Salariee(salE.getInt(1), salE.getString(2), salE.getString(3), salE.getString(4),
					salE.getDouble(5));
		} catch (SQLException ex) {
			System.out.println(ex);
		}
		return null;
	}

	//public List<Salariee> getSalariesMinMax() {

	//}

//	public static void main(String Args[]) {
		//AppService AppSer = new AppService();
		// AppSer.createEntreprise(new Entreprise("Entrp1"));
		// AppSer.createEmployee(new Salariee(20,"wissem","wiss@gmail.com", 0, 0, 0, 0, 0,
		// 0,"employer", 1));
		//List<Salariee> salaries = AppSer.getSalariesMinMax(200, 400);
		// (Salariee i : salaries) {
			//System.out.println(i.toString());
		//}
	//}
}
