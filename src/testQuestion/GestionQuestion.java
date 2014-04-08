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
	
	public GestionQuestion(){		
		listeQuestion=new ArrayList<Question>();
		//Initialise les questions
		listerRepertoire();
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
		String path = "ressources\\question";
		File repertoire= new File(path);
		File[] listeFichier;
        System.out.println(repertoire.getAbsolutePath());
		int i;
		
		listeFichier=repertoire.listFiles();

		for(i=0;i<listeFichier.length;i++){
				try {
					lireFichier(listeFichier[i]);
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
	 * Revnoie un nombre aleatoire
	 * @return
	 */
	public int getRdmNumber(){
		rdm = randomizer.nextInt(listeQuestion.size());
        System.out.println(" LE RDM "+rdm);
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

	 public static void main(String args[]){
	        GestionQuestion question = new GestionQuestion();	        
	        String[] tab;
	        int alea = question.getRdmNumber();
	        
	        
	        Scanner sc = new Scanner(System.in);
	        
	        
	        System.out.println(question.getQuestion());
	        System.out.println("Duo Carre Hexa");
	        String str = sc.nextLine();
	        
	        if(str.compareTo("Duo")==0){
	        	System.out.println(question.getQuestion());
	        	tab=question.getAleaObjectQuestion(alea).duo();
	        	
	        }else if(str.compareTo("Carre")==0){
	        	System.out.println(question.getQuestion());
	        	tab=question.getAleaObjectQuestion(alea).carre();
	        }else{
	        	System.out.println(question.getQuestion());
	        	tab=question.getAleaObjectQuestion(alea).hexa();
	        }
	        for(int i=0; i<tab.length;i++){
	        	System.out.println(tab[i]);
	        }
	        int nb = sc.nextInt();
	        String[] tabReponse;
	        tabReponse = question.getAleaObjectQuestion(alea).getQuestionReponse();
	        
	        if(question.getAleaObjectQuestion(alea).bonneReponse(tabReponse[nb])){
	        	System.out.println("Bravo !");
	        }
	        else{
	        	System.out.println("Faux !");
	        }

	 }
}
