package Controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import classes.Salariee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GestionSalarieeController implements Initializable {
    @FXML
    private Button LISTAN;
    @FXML
    private Button listMaxTAUXbtn;
    @FXML
    private TextField maxfield;
    @FXML
    private Button exporterbtn;
  
    @FXML
    private TextField minfiled;

    @FXML
    private Button minmaxbtn;

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
	private Button addSalarieebtn;
	@FXML
	private Button deletesalbtn;
	@FXML
	private TableView<Salariee> table;
	@FXML
	private Button updateSalarieebtn;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Matricule.setCellValueFactory(new PropertyValueFactory<>("Matricule_ID"));
		NomSalarié.setCellValueFactory(new PropertyValueFactory<>("Nom"));
		Emailfield.setCellValueFactory(new PropertyValueFactory<>("Email"));
		CatFiled.setCellValueFactory(new PropertyValueFactory<>("Categorie"));
		SalaireTfield.setCellValueFactory(new PropertyValueFactory<>("Salaire"));
		AppService AppSer = new AppService();
		table.getItems().addAll(AppSer.listerSalariee());
	}
	
	  @FXML
	    void ExporterDon(ActionEvent event) throws IOException {
		 File f=new File("out.txt");
         FileWriter fw =new FileWriter(f);
		  BufferedWriter br=new BufferedWriter(fw);
		 for (Salariee S: table.getItems()) {
			 br.write(S.toString());
			 br.newLine();
		 }
		 br.close();
		  System.out.println("saved");
	    }
	@FXML
	void ajouterSalariee(ActionEvent event) throws IOException{
    	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/Dashbaord.fxml"));
        Parent tableViewParent = loader.load();
 		
        Scene tableViewScene = new Scene(tableViewParent);
        DashboardController re =loader.getController(); 
           re.LoderInAnchore("/fxml/AjoutSalariee.fxml"); 
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
	}	  
	

    @FXML
    void LoadTomodification(ActionEvent event) throws IOException {
    	Salariee sal=table.getSelectionModel().getSelectedItem();
    	String cAT = table.getSelectionModel().getSelectedItem().getCategorie();
    	int id = table.getSelectionModel().getSelectedItem().getMatricule_ID();
    	System.out.println(sal.toString());
    	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/ModifierSalariee.fxml"));
        Parent tableViewParent = loader.load();
        Scene tableViewScene = new Scene(tableViewParent);
        ModifierSalarieeController re =loader.getController(); 
        re.init(sal,cAT);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }
	@FXML
	void deleteSalariee() {
		AppService AppSer = new AppService();
		AppSer.deleteSalarie(table.getSelectionModel().getSelectedItem().getMatricule_ID());
		table.getItems().remove(table.getSelectionModel().getSelectedItem());
	}
	@FXML
	public void Paranciennte () {
		AppService AppSer = new AppService();
		table.getItems().clear();
		table.getItems().addAll(AppSer.getsalparanciente());
	}
	
	@FXML
	public void ParmaxVente () {
		AppService AppSer = new AppService();
		table.getItems().clear();
		table.getItems().add(AppSer.MaxVendeur());
	}
	
	public void SALentredeuxVal() {
	
	}



}
