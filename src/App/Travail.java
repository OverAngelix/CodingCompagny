package App;

import javafx.application.Platform;

public class Travail implements Runnable{
	
	int i=0;
	private Entreprise entreprise;
	private Personnage perso;
	private int temps;
	private int recompense;
	
	
	public Travail(Entreprise entreprise, Personnage perso, int temps, int recompense) {
		this.entreprise = entreprise;
		this.perso = perso;
		this.temps = temps;
		this.recompense = recompense;
	}
	
	public void run() {
		while (i<temps) {
			i++;
			perso.setBarTravail(i/(double)temps);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		entreprise.addArgent((perso.getQualite()/100+2*(perso.getFatigue()/100))*recompense);
		Platform.runLater(() ->App.lArgent.setText(entreprise.getArgent()+"€"));
		
	}

}