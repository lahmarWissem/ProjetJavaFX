package classes;

import java.util.HashMap;

public class Entreprise {
	private String nomEntreprise;
	private HashMap<Integer,Salariee> salaries;
	public Entreprise(String nomEntreprise) {
		super();
		this.nomEntreprise = nomEntreprise;
	}
	public String getNomEntreprise() {
		return nomEntreprise;
	}
	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}
	public HashMap<Integer, Salariee> getSalaries() {
		return salaries;
	}
	public void setSalaries(HashMap<Integer, Salariee> salaries) {
		this.salaries = salaries;
	}

	
}
