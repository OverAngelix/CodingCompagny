package App;

import java.util.ArrayList;
import java.util.Arrays;

public class Entreprise {
	private String nom;
	private double argent;
	private ArrayList<Personnage> listePersonnel;
	private ArrayList<Materiel> listeMateriel;

	public Entreprise(String nom, String nomPerso) {
		Personnage persoPrincipal = new Personnage(nomPerso,10,10,100,0);
		Materiel mOrdinateur = new Materiel("Ordinateur");
		Materiel mSouris = new Materiel("Souris");
		Materiel mClavier = new Materiel("Clavier");
		this.nom = nom;
		this.listePersonnel=new ArrayList<Personnage>(Arrays.asList(persoPrincipal));
		this.listeMateriel=new ArrayList<Materiel>(Arrays.asList(mOrdinateur,mSouris,mClavier));
		this.argent = 0;
	}

	public void addSalarie(String nomPerso , int qualite, int vitesse,double salaire) {
		Personnage newPerso = new Personnage(nomPerso,qualite,vitesse,100,salaire);
		listePersonnel.add(newPerso);
		
	}
	
	public void removeSalarie(int classement) {
	
		listePersonnel.remove(classement);
	}
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getArgent() {
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
	
	public void addArgent(double d) {
		argent+=d;
	}

	public void supSalaires() {
		ArrayList<Personnage> personnel = this.getListePersonnel();
		for(int i=0;i<personnel.size();i++) {
			this.addArgent(-personnel.get(i).getSalaire());
		}
	}
	
}