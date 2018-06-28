package App;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application{

	public static Label heure = new Label("");
	public static Label nomEntreprise = new Label();
	public static Label salarie1 = new Label();
	
	
	public void start(Stage stage) throws Exception {
		VBox fenetre = new VBox();
		Thread time = new Thread(new dayTime());
		time.start();
		
		Entreprise entreprise = new Entreprise("CODING COMPAGNY","ROBERT");
		nomEntreprise.setText(entreprise.getNom());
		fenetre.getChildren().add(heure);
		Scene scene = new Scene(fenetre,400,400);
		stage.setScene(scene);
		stage.show();
	}


	public static void main(String[] args) {
		launch(args);
	}

}
