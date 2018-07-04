package App;

public class Personnage {
	private int vitesse;
	private int qualite;
	private int fatigue;
	private String nom;
	private double barTravail;
	private boolean travaille;
	private double salaire;

	public Personnage(String nom,int vitesse, int qualite, int fatigue,double salaire) {
		this.nom = nom;
		this.vitesse = vitesse;
		this.qualite = qualite;
		this.fatigue = fatigue;
		this.barTravail = 0;
		this.travaille = false;
		this.salaire = salaire;
	}

	public boolean isTravaille() {
		return travaille;
	}

	public double getSalaire() {
		return salaire;
	}

	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}

	public void setTravaille(boolean travaille) {
		this.travaille = travaille;
	}

	public double getBarTravail() {
		return barTravail;
	}

	public void setBarTravail(double barTravail) {
		this.barTravail = barTravail;
	}

	public int getVitesse() {
		return vitesse;
	}

	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}

	public int getQualite() {
		return qualite;
	}

	public void setQualite(int qualite) {
		this.qualite = qualite;
	}

	public int getFatigue() {
		return fatigue;
	}

	public void setFatigue(int fatigue) {
		this.fatigue = fatigue;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
}