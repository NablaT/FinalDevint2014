package testQuestion;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Outils {
	private ArrayList<File> listeTheme;
	private ArrayList<String> listeStringTheme;

	public Outils(){
		this.listeTheme =new ArrayList<File>();
		this.listeStringTheme = new ArrayList<String>();
		listeDossier();
	}
	/**
	 * Lire les dossiers
	 */
	public void listeDossier(){
        //System.out.println(System.getProperty("user.dir"));
		String path = "..\\ressources\\question";
		File repertoire= new File(path);
		File[] listeFichier;
		int i;
		int j=0;
		listeFichier=repertoire.listFiles();
		for(i=0;i<listeFichier.length;i++){
				try {
					if(listeFichier[i].isDirectory()){
						System.out.println(listeFichier[i].getName());
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
		String path = "..\\ressources\\question\\";
		path+= name;
		File repertoire= new File(path);
		repertoire.mkdir();
	}
	
	public void retirerDossier(File path){
        GestionQuestion gestionQuestion = new GestionQuestion(path);
        for(int i=0;i<gestionQuestion.getListeFilePath().size();i++){
            supprimerFichierTxt(gestionQuestion.getListeFilePath().get(i));
        }
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
		lines.add(Question+System.getProperty("line.separator"));

		lines.add(bonneReponse+System.getProperty("line.separator"));
		lines.add(reponseFausse1+System.getProperty("line.separator"));
		lines.add(reponseFausse2+System.getProperty("line.separator"));
		lines.add(reponseFausse3+System.getProperty("line.separator"));
		lines.add(reponseFausse4+System.getProperty("line.separator"));
		lines.add(reponseFausse5+System.getProperty("line.separator"));
		
		FileWriter fw = new FileWriter(fichier.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		for(int i = 0; i<lines.size();i++){
			bw.write(lines.get(i));
		}
		bw.close();	
	}

	public static void supprimerFichierTxt(File path){
		path.delete();
	}
	public ArrayList<String> getListeStringTheme() {
		return listeStringTheme;
	}

    public String[] getTabTheme(){
        String[] tab = new String[this.getListeStringTheme().size()];
        for(int i=0; i<getListeStringTheme().size();i++){
            tab[i]=getListeStringTheme().get(i);
        }
        return  tab;
    }
	public void setListeStringTheme(ArrayList<String> listeStringTheme) {
		this.listeStringTheme = listeStringTheme;
	}
	
	public static void main(String args[]) throws IOException{
		
		Outils outils = new Outils();
        File file;
        file = new File("ressources\\question");
        for(int i =0; i< outils.getListeStringTheme().size(); i++){
            System.out.println(outils.getListeStringTheme().get(i));
        }


    }
}
