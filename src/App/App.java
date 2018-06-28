package App;

import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application{
	Label salarie = new Label();
	public static Label heure = new Label("");
	public static Label nomEntreprise = new Label();
	public Entreprise entreprise = new Entreprise("CODING COMPAGNY","ROBERT");
	
	public void start(Stage stage) throws Exception {
		VBox fenetre = new VBox();
		Thread time = new Thread(new dayTime());
		time.start();
		
		//LISTES DES EMPLOYES
		ListView<String> listsalarie = new ListView<String>();
		listsalarie.getItems().add("ROBERT");
		listsalarie.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		listsalarie.getSelectionModel().getSelectedItems().addListener(new descriptionEmployes());
		
		nomEntreprise.setText(entreprise.getNom());
		
		HBox persos = new HBox(listsalarie,salarie);
		fenetre.getChildren().addAll(heure,nomEntreprise,persos);
		Scene scene = new Scene(fenetre,400,400);
		stage.setScene(scene);
		stage.show();
	}


	public static void main(String[] args) {
		launch(args);
	}

	
	class descriptionEmployes implements ListChangeListener<String> {	
		public void onChanged(javafx.collections.ListChangeListener.Change<? extends String> c) {	
				salarie.setText(""+c.getList().toString()+"\nStat de C (qui est le personnages");
			}
		
	}
	
	
}
