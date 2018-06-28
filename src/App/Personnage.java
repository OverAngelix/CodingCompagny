package App;

public class Personnage {
	private int vitesse;
	private int qualite;
	private int fatigue;
	private String nom;

	public Personnage(String nom,int vitesse, int qualite, int fatigue) {
		this.nom = nom;
		this.vitesse = vitesse;
		this.qualite = qualite;
		this.fatigue = fatigue;
	}

	public Object getVitesse() {
		return vitesse;
	}

	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}

	public Object getQualite() {
		return this.qualite;
	}

	public void setQualite(int qualite) {
		this.qualite = qualite;
	}

	public Object getFatigue() {
		return this.fatigue;
	}

	public void setFatigue(int fatigue) {
		this.fatigue = fatigue;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
}
