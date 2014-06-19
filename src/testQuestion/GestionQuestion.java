package testQuestion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random; 
import java.util.Scanner;
import java.io . * ; 

public class GestionQuestion {

	//Permet de r�cup�rer la question choisi
	private int rdm= 0;
	//Permet de choisir une question al�atoirement
	private Random randomizer = new Random();

	// Contient toutes les questions du jeu
	private ArrayList<Question> listeQuestion;
    private ArrayList<File> listeFilePath;
	
	public GestionQuestion(){		
		listeQuestion=new ArrayList<Question>();
		//Initialise les questions
		listerRepertoire();
	}


    public GestionQuestion(File path) {
        listeFilePath = new ArrayList<File>();
        listeQuestion = new ArrayList<Question>();
        listerRepertoire(path);
    }


    /**
	 * Chaque fichier est lu ligne par ligne, chaque fichier correspond � une question
	 * @param filePath
	 * @throws Exception
	 */
	private void lireFichier(File filePath) throws Exception{
		Scanner scanner=new Scanner(filePath);

		Question q = new Question();
		for(int i=0;i<7 && scanner.hasNextLine();i++){
				String line = scanner.nextLine();
				q.setQuestionReponse(i, line);			
		}
		listeQuestion.add(q);
		scanner.close();
	}
	
	
	/**
	 * Lis tous les fichiers qui sont dans le dossier question
	 */
	private void listerRepertoire(){
		String path = "..\\ressources\\question";
		File repertoire= new File(path);
		File[] listeFichier;
		int i;
		
		listeFichier=repertoire.listFiles();

		for(i=0;i<listeFichier.length;i++){
				try {
                    if(listeFichier[i].isFile()){
					    lireFichier(listeFichier[i]);
                    }
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

    private void listerRepertoire(File path){
        File[] listeFichier;
        listeFichier = path.listFiles();
        for(int i =0; i<listeFichier.length;i++){
            try {
                if(listeFichier[i].isFile()){
                    listeFilePath.add(listeFichier[i].getAbsoluteFile());
                    lireFichier(listeFichier[i]);
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }


	/**
	 * Permet de r�cup�rer la liste des questions
	 * @return
	 */
	public ArrayList<Question> getListeQuestion(){
		return listeQuestion;
	}
	
	/**
	 * Recupere l'objet question
	 * @param rdm
	 * @return
	 */
	public Question getAleaObjectQuestion(int rdm){		
		return listeQuestion.get(rdm);
	}

	/**
	 * Renvoie un nombre aleatoire
	 * @return
	 */
	public int getRdmNumber(){
		rdm = randomizer.nextInt(listeQuestion.size());
		return rdm;
	}
	public int getRdm(){
		return rdm;
	}
	
	/**
	 * Renvoie une question choisi aleatoirement
	 * @return
	 */
	public String getQuestion(){
		return getAleaObjectQuestion(rdm).afficherQuestion();
	}

    public ArrayList<File> getListeFilePath(){
        return listeFilePath;
    }

}
