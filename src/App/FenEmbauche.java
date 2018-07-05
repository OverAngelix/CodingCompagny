package App;

import java.util.ArrayList;

import App.App.descriptionEmployes;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ListChangeListener;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class FenEmbauche extends Application{
	
	static ListView<String> listeViewPersos = new ListView<String>();
	static Label lStats = new Label();
	static ArrayList<Personnage> listePersos;
	static Button bEmbaucher = new Button("Embaucher");
	
	
	
	@Override
	public void start(Stage stage) throws Exception {
		HBox root = new HBox();
		
		
		
		listeViewPersos.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		listeViewPersos.getSelectionModel().getSelectedItems().addListener(new descriptionEmployesFen());
		
		root.getChildren().addAll(listeViewPersos,lStats,bEmbaucher);
		
		listePersos = new Importations().importationPersonnages();
		
		listeViewPersos.getItems().clear();
		 for(int i = 0 ; i <listePersos.size(); i++) {
			 
			 listeViewPersos.getItems().add(listePersos.get(i).getNom());
		 }
		 
		 bEmbaucher.setOnMouseClicked(e->{
				App.entreprise.addSalarie(listePersos.get((listeViewPersos.getSelectionModel().getSelectedIndex())));	
				listePersos.remove(listePersos.indexOf(listePersos.get((listeViewPersos.getSelectionModel().getSelectedIndex()))));
				listeViewPersos.getSelectionModel().clearSelection();
				listeViewPersos.getItems().clear();
				for(int i = 0 ; i <listePersos.size(); i++) {
					 
					 listeViewPersos.getItems().add(listePersos.get(i).getNom());
				 }
				//System.out.println(App.entreprise.getListePersonnel());
			});
		 
		 stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			    public void handle(WindowEvent t) {
			        App.loadSalaries();
			    }
			});
		 		
		
		Scene scene = new Scene(root,400,400);
		stage.setScene(scene);
		stage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	class descriptionEmployesFen implements ListChangeListener<String> {	
		public void onChanged(javafx.collections.ListChangeListener.Change<? extends String> c) {	
			 if(listeViewPersos.getSelectionModel().getSelectedIndex()!=-1) {
				 afficherStats();
				 
		}}
		
		private void afficherStats() {
			lStats.setText(""+listePersos.get(listeViewPersos.getSelectionModel().getSelectedIndex()).getNom()+"\n Qualite : "+listePersos.get(listeViewPersos.getSelectionModel().getSelectedIndex()).getQualite()
					+"\n Vitesse: "+listePersos.get(listeViewPersos.getSelectionModel().getSelectedIndex()).getVitesse()
					+"\n Fatigue : "+listePersos.get(listeViewPersos.getSelectionModel().getSelectedIndex()).getFatigue()
					+"\n Salaire : "+listePersos.get(listeViewPersos.getSelectionModel().getSelectedIndex()).getSalaire());
		
 }}
	
	
}
