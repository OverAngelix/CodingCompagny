package App;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ListChangeListener;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class App extends Application{
	public static Label salarie = new Label();
	public static Label heure = new Label("");
	public static Label nomEntreprise = new Label();
	public static Label lArgent = new Label("0 €");
	public static VBox gestionPerso = new VBox();
	public static ProgressBar pb = new ProgressBar();
	public static Button bTravail = new Button("Travail !");
	public static Button bLicencie = new Button("VIRER !");
	public static Button bEmbaucher = new Button("Embaucher");
	
	public static Entreprise entreprise = new Entreprise("CODING COMPAGNY","Robert");
	public static ListView<String> listsalarie = new ListView<String>();
	
	
	public void start(Stage stage) throws Exception {
		VBox fenetre = new VBox();
		Thread time = new Thread(new dayTime());
		time.start();
		
		nomEntreprise.setTranslateY(0);
		//STYLE HEURE
		heure.setTranslateX(280);
		heure.setTranslateY(-5);
		heure.setTextFill(Color.BLACK);
		heure.setFont(Font.loadFont("file:src/Fonts/DS-DIGI.TTF",36));
		heure.setId("Heure");
		
		
		//LISTES DES EMPLOYES
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
		
		bLicencie.setOnMouseClicked(e->{
			entreprise.removeSalarie(listsalarie.getSelectionModel().getSelectedIndex());	
			listsalarie.getSelectionModel().clearSelection();
			gestionPerso.getChildren().clear();
			loadSalaries();
		});
		bEmbaucher.setOnMouseClicked(e->{
			FenEmbauche fenEmbauche = new FenEmbauche();
			Stage s = new Stage();
			try {
				fenEmbauche.start(s);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		});
		
		HBox persos = new HBox(listsalarie,gestionPerso);
		fenetre.getChildren().addAll(heure,nomEntreprise,lArgent,persos,bEmbaucher);
		
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
		    public void handle(WindowEvent t) {
		        Platform.exit();
		        System.exit(0);
		    }
		});
		
		Scene scene = new Scene(fenetre,400,400);
		scene.getStylesheets().add(getClass().getResource("/css/application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
		
		
		
	}
	
	


	public static void main(String[] args) {
		launch(args);
	}

	
	class descriptionEmployes implements ListChangeListener<String> {	
		public void onChanged(javafx.collections.ListChangeListener.Change<? extends String> c) {	
			 if(listsalarie.getSelectionModel().getSelectedIndex()!=-1) {
			reloadSalarie();
				gestionPerso.getChildren().clear();
				gestionPerso.getChildren().addAll(salarie,bTravail,pb,bLicencie);
				
			pb.setProgress(entreprise.getListePersonnel().get(listsalarie.getSelectionModel().getSelectedIndex()).getBarTravail());
		}}
		
	}
	
	 public static void loadSalaries() {

			listsalarie.getItems().clear();
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