package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import classes.Salariee;
import database.Connexion;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.Window;

public class AjouterSalarieeController implements Initializable {

	@FXML
	private TextField HsuppText;

	@FXML
	private Label Hsupplabel;

	@FXML
	private TextField RecrutSal;

	@FXML
	private TextField TextVente;

	@FXML
	private TextField emailSal;
	@FXML
	private TextField MatriculeT;
	@FXML
	private RadioButton employer;

	@FXML
	private TextField nomSal;

	@FXML
	private Label ph;

	@FXML
	private TextField prText;

	@FXML
	private Label prlabel;

	@FXML
	private Button submit;

	@FXML
	private TextField textPhsupp;

	@FXML
	private RadioButton vendeur;

	@FXML
	private Label venteLabel;

	private String selectedCat;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ToggleGroup tg = new ToggleGroup();
		this.employer.setToggleGroup(tg);
		this.vendeur.setToggleGroup(tg);
		tg.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

			@Override
			public void changed(ObservableValue<? extends Toggle> arg0, Toggle arg1, Toggle arg2) {
				// TODO Auto-generated method stub
				RadioButton rb = (RadioButton) tg.getSelectedToggle();

				if (rb != null) {
					String s = rb.getText();
					selectedCat = s;
					// change the label
					System.out.println(s + " selected");
					if (s.equals("employer")) {
						venteLabel.setVisible(false);
						TextVente.setVisible(false);
						prText.setVisible(false);
						prlabel.setVisible(false);

						Hsupplabel.setVisible(true);
						ph.setVisible(true);
						textPhsupp.setVisible(true);
						HsuppText.setVisible(true);

					} else {
						venteLabel.setVisible(true);
						TextVente.setVisible(true);
						prText.setVisible(true);
						prlabel.setVisible(true);

						Hsupplabel.setVisible(false);
						ph.setVisible(false);
						textPhsupp.setVisible(false);
						HsuppText.setVisible(false);

					}
				}
			}
		});
	}

	@FXML
	void addNewSalarier(ActionEvent event) throws SQLException, IOException {
		
		
		if (employer.isSelected()) {
			Salariee emp = new Salariee(Integer.parseInt(MatriculeT.getText()), nomSal.getText(), emailSal.getText(),
					Double.parseDouble(RecrutSal.getText()), 0.1, 0.1, 0.1, Double.parseDouble(HsuppText.getText()),
					Double.parseDouble(textPhsupp.getText()), "employer", 1);
			AppService AppSer = new AppService();
			boolean result = AppSer.ajouterSalariee(emp);
			if (result == true) {
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("/fxml/Dashbaord.fxml"));
				Parent tableViewParent = loader.load();
				Scene tableViewScene = new Scene(tableViewParent);
				DashboardController re = loader.getController();
				re.LoderInAnchore("/fxml/GestionSalarier.fxml");
				Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
				window.setScene(tableViewScene);
				window.show();
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("ajout");
				alert.setHeaderText(null);
				alert.setContentText("Salriée Ajouter avec success ");
				alert.show();
			}
		} else if (vendeur.isSelected()) {
			Salariee vend = new Salariee(Integer.parseInt(MatriculeT.getText()), nomSal.getText(), emailSal.getText(),
					Double.parseDouble(RecrutSal.getText()), 0.1, Double.parseDouble(TextVente.getText()),
					Double.parseDouble(prText.getText()), 0.1, 0.1, "vendeur", 1);
			AppService AppSer = new AppService();
			boolean result = AppSer.ajouterSalariee(vend);
			if (result == true) {
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("/fxml/Dashbaord.fxml"));
				Parent tableViewParent = loader.load();
				Scene tableViewScene = new Scene(tableViewParent);
				DashboardController re = loader.getController();
				re.LoderInAnchore("/fxml/GestionSalarier.fxml");
				Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
				window.setScene(tableViewScene);
				window.show();
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("ajout");
				alert.setHeaderText(null);
				alert.setContentText("Salriée Ajouter avec success");
				alert.show();
			}
		}
	}
/*public Salariee getsalariee() {
		Salariee sal = new Salariee();
		sal.setEmail(this.emailSal.getText());
		sal.setId_Entreprise(1);
		sal.setNom(this.nomSal.getText());
		sal.setRecrutement(Double.parseDouble(this.RecrutSal.getText()));
		sal.setMatricule_ID(1);
		sal.setCategorie(this.selectedCat);
		if (this.selectedCat.equals("employer")) {
			sal.setHSupp(Double.parseDouble(this.HsuppText.getText()));
			sal.setPHsupp(Double.parseDouble(this.textPhsupp.getText()));
		} else {
			sal.setPourcentage(Double.parseDouble(this.prText.getText()));
			sal.setVente(Double.parseDouble(this.TextVente.getText()));
		}
		System.out.println(sal.toString());
		return (sal);
	}*/
	
	
}
