package testQuestion;

import devintAPI.MenuAbstrait;

public class MenuThemeToDeleteTheme extends MenuAbstrait{

    private Outils outils;
    private String[] noms;


    public MenuThemeToDeleteTheme(String title) {
        super(title);

        // TODO Auto-generated constructor stub
    }
    /** renvoie le nom des options du menu
     * vous pouvez d�finir autant d'options que vous voulez
     **/
    protected String[] nomOptions() {
        //String[] noms = outils.getListeStringTheme();
        this.outils = new Outils();
        noms = outils.getTabTheme();
        return noms;
    }

    /** lance l'action associ�e au bouton n�i
     * la num�rotation est celle du tableau renvoy� par nomOption
     */
    protected void lancerOption(int i) {

        if(i<noms.length){
            outils.retirerDossier(outils.getTheme().get(i));
            dispose();
            new MenuThemeToDeleteTheme("Supression d'un thème");
        }
        else{
            System.exit(0);
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
