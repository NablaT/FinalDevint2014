package testQuestion;

import jeu.ImageBackground;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * Created by user on 14/04/14.
 */
public class MenuAddQuestion extends JFrame implements ActionListener{

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
    private File path;

    public MenuAddQuestion(){
        setVisible(true);

        initialize();

        // prend toute la taille de la fen�tre
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // on ferme la fen�tre en cliquant sur la croix
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public MenuAddQuestion(File repertoryPath){
        setVisible(true);
        initialize();
        this.path= repertoryPath;
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
        this.initButton();
        this.initializeGrid(initTabString());
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
        enteteBorder = new LineBorder(Color.BLACK, 8);
        entete.setBorder(enteteBorder);

        // le label
        lb1 = new JLabel("Menu Question");
        lb1.setFont(new Font("Georgia", 1, 96));
        lb1.setForeground(Color.BLUE);
        entete.add(lb1);

        // placement de l'entete en 1�re ligne, 1�re colonne
        gc.gridx = 1;
        gc.gridy = 1;
        grid.setConstraints(entete, gc);
       add(entete);
    }

    private String[] initTabString(){
        String[] tab = {"Veuillez rentrer votre question : ","Quel est la bonne réponse à la question ? "," 1er Mauvaise réponse : ",
                " 2eme Mauvaise réponse : "," 3eme Mauvaise réponse : "," 4eme Mauvaise réponse : "," 5eme Mauvaise réponse : "};
        return tab;
    }

    private void initializeGrid(String[] question){

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(question.length,1));

        LineBorder border = new LineBorder(Color.BLACK, 8);
        tabLabel = new JLabel[question.length] ;
        tabTextField = new JTextField[question.length];

        for(int i = 0; i<question.length; i++){
            creerLabelTextField(i,question[i]);
            panel.add(tabLabel[i]);
            panel.add(tabTextField[i]);
        }

        gc.weighty=4;
        gc.gridx = 1;
        gc.gridy=2;
        grid.setConstraints(panel, gc);
        this.add(panel);
    }

    private void creerLabelTextField(int i,String texte){
        JLabel labelText = new JLabel(texte);
        Font fonte = new Font("Tahoma", 1, 30);
        labelText.setFont(fonte);
        labelText.setForeground(new Color(255, 3, 0));
        tabLabel[i]= labelText;
        JTextField jTextField = new JTextField();
        jTextField.setFont(fonte);
        jTextField.setForeground(new Color(0,0,0));
        tabTextField[i]= jTextField;

    }

    private void initButton(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,2));
        JButton buttonLeave = new JButton("Quitter");
        buttonLeave.addActionListener(this);
        JButton buttonAddQuestion = new JButton("Ajouter la question");
        buttonAddQuestion.addActionListener(this);
        panel.add(buttonLeave);
        panel.add(buttonAddQuestion);
        gc.weighty = 0.25;
        gc.gridx =1;
        gc.gridy=4;
        grid.setConstraints(panel,gc);
        this.add(panel);
    }

    public static void main(String[] args){
        MenuAddQuestion menuThemeTry = new MenuAddQuestion();
    }

    public boolean jTextIsFull(){
        for(int i=0; i<tabTextField.length; i++){
            if(tabTextField[i].getText().length()<=1){
                return false;
            }
        }
        return true;
    }

    public void clearAllJText(){
        for(int i=0; i<tabTextField.length; i++){
            tabTextField[i].setText("");
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Outils outils = new Outils();
        JButton temporaryButton = (JButton) e.getSource();
        if(temporaryButton.getText().equals("Ajouter la question") && jTextIsFull()){
            try {
                outils.creerFichierTxt(path,tabTextField[0].getText(),tabTextField[1].getText(),
                        tabTextField[2].getText(),tabTextField[3].getText(),
                        tabTextField[4].getText(),tabTextField[5].getText(),
                        tabTextField[6].getText());

                this.clearAllJText();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        if(temporaryButton.getText().equals("Quitter")){
            dispose();
        }



    }
}
