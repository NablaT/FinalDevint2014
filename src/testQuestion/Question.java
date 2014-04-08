package testQuestion;

import java.util.ArrayList;
import java.util.Random;

public class Question {
	
	/**
	 * 
	 */

    private Random randomizer = new Random();
	private String[] questionReponse;
	/**
	 * L'objet question est constitu� d'un tableau de 9 String.
	 * La premiere ligne correspond � la question
	 * La deuxieme ligne correspond � la bonne r�ponse
	 * Le reste sont des questions al�atoires.
	 */
	public Question(){
		questionReponse = new String[9];
	}
	/**
	 * La bonne r�ponse doit se situe en deuxieme ligne dans une fichier .txt
	 * @return
	 */
	public String afficherBonneReponse(){
		return questionReponse[1];
	}
	
	/**
	 * Return true si c'est la bonne r�ponse
	 * @param reponse
	 * @return
	 */
	public boolean bonneReponse(String reponse){
		if(reponse.compareTo(questionReponse[1])==0){
			return true;
		}
		return false;
	}
	

	
	/**
	 * la question se trouve � la premiere ligne du fichier .txt
	 * @return
	 */
	public String afficherQuestion(){
		return questionReponse[0];
	}
	
	/**
	 * Permet de r�cup�rer la question et les r�ponses
	 * @return
	 */
	public String[] getQuestionReponse(){
		return questionReponse;
	}
	
	public String[] duo(){
		String[] reponse = new String[2];
        int alea = randomizer.nextInt(2)+1;
            if(alea==1){
			    reponse[0]=questionReponse[alea];
                reponse[1]=questionReponse[alea+1];
            }else{
                reponse[0]=questionReponse[alea];
                reponse[1]=questionReponse[alea-1];
            }
		return reponse;
		
	}
	public String[] carre(){
		String[] reponse = new String[4];
        int ref = 2;
        int alea = randomizer.nextInt(4);
        reponse[alea]= questionReponse[ref-1];
		for(int i=0; i<reponse.length;i++,ref++){
            if(i!=alea){
                reponse[i]= questionReponse[ref];
            }
            else{
                ref--;
            }

		}
        return reponse;
		
	}
	public String[] hexa(){
		String[] reponse = new String[6];
        int ref = 2;
        int alea = randomizer.nextInt(6);
        reponse[alea]= questionReponse[ref-1];
        for(int i=0; i<reponse.length;i++,ref++){
            if(i!=alea){
                reponse[i]= questionReponse[ref];
            }
            else{
                ref--;
            }
        }
		return reponse;
		
	}
	/**
	 * Permet de rentrer les valeurs dans le tableau de String
	 * @param i
	 * @param s
	 */
	public void setQuestionReponse(int i, String s){
		questionReponse[i]=s;
	}
}
