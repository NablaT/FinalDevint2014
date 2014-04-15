package testQuestion;

import jeu.ImageBackground;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Created by user on 15/04/14.
 */
public class MenuAddTheme extends JFrame{

    private ImageBackground background;
    // �l�ments de placement des composants
    private GridBagLayout grid;
    private GridBagConstraints gc;
    private JButton[] boutonOption;
    private int nbOption;

    // �l�ments graphiques
    protected JPanel entete;
    protected JLabel lb1;
    protected LineBorder buttonBorder;
    protected LineBorder enteteBorder;
    private JLabel[] tabLabel;
    private JTextField[] tabTextField;

    public MenuAddTheme(){
        setVisible(true);

        initialize();

        // prend toute la taille de la fen�tre
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // on ferme la fen�tre en cliquant sur la croix
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }


    private void initialize(){

        this.grid = new GridBagLayout();
        this.gc = new GridBagConstraints();
        this.initLayout();
        this.initEntete();
        this.initializeGrid();
    }

    private void initLayout() {

        setLayout(grid);
        // par d�faut on �tire les composants horizontalement et verticalement
        gc.fill = GridBagConstraints.BOTH;
        // par d�faut, tous les composants ont un poids de 1
        // on les r�partit donc �quitablement sur la grille
        gc.weightx = 1;
        gc.weighty = 1;
        // espaces au bord des composants
        gc.insets = new Insets(10, 50, 10, 50);
        // pour placer en haut des zones
        gc.anchor = GridBagConstraints.NORTH;
    }

    public void initEntete() {

        // panel d'entete de la fen�tre
        entete = new JPanel();
        FlowLayout enteteLayout = new FlowLayout();
        enteteLayout.setAlignment(FlowLayout.CENTER);
        entete.setLayout(enteteLayout);
        enteteBorder = new LineBorder(Color.BLUE, 8);
        entete.setBorder(enteteBorder);

        // le label
        lb1 = new JLabel("Nouveau thème");
        lb1.setFont(new Font("Georgia", 1, 96));
        entete.add(lb1);

        // placement de l'entete en 1�re ligne, 1�re colonne
        gc.gridx = 1;
        gc.gridy = 1;
        grid.setConstraints(entete, gc);
        add(entete);
    }


    private void initializeGrid(){

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,1));
        Font fonte = new Font("Tahoma", 1, 56);
        LineBorder border = new LineBorder(Color.BLACK, 8);
        JLabel label = new JLabel("Quel thème souhaitez-vous rajouter ?");
        JTextField textField = new JTextField();
        JButton buttonAjouterTheme = new JButton("Ajouter le thèmes");
        JButton buttonQuitter = new JButton("Quitter");

        panel.add(label);
        panel.add(textField);
        panel.add(buttonAjouterTheme);
        panel.add(buttonQuitter);
        gc.weighty=4;
        gc.gridx = 1;
        gc.gridy=2;
        grid.setConstraints(panel, gc);
        this.add(panel);
    }


    public static void main(String[] args){
        MenuAddTheme menuAddTheme = new MenuAddTheme();
    }
}
