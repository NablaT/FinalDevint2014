package testQuestion;

import java.util.ArrayList;

public class Question {
	
	/**
	 * 
	 */
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
		for(int i=1 ; i<3;i++){
			reponse[i-1]=questionReponse[i];
		}
		return reponse;
		
	}
	public String[] carre(){
		String[] reponse = new String[4];
		for(int i=1 ; i<5;i++){
			reponse[i-1]=questionReponse[i];
		}
		return reponse;
		
	}
	public String[] hexa(){
		String[] reponse = new String[8];
		for(int i=1 ; i<9;i++){
			reponse[i-1]=questionReponse[i];
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
