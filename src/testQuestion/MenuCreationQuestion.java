package testQuestion;

import jeu.Fichier;
import jeu.Jeu;
import jeu.Option;
import jeu.UneImage;
import devintAPI.FenetreAbstraite;
import devintAPI.MenuAbstrait;

public class MenuCreationQuestion extends MenuAbstrait{

	public MenuCreationQuestion(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}
	/** renvoie le nom des options du menu
	 * vous pouvez définir autant d'options que vous voulez
	 **/
	protected String[] nomOptions() {
		String[] noms = {"Jouer","Options","Ajouter une question","Quitter"};
		return noms;
	}

	/** lance l'action associée au bouton n°i
	 * la numérotation est celle du tableau renvoyé par nomOption
	 */
	protected void lancerOption(int i) {
		switch (i){  
		case 0 : new Jeu(nomJeu);break;
		case 1 : new Option(nomJeu + ": gestion des options");break;
		case 2 : new MenuTheme("Question !");break;
		case 3 : System.exit(0);
		default: System.err.println("action non définie");
		}
	} 

	// renvoie le fichier wave contenant le message d'accueil
	// ces fichiers doivent être placés dans ressources/sons/
	protected  String wavAccueil() {
		return "../ressources/sons/accueil.wav";
	}

	// renvoie le fichier wave contenant la règle du jeu
	protected  String wavRegleJeu() {
		return "../ressources/sons/accueil.wav";
	}

}

