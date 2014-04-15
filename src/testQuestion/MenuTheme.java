package testQuestion;

import devintAPI.MenuAbstrait;
import jeu.Jeu;
import jeu.Option;

public class MenuTheme extends MenuAbstrait{
	
	private Theme theme;
    private String[] noms;


    public MenuTheme(String title) {
		super(title);

		// TODO Auto-generated constructor stub
	}
	/** renvoie le nom des options du menu
	 * vous pouvez d�finir autant d'options que vous voulez
	 **/
	protected String[] nomOptions() {
		//String[] noms = theme.getListeStringTheme();
        this.theme = new Theme();
		noms = theme.getTabTheme();
		return noms;
	}

	/** lance l'action associ�e au bouton n�i
	 * la num�rotation est celle du tableau renvoy� par nomOption
	 */
	protected void lancerOption(int i) {

        if(i<noms.length){
            new MenuAddQuestion(theme.getTheme().get(i));
        }
		else{
            System.exit(0);
        }
        System.err.println("action non d�finie");

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
