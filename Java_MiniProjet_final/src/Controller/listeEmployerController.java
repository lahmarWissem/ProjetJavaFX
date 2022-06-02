package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import classes.Salariee;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class listeEmployerController implements Initializable {

	@FXML
	private TableColumn<Salariee, Integer> Matricule;
	@FXML
	private TableColumn<Salariee, String> NomSalarié;
	@FXML
	private TableColumn<Salariee, String> Emailfield;
	@FXML
	private TableColumn<Salariee, Double> SalaireTfield;
	@FXML
	private TableColumn<Salariee, String> CatFiled;
    @FXML
    private TableColumn<Salariee, Double> Recrutementfield;
    @FXML
    private TableColumn<Salariee, Double> nbrheurfield;
    @FXML
    private TableColumn<Salariee, Double> Hsupp;
    @FXML
    private TableView<Salariee> table;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Matricule.setCellValueFactory(new PropertyValueFactory<>("Matricule_ID"));
		NomSalarié.setCellValueFactory(new PropertyValueFactory<>("Nom"));
		Emailfield.setCellValueFactory(new PropertyValueFactory<>("Email"));
		CatFiled.setCellValueFactory(new PropertyValueFactory<>("Categorie"));
		SalaireTfield.setCellValueFactory(new PropertyValueFactory<>("Salaire"));
		Recrutementfield.setCellValueFactory(new PropertyValueFactory<>("Recrutement"));
		Hsupp.setCellValueFactory(new PropertyValueFactory<>("HSupp"));
		AppService AS = new AppService();
		table.getItems().addAll(AS.EmployeDetails());
		//AS.EmployeDetails().toString();
		
	}



}
