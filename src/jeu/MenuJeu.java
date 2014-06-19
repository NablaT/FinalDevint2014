/*  Classe de menu de lancement de l'exemple de jeu.
 *  Cette classe h�rite de la classe abstraite MenuAbstrait en d�finissant les m�thodes :
 *     - nomOptions qui renvoie la liste des options possibles pour le menu 
 *     - lancerOption qui associe une action � chaque option du menu
 *     - wavAccueil() qui renvoie le nom du fichier wav lu lors de l'accueil dans le menu
 *     - wavAide() qui renvoie le nom du fichier wav lu lors de l'activation de la touche F1
 */

package jeu; 

import devintAPI.MenuAbstrait;
import testQuestion.MenuCreation;
import testQuestion.MenuThemeJeu;

public class MenuJeu extends MenuAbstrait {

	/** constructeur
	 * @param title : le nom du jeu 
	 */
	public MenuJeu(String title) {
		super(title);
	}

	/** renvoie le nom des options du menu
     * vous pouvez d�finir autant d'options que vous voulez
     **/
	protected String[] nomOptions() {
		String[] noms = {"Jouer","Options du jeu","Quitter"};
		return noms;
	}

	/** lance l'action associ�e au bouton n�i
	 * la num�rotation est celle du tableau renvoy� par nomOption
	 */
	protected void lancerOption(int i) {
		switch (i){  
		//case 0 : new IHMPrincipal(nomJeu,false,13,0);break;
        case 0 : new MenuThemeJeu("Jeu"); break;
		case 1 : new MenuCreation("Options du jeu"); break;
		case 2 : System.exit(0);
		default: System.err.println("action non d�finie");
		}
	}


	// renvoie le fichier wave contenant le message d'accueil
	// ces fichiers doivent �tre plac�s dans ressources/sons/
	
	protected  String wavAccueil() {
        this.voix.playText("Bienvenue dans le jeu Quizz 2014. Vous avez le choix : Vous pouvez jouer ou rajouter des questions dans les options du jeu"
         + "Vous pouvez jouer avec la souris ou avec F1 et les chiffres");
		return null;
		//return "../ressources/sons/accueil.wav";
	}

	// renvoie le fichier wave contenant la r�gle du jeu
	protected  String wavRegleJeu() {
        this.voix.playText("Veuillez choisir en utilisant les fléches du haut et bas. Puis appuyer sur entrée pour valider. Ou utiliser la souris");
        return null;
		//return "../ressources/sons/accueil.wav";
	}
	
}
