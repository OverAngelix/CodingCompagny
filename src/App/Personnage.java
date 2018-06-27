package App;

public class Personnage {
	private Object vitesse;
	private Object qualite;
	private Object fatigue;
	private String nom;

	public Personnage(String nom,int vitesse, int qualite, int fatigue) {
		this.nom = nom;
		this.vitesse = vitesse;
		this.qualite = qualite;
		this.fatigue = fatigue;
	}
}
