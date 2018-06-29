package App;

public class Personnage {
	private int vitesse;
	private int qualite;
	private int fatigue;
	private String nom;
	private double barTravail;

	public Personnage(String nom,int vitesse, int qualite, int fatigue) {
		this.nom = nom;
		this.vitesse = vitesse;
		this.qualite = qualite;
		this.fatigue = fatigue;
		this.barTravail = 0;
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
	
	public void setBarTravail(double d) {
		this.barTravail=d;
	}
	
	public double getBarTravail() {
		return barTravail;
	}
	
}
