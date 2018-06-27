package App;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application{


	public void start(Stage stage) throws Exception {
		VBox fenetre = new VBox();
		
		Entreprise entreprise = new Entreprise();
		
		Scene scene = new Scene(fenetre,400,400);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
