package testQuestion;

import devintAPI.MenuAbstrait;

public class MenuCreation extends MenuAbstrait{

	public MenuCreation(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}
	/** renvoie le nom des options du menu
	 * vous pouvez d�finir autant d'options que vous voulez
	 **/
	protected String[] nomOptions() {
		String[] noms = {"Jouer","Ajouter un nouveau thème","Ajouter une question","Supprimer un thème","Supprimer une question","Quitter"};
		return noms;
	}

	/** lance l'action associ�e au bouton n�i
	 * la num�rotation est celle du tableau renvoy� par nomOption
	 */
	protected void lancerOption(int i) {
		switch (i){  
		    case 0 : new MenuThemeJeu(nomJeu);break;
		    case 1 : new MenuAddTheme();break;
		    case 2 : new MenuThemeForQuestion("Création de la question");break;
            case 3 : new MenuThemeToDeleteTheme("Supression d'un thème");break;
            case 4 : new MenuThemeToDeleteQuestion("Supression de la question");break;
		    case 5 : System.exit(0);
		default: System.err.println("action non d�finie");
		}
	} 

	// renvoie le fichier wave contenant le message d'accueil
	// ces fichiers doivent �tre plac�s dans ressources/sons/
	protected  String wavAccueil() {
		return "../ressources/sons/accueil.wav";
	}

	// renvoie le fichier wave contenant la r�gle du jeu
	protected  String wavRegleJeu() {
		return "../ressources/sons/accueil.wav";
	}

}

