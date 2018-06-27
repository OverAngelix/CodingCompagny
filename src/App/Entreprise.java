package App;

import java.util.ArrayList;
import java.util.Arrays;

public class Entreprise {
	private String nom;
	private int argent;
	private ArrayList<Personnage> listePersonnel;
	private ArrayList<Materiel> listeMateriel;

	public Entreprise(String nom, String nomPerso) {
		Personnage persoPrincipal = new Personnage("Jean-Charles",1,1,1);
		Materiel mOrdinateur = new Materiel("Ordinateur");
		Materiel mSouris = new Materiel("Souris");
		Materiel mClavier = new Materiel("Clavier");
		this.nom = nom;
		this.listePersonnel=new ArrayList<Personnage>(Arrays.asList(persoPrincipal));
		this.listeMateriel=new ArrayList<Materiel>(Arrays.asList(mOrdinateur,mSouris,mClavier));
		this.argent = 0;
	}
}
