package App;

import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class App extends Application{
	public static Label salarie = new Label();
	public static Label heure = new Label("");
	public static Label nomEntreprise = new Label();
	public static Label lArgent = new Label("0 �");
	public static VBox gestionPerso = new VBox();
	public static ProgressBar pb = new ProgressBar();
	public static Button bTravail = new Button("Travail !");
	
	
	public static Entreprise entreprise = new Entreprise("CODING COMPAGNY","Robert");
	public static ListView<String> listsalarie = new ListView<String>();
	
	
	public void start(Stage stage) throws Exception {
		VBox fenetre = new VBox();
		Thread time = new Thread(new dayTime());
		time.start();
		
		nomEntreprise.setTranslateY(-50);
		//STYLE HEURE
		heure.setTranslateX(305);
		heure.setFont(Font.loadFont("file:src/Fonts/DS-DIGI.TTF",36));
		final String cssDefault = "-fx-border-color: black;\n"
                + "-fx-border-insets: 5;\n"
                + "-fx-border-width: 3;\n";
		heure.setStyle(cssDefault);
		
		//LISTES DES EMPLOYES
		entreprise.addSalarie("Florent" ,50, 70, 0);
		entreprise.addSalarie("Steven" ,60, 60, 0);
		loadSalaries();
		listsalarie.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		listsalarie.getSelectionModel().getSelectedItems().addListener(new descriptionEmployes());
		
		nomEntreprise.setText(entreprise.getNom());
		
		
		bTravail.setOnMouseClicked(e ->{
			if (!entreprise.getListePersonnel().get(App.listsalarie.getSelectionModel().getSelectedIndex()).isTravaille()) {
			new Thread(new Travail(entreprise,entreprise.getListePersonnel().get(listsalarie.getSelectionModel().getSelectedIndex()),5,100)).start();
			}
			else {System.out.println("Attendez que "+entreprise.getListePersonnel().get(App.listsalarie.getSelectionModel().getSelectedIndex()).getNom()+" termine son travail en cours.");}
		});
		
		
		
		HBox persos = new HBox(listsalarie,gestionPerso);
		fenetre.getChildren().addAll(heure,nomEntreprise,lArgent,persos);
		Scene scene = new Scene(fenetre,400,400);
		stage.setScene(scene);
		stage.show();
	}


	public static void main(String[] args) {
		launch(args);
	}

	
	class descriptionEmployes implements ListChangeListener<String> {	
		public void onChanged(javafx.collections.ListChangeListener.Change<? extends String> c) {	
				reloadSalarie();
				gestionPerso.getChildren().clear();
				gestionPerso.getChildren().addAll(salarie,bTravail,pb);
				pb.setProgress(entreprise.getListePersonnel().get(listsalarie.getSelectionModel().getSelectedIndex()).getBarTravail());
		}
		
	}
	
	 public void loadSalaries() {
		 for(int i = 0 ; i <entreprise.getListePersonnel().size(); i++) {
			 listsalarie.getItems().add(entreprise.getListePersonnel().get(i).getNom());
		 }
	 }
	 
	 //METHODE RECHARGEANT LES STATS DU PERSONNAGE
	 public static void reloadSalarie() {
		 App.salarie.setText(""+entreprise.getListePersonnel().get(App.listsalarie.getSelectionModel().getSelectedIndex()).getNom()+"\n Qualite : "+entreprise.getListePersonnel().get(App.listsalarie.getSelectionModel().getSelectedIndex()).getQualite()
					+"\n Vitesse: "+entreprise.getListePersonnel().get(App.listsalarie.getSelectionModel().getSelectedIndex()).getVitesse()
					+"\n Fatigue : "+entreprise.getListePersonnel().get(App.listsalarie.getSelectionModel().getSelectedIndex()).getFatigue());
	 }
	
}