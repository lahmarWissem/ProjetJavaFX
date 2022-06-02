package classes;

public class Salariee {
	private int Matricule_ID;
	private String Nom;
	private String Email;
	private double Recrutement;
	private double Salaire;
	private double Vente;
	private double Pourcentage;
	private double HSupp;
	private double PHsupp;
	private String Categorie;
	private int Id_Entreprise;
	public int getMatricule_ID() {
		return Matricule_ID;
	}
	public void setMatricule_ID(int matricule_ID) {
		Matricule_ID = matricule_ID;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public double getRecrutement() {
		return Recrutement;
	}
	public void setRecrutement(double recrutement) {
		Recrutement = recrutement;
	}
	public double getSalaire() {
		return Salaire;
	}
	public void setSalaire(double salaire) {
		Salaire = salaire;
	}
	public double getVente() {
		return Vente;
	}
	public void setVente(double vente) {
		Vente = vente;
	}
	public double getPourcentage() {
		return Pourcentage;
	}
	public void setPourcentage(double pourcentage) {
		Pourcentage = pourcentage;
	}
	public double getHSupp() {
		return HSupp;
	}
	public void setHSupp(double hSupp) {
		HSupp = hSupp;
	}
	public double getPHsupp() {
		return PHsupp;
	}
	public void setPHsupp(double pHsupp) {
		PHsupp = pHsupp;
	}
	public String getCategorie() {
		return Categorie;
	}
	public void setCategorie(String categorie) {
		Categorie = categorie;
	}
	public int getId_Entreprise() {
		return Id_Entreprise;
	}
	public void setId_Entreprise(int id_Entreprise) {
		Id_Entreprise = id_Entreprise;
	}
	public Salariee(int matricule_ID, String nom, String email, double recrutement, double salaire, double vente, double pourcentage, double hSupp, double pHsupp, String categorie, int id_Entreprise) {
		super();
		Matricule_ID = matricule_ID;
		Nom = nom;
		Email = email;
		Recrutement = recrutement;
		Salaire = salaire;
		Vente = vente;
		Pourcentage = pourcentage;
		HSupp = hSupp;
		PHsupp = pHsupp;
		Categorie = categorie;
		Id_Entreprise = id_Entreprise;
	}
	public Salariee() {
		super();
	}
	public Salariee(int matricule_ID, String nom, String email,String categorie, double salaire) {
		Matricule_ID = matricule_ID;
		Nom = nom;
		Email = email;
		Salaire = salaire;
		Categorie = categorie;
	}

	public Salariee(int matricule_ID, String nom, String email, String categorie, double recrutement, double salaire, double vente) {
		Matricule_ID = matricule_ID;
		Nom = nom;
		Email = email;
		Recrutement = recrutement;
		Salaire = salaire;
		Vente = vente;
		Categorie = categorie;
	}
	@Override
	public String toString() {
		return "Salariee [Matricule_ID=" + Matricule_ID + ", Nom=" + Nom + ", Email=" + Email + ", Recrutement="
				+ Recrutement + ", Salaire=" + Salaire + ", Vente=" + Vente + ", Pourcentage=" + Pourcentage
				+ ", HSupp=" + HSupp + ", PHsupp=" + PHsupp + ", Categorie=" + Categorie + ", Id_Entreprise="
				+ Id_Entreprise + "]";
	}
	
	
	
}
