package testQuestion;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 	
        GestionQuestion question = new GestionQuestion();	        
        String[] tab;
        int alea = question.getRdmNumber();        
        
        Scanner sc = new Scanner(System.in);
        
        
        System.out.println(question.getQuestion());
        System.out.println("Duo Carre Hexa");
        String str = sc.nextLine();
//        while(str.equals("Duo") || str.compareTo("Carre")!=0 || str.compareTo("Hexa")!=0){
//        	str = sc.nextLine();
//        	System.out.println("Vous avez tapé :" + str);
//        	System.out.println("Duo Carre Hexa");
//        }
        
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
	
