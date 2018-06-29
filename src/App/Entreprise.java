package App;

import java.util.ArrayList;
import java.util.Arrays;

public class Entreprise {
	private String nom;
	private int argent;
	private ArrayList<Personnage> listePersonnel;
	private ArrayList<Materiel> listeMateriel;

	public Entreprise(String nom, String nomPerso) {
		Personnage persoPrincipal = new Personnage(nomPerso,100,100,100);
		Materiel mOrdinateur = new Materiel("Ordinateur");
		Materiel mSouris = new Materiel("Souris");
		Materiel mClavier = new Materiel("Clavier");
		this.nom = nom;
		this.listePersonnel=new ArrayList<Personnage>(Arrays.asList(persoPrincipal));
		this.listeMateriel=new ArrayList<Materiel>(Arrays.asList(mOrdinateur,mSouris,mClavier));
		this.argent = 0;
	}

	public void addSalarie(String nomPerso , int qualite, int vitesse) {
		Personnage newPerso = new Personnage(nomPerso,qualite,vitesse,100);
		listePersonnel.add(newPerso);
		
	}
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getArgent() {
		return argent;
	}

	public void setArgent(int argent) {
		this.argent = argent;
	}

	public ArrayList<Personnage> getListePersonnel() {
		return listePersonnel;
	}

	public void setListePersonnel(ArrayList<Personnage> listePersonnel) {
		this.listePersonnel = listePersonnel;
	}

	public ArrayList<Materiel> getListeMateriel() {
		return listeMateriel;
	}

	public void setListeMateriel(ArrayList<Materiel> listeMateriel) {
		this.listeMateriel = listeMateriel;
	}
	
	public void addArgent(int i) {
		argent+=i;
	}
	
}