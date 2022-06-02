package Controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class DashboardController {

	@FXML
	private Button AjoutBT;
	 @FXML
	 private Button detailssalarier;
	@FXML
	private Button ListeEmployesBT;

	@FXML
	private Button ListeVendeursBT;

	@FXML
	private AnchorPane MainPane;

	@FXML
	private Button SalarieFaibleBT;

	@FXML
	private Button home;

	@FXML
	private Button listeSalarieBT;

	@FXML
	private Button logout;

	@FXML
	private Text title;

	@FXML
	void LoadListeSalarie(ActionEvent event) {
		try {
			title.setText("Liste des Salariés");
			AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/GestionSalarier.fxml"));
			System.out.println("loaded");
			MainPane.getChildren().setAll(pane);
		} catch (IOException ex) {
			System.out.println("il ya un erreuer");
		}
	}

	@FXML
	void gotoHome(ActionEvent event) {

	}

	@FXML
	void gotoLogin(ActionEvent event) {

	}

	@FXML
	void loadAjoutdesSalarie(ActionEvent event) {
		try {
			title.setText("Ajouter des Salariés");
			AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/AjoutSalariee.fxml"));
			System.out.println("loaded");
			MainPane.getChildren().setAll(pane);
		} catch (IOException ex) {
			System.out.println("il ya un erreuer");
		}
	}

	@FXML
	void loadListeEmployes(ActionEvent event) {
		try {
			title.setText("Liste des Employes");
			AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/Listeremployer.fxml"));
			System.out.println("loaded");
			MainPane.getChildren().setAll(pane);
		} catch (IOException ex) {
			System.out.println("il ya un erreuer");
		}
	}

	@FXML
	void loadListeVendeurs(ActionEvent event) {
		try {
			title.setText("Liste des Vendeurs");
			AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/ListerVendeur.fxml"));
			System.out.println("loaded");
			MainPane.getChildren().setAll(pane);
		} catch (IOException ex) {
			System.out.println("il ya un erreuer");
		}
	}

	@FXML
	void loadSalarieFaible(ActionEvent event) {

	}
	
    @FXML
    void loadDetailsSalarier(ActionEvent event) {

    }
    

	public void LoderInAnchore(String url) {
		try {
			AnchorPane pane = FXMLLoader.load(getClass().getResource(url));
			MainPane.getChildren().setAll(pane);
		} catch (IOException ex) {
			System.out.println("il ya un erreuer dashbored");

		}
	}
}
