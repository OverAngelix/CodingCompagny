package App;

import java.io.*;

import javax.swing.JOptionPane;

public class LectureEcriture {
	public void lecture(String textFile) {
		String t = textFile;
		try
		{
			File f = new File (t);
			FileReader fr = new FileReader (f);
			BufferedReader br = new BufferedReader (fr);
	 
			try{
				String line = br.readLine();
	 
				while (line != null){
					System.out.println (line);
					line = br.readLine();
				}
	 
				br.close();
				fr.close();
			}
			catch (IOException exception) {
				System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
			}
		}
		catch (FileNotFoundException exception){
			System.out.println ("Le fichier n'a pas �t� trouv�");
		}
	}
	
	public void ecriture(String textFile) {
		String t = textFile;
		try{
			File fichier=new File(t);
			fichier.createNewFile();
			
			FileWriter fichierecrit=new FileWriter(fichier,true);
			
			
		    String nom = JOptionPane.showInputDialog(null, "Nom de l'employ�");
		    String qualite = JOptionPane.showInputDialog(null, "Qualite de travail");
		    String vitesse = JOptionPane.showInputDialog(null, "Vitesse d'execution");
		    String fatigue = JOptionPane.showInputDialog(null, "Niveau de fatique");
		    
			fichierecrit.write(nom +" "+qualite+" "+vitesse+" "+fatigue+"\n"); 
			
			fichierecrit.close(); 
			} catch (Exception e) {}
	}
	
	
	public static void main(String[] args) {
		new LectureEcriture().lecture("src/Texte/Employes.txt");
		
		//new LectureEcriture().ecriture("src/Texte/Employes.txt");
		
		//new LectureEcriture().lecture("src/Texte/Employes.txt");
	}
	
}
