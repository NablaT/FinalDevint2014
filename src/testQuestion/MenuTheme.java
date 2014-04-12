package testQuestion;

import devintAPI.MenuAbstrait;
import jeu.Jeu;
import jeu.Option;

public class MenuTheme extends MenuAbstrait{
	
	private Theme theme;

	public MenuTheme(String title) {
		super(title);
		theme = new Theme();
		// TODO Auto-generated constructor stub
	}
	/** renvoie le nom des options du menu
	 * vous pouvez définir autant d'options que vous voulez
	 **/
	protected String[] nomOptions() {
		String[] noms = theme.getListeStringTheme();
		//String[] noms = {"Test","1", "2", "3"};
		return noms;
	}

	/** lance l'action associée au bouton n°i
	 * la numérotation est celle du tableau renvoyé par nomOption
	 */
	protected void lancerOption(int i) {
		switch (i){  
		case 0 : break;
		case 1 : break;
		case 2 : break;
		case 3 : break;
		case 4 : System.exit(0);
		default: System.err.println("action non définie");
		}
	}
	@Override
	protected String wavAccueil() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	protected String wavRegleJeu() {
		// TODO Auto-generated method stub
		return null;
	} 

}
