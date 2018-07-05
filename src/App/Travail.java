package App;

import javafx.application.Platform;

public class Travail implements Runnable{
	
	int i=0;
	private Entreprise entreprise;
	private Personnage perso;
	private int temps;
	private int recompense;
	
	
	public Travail(Entreprise entreprise, Personnage perso, int tempsDeBase, int recompenseDeBase) {
		this.entreprise = entreprise;
		this.perso = perso;
		this.temps = (int)(tempsDeBase*(1-perso.getVitesse()/100.0));
		//System.out.println(tempsDeBase*(1-perso.getVitesse()/100.0));
		this.recompense = recompenseDeBase;
	}
	
	public void run() {
		perso.setTravaille(true);
		while (i<temps) {
			i++;
			perso.setBarTravail(i/(double)temps);
			perso.setFatigue(perso.getFatigue()-1);
			
			Platform.runLater(() ->App.pb.setProgress(entreprise.getListePersonnel().get(App.listsalarie.getSelectionModel().getSelectedIndex()).getBarTravail()));
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		perso.setTravaille(false);
		entreprise.addArgent((perso.getQualite()/100.0+2*(perso.getFatigue()/100.0))*(double)recompense);
		Platform.runLater(() ->App.lArgent.setText(entreprise.getArgent()+"€"));
		
		Platform.runLater(() ->App.reloadSalarie());
	}

}