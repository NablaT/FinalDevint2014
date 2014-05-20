package testQuestion;

import devintAPI.MenuAbstrait;

import java.awt.*;

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
            new MenuThemeToDeleteTheme("Suppression d'un thème");
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

    private void customize(){
        /*
        this.buttonBorder;
        this.backgroundColor;
        this.foregroundColor;
        */
        for(int i=0;i<this.getBoutonOption().length;i++){
            if(i==this.optionCourante){
                this.getBoutonOption()[i].setBackground(new Color(255, 255, 255));
                this.getBoutonOption()[i].setForeground(new Color(255, 3,0));
            }
            else{
                this.getBoutonOption()[i].setBackground(new Color(255, 212, 189));
                this.getBoutonOption()[i].setForeground(new Color(255, 3,0));
            }
        }
    }


}
