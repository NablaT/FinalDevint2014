package testQuestion;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Created by user on 22/04/14.
 */
public class DeleteQuestion extends JFrame{

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
    private JButton buttonQuitter;
    private JButton buttonAjouterTheme;
    private JTextField jTextField;
    private Outils outils;
    
    public DeleteQuestion(){
        setVisible(true);
        //initCursor();

        initialize();

        // prend toute la taille de la fen�tre
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // on ferme la fen�tre en cliquant sur la croix
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void initialize() {
        this.grid = new GridBagLayout();
        this.gc = new GridBagConstraints();
        this.initLayout();
        this.initEntete();
        this.initializeGrid();
    }

    private void initializeGrid() {
        JPanel panel = new JPanel();

        JScrollPane scrollpane = new JScrollPane(panel);
        //scrollpane.createVerticalScrollBar();
        scrollpane.createHorizontalScrollBar();
        for(int i=0; i<100 ; i++){
            panel.add(new JButton(""+i));
        }
        // poids relatif de 3 (i.e 3 fois plus grand que l'ent�te)
        gc.weighty = 4;
        // placement des boutons en 2�me ligne, 1�re colonne
        gc.gridx = 1;
        gc.gridy = 2;
        grid.setConstraints(scrollpane, gc);
        this.add(scrollpane);

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

    public static void main(String[] args) {
        DeleteQuestion deleteQuestion = new DeleteQuestion();
    }
}
