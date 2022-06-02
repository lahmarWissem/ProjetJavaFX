package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import classes.Salariee;
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

public class ModifierSalarieeController implements Initializable {

	@FXML
	private TextField HsuppText;

	@FXML
	private Label Hsupplabel;

	@FXML
	private TextField MatriculeT;

	@FXML
	private TextField RecrutSal;

	@FXML
	private TextField TextVente;

	@FXML
	private TextField emailSal;

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
	private String selectedCat;
	@FXML
	private Label venteLabel;

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
	void EditSalariee(ActionEvent event) throws SQLException, IOException {
		if (employer.isSelected()) {
			Salariee emp = new Salariee(Integer.parseInt(MatriculeT.getText()), nomSal.getText(), emailSal.getText(),
					Double.parseDouble(RecrutSal.getText()), 0.1, 0.1, 0.1, Double.parseDouble(HsuppText.getText()),
					Double.parseDouble(textPhsupp.getText()), "employer", 1);
			AppService AppSer = new AppService();
			boolean result = AppSer.Updatesalariee(emp);
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
				alert.setTitle("Modification");
				alert.setHeaderText(null);
				alert.setContentText("Salriée Modifier avec success ");
				alert.show();
			}
		} else if (vendeur.isSelected()) {
			Salariee emp = new Salariee(Integer.parseInt(MatriculeT.getText()), nomSal.getText(), emailSal.getText(),
					Double.parseDouble(RecrutSal.getText()), 0.1, Double.parseDouble(TextVente.getText()),
					Double.parseDouble(prText.getText()), 0.1, 0.1, "vendeur", 1);
			AppService AppSer = new AppService();
			boolean result = AppSer.Updatesalariee(emp);
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
				alert.setTitle("Modification");
				alert.setHeaderText(null);
				alert.setContentText("Salriée Modifier avec success");
				alert.show();
			}

		}
	}
	
	public void init(Salariee s, String cAT) {
		MatriculeT.setText(Integer.toString( s.getMatricule_ID()));
		nomSal.setText(s.getNom());
		emailSal.setText(s.getEmail());
		RecrutSal.setText(Double.toString(s.getRecrutement()));
		if(cAT.equals("vendeur")) {
			TextVente.setText(Double.toString(s.getVente()));
			prText.setText(Double.toString(s.getPourcentage()));
			vendeur.setSelected(true);
		}else {
			HsuppText.setText(Double.toString(s.getHSupp()));
			textPhsupp.setText(Double.toString(s.getPHsupp()));
			employer.setSelected(true);
		}
	}

	
	
}
