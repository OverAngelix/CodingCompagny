package App;

import java.util.ArrayList;

public class Importations {
	LectureEcriture LE = new LectureEcriture();
	public ArrayList<Personnage> importationPersonnages() {
		ArrayList<Personnage> listePersos= new ArrayList<>();
		ArrayList<String> listeEmployes = LE.lecture("src/Texte/Employes.txt");
		for(int i=0;i<listeEmployes.size();i++) {
			String[] persoStats = listeEmployes.get(i).split(","); 
			listePersos.add(new Personnage (persoStats[0],Integer.parseInt(persoStats[1]),Integer.parseInt(persoStats[2]),Integer.parseInt(persoStats[3]),Double.parseDouble(persoStats[4])));
		}
		return listePersos;
	}
	
	/*public static void main(String[] args) {
		System.out.println(new Importations().importationPersonnages());
	}*/
	
}
