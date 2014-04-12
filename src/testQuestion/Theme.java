package testQuestion;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Theme {
	private ArrayList<File> listeTheme;
	private ArrayList<String> listeStringTheme;

	public Theme(){
		listeTheme =new ArrayList<File>();
		listeStringTheme = new ArrayList<String>();
		listeDossier();
		
	}
	/**
	 * Lire les dossiers
	 */
	public void listeDossier(){
		
		String path = "..\\ressources\\question";
		File repertoire= new File(path);
		File[] listeFichier;
		int i;
		int j=0;
		listeFichier=repertoire.listFiles();
		System.out.println(listeFichier.length);

		for(i=0;i<listeFichier.length;i++){
				try {
					if(listeFichier[i].isDirectory()){
						
						listeStringTheme.add(listeFichier[i].getName());
						listeTheme.add(listeFichier[i].getAbsoluteFile());
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}
	
	public void creationDossier(String name){
		String path = ".\\ressources\\question\\";
		path+= name;
		File repertoire= new File(path);
		repertoire.mkdir();
	}
	
	public void retirerDossier(File path){
		listeTheme.remove(path);
		path.delete();
	}
	
	 public ArrayList<File> getTheme() {
		return listeTheme;
	}

	public void setListeTheme(ArrayList<File> listeTheme) {
		this.listeTheme = listeTheme;
	}

	public void creerFichierTxt(File directory,String Question,String bonneReponse, String reponseFausse1
			, String reponseFausse2,String reponseFausse3, String reponseFausse4, String reponseFausse5) throws IOException{
		String path = directory.getAbsolutePath();
		path+= "\\"+bonneReponse+".txt";
		File fichier= new File(path);
		fichier.createNewFile();
		List<String> lines = new ArrayList<String>();
		lines.add(Question+"\n");
		lines.add(bonneReponse+"\n");
		lines.add(reponseFausse1+"\n");
		lines.add(reponseFausse2+"\n");
		lines.add(reponseFausse3+"\n");
		lines.add(reponseFausse4+"\n");
		lines.add(reponseFausse5+"\n");
		
		FileWriter fw = new FileWriter(fichier.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		for(int i = 0; i<lines.size();i++){
			bw.write(lines.get(i));
		}
		bw.close();	
	}
	
	public void supprimerFichierTxt(File path){
		path.delete();
	}
	public String[] getListeStringTheme() {
		return (String[]) listeStringTheme.toArray();
	}
	public void setListeStringTheme(ArrayList<String> listeStringTheme) {
		this.listeStringTheme = listeStringTheme;
	}
	
	public static void main(String args[]) throws IOException{
		
		Theme theme = new Theme();
	}
}
