package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
Parent root;
	
	@Override
	 public void start(Stage primaryStage) throws Exception{
	//root =FXMLLoader.load(getClass().getResource("/fxml/AjoutSalariee.fxml"));
	//root =FXMLLoader.load(getClass().getResource("/fxml/ListerSalariee.fxml"));		
    //root =FXMLLoader.load(getClass().getResource("/fxml/GestionSalarier.fxml"));
     root =FXMLLoader.load(getClass().getResource("/fxml/Dashbaord.fxml"));	
	 primaryStage.setTitle("hello");
	 primaryStage.setScene(new Scene(root));
	 primaryStage.show();
	 }
	 public static void main(String[] args) {
	 launch(args);
	 }
}