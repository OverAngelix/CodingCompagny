package App;

public class Materiel {
	private String nom;
	private int durabilite;

	public Materiel(String nom) {
		this.nom = nom;
		this.durabilite = 100;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getDurabilite() {
		return durabilite;
	}

	public void setDurabilite(int durabilite) {
		this.durabilite = durabilite;
	}
	
	
}
