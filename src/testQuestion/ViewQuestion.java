package testQuestion;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by user on 22/04/14.
 */
public class ViewQuestion extends JFrame implements ActionListener {

    private String title;
    private Question question;
    private GridBagLayout grid;
    private GridBagConstraints gc;
    private String[] questionTab;
    private JLabel[] labelTab;
    private JPanel panel;
    private GestionQuestion gestionQuestion;
    private int nbQuestion;

    public ViewQuestion(){
        this.setVisible(true);
        this.initialize();
        // prend toute la taille de la fen�tre
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // on ferme la fen�tre en cliquant sur la croix
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public ViewQuestion(File path){
        this.nbQuestion=0;
        this.gestionQuestion= new GestionQuestion(path);
        this.setVisible(true);
        this.question=gestionQuestion.getListeQuestion().get(nbQuestion);
        this.questionTab = question.getQuestionReponse();
        this.initialize();
        // prend toute la taille de la fen�tre
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        // on ferme la fen�tre en cliquant sur la croix
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public ViewQuestion(Question question){
        this.setVisible(true);
        this.question=question;
        this.questionTab = question.getQuestionReponse();
        this.initialize();
        // prend toute la taille de la fen�tre
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        // on ferme la fen�tre en cliquant sur la croix
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public ViewQuestion(Question question, String title){
        this.setVisible(true);
        this.question=question;
        this.title = title;
        this.initialize();
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
        this.initButton();
    }

    private void initializeGrid() {
        panel = new JPanel();
        int sizeTab = 10;
        panel.setLayout(new GridLayout(5,2));
        labelTab = new JLabel[sizeTab];

        initConsigne();
        initQuestion();
        for(int i = 0; i<sizeTab;i++){
            panel.add(labelTab[i]);
        }
        // poids relatif de 3 (i.e 3 fois plus grand que l'ent�te)
        gc.weighty = 4;
        // placement des boutons en 2�me ligne, 1�re colonne
        gc.gridx = 1;
        gc.gridy = 2;
        grid.setConstraints(panel, gc);
        this.add(panel);
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

    private void initConsigne(){
        Font fonte = new Font("Tahoma", 1, 30);
        labelTab[0]= new JLabel("La question est :");
        labelTab[0].setFont(fonte);
        labelTab[2]= new JLabel("La bonne réponse :");
        labelTab[2].setFont(fonte);
        labelTab[4]= new JLabel("Les mauvaises réponses : ");
        labelTab[4].setFont(fonte);
    }

    private void initQuestion(){
        Font fonte = new Font("Tahoma", 1, 30);
        int j=0;
        for(int i=0; i<labelTab.length;i++){
            if(labelTab[i]==null){
                labelTab[i]= new JLabel(questionTab[j]);
                labelTab[i].setFont(fonte);
                j++;

                switch(i){
                    case 1 : labelTab[i].setForeground(new Color(53, 42, 255)); break;
                    case 3 : labelTab[i].setForeground(new Color(69, 165, 52)); break;
                    default : labelTab[i].setForeground(new Color(255, 3,0)); break;
                }
            }
        }
    }
    private void initEntete() {

        // panel d'entete de la fen�tre
        JPanel entete = new JPanel();
        FlowLayout enteteLayout = new FlowLayout();
        enteteLayout.setAlignment(FlowLayout.CENTER);
        entete.setLayout(enteteLayout);
        LineBorder enteteBorder = new LineBorder(Color.BLUE, 8);
        entete.setBorder(enteteBorder);

        // le label
        JLabel lb1 = new JLabel("Question ");
        lb1.setFont(new Font("Georgia", 1, 96));
        entete.add(lb1);

        // placement de l'entete en 1�re ligne, 1�re colonne
        gc.gridx = 1;
        gc.gridy = 1;
        grid.setConstraints(entete, gc);
        add(entete);
    }

    private void initButton(){
        Font fonte = new Font("Tahoma", 1, 30);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2,2));

        JButton previousButton = new JButton("Précédent");
        previousButton.setFont(fonte);
        previousButton.addActionListener(this);
        buttonPanel.add(previousButton);

        JButton nextButton = new JButton("Suivant");
        nextButton.addActionListener(this);
        nextButton.setFont(fonte);
        buttonPanel.add(nextButton);

        JButton deleteButton = new JButton("Supprimer");
        deleteButton.addActionListener(this);
        deleteButton.setFont(fonte);
        buttonPanel.add(deleteButton);

        JButton leaveButton = new JButton("Quitter");
        leaveButton.addActionListener(this);
        leaveButton.setFont(fonte);
        buttonPanel.add(leaveButton);

        gc.weighty = 0.5;
        gc.gridx =1;
        gc.gridy=3;
        grid.setConstraints(buttonPanel,gc);
        this.add(buttonPanel);
    }

    private void nextQuestion(){
        int sizeQuestion = gestionQuestion.getListeQuestion().size()-1;
        if(nbQuestion >= sizeQuestion){
            nbQuestion=0;
        }
        else{
            nbQuestion++;
        }
        try{
        this.question=gestionQuestion.getListeQuestion().get(nbQuestion);
        }catch (IndexOutOfBoundsException e){
            dispose();
        }
        this.questionTab = question.getQuestionReponse();
        setQuestion();
    }

    private void previousQuestion(){
        int sizeQuestion = gestionQuestion.getListeQuestion().size()-1;
        if(nbQuestion == 0){
            nbQuestion=sizeQuestion;
        }
        else{
        nbQuestion--;
        }

        this.question=gestionQuestion.getListeQuestion().get(nbQuestion);
        this.questionTab = question.getQuestionReponse();
        setQuestion();
    }
    private void setQuestion(){

        labelTab[1].setText(questionTab[0]);
        labelTab[3].setText(questionTab[1]);
        labelTab[5].setText(questionTab[2]);
        labelTab[6].setText(questionTab[3]);
        labelTab[7].setText(questionTab[4]);
        labelTab[8].setText(questionTab[5]);
        labelTab[9].setText(questionTab[6]);


    }
    public static void main(String[] args){
        File path = new File("ressources\\question");
        ViewQuestion viewQuestionTest = new ViewQuestion(path);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton temporaryButton = (JButton) e.getSource();
        if(temporaryButton.getText().equals("Suivant")){
            nextQuestion();
        }
        if(temporaryButton.getText().equals("Précédent")){
            previousQuestion();
        }
        if(temporaryButton.getText().equals("Supprimer")){

            Outils.supprimerFichierTxt(gestionQuestion.getListeFilePath().get(nbQuestion));
            gestionQuestion.getListeFilePath().remove(nbQuestion);
            gestionQuestion.getListeQuestion().remove(nbQuestion);
            if(gestionQuestion.getListeQuestion().isEmpty()){
                dispose();
            }
            nextQuestion();

        }
        if(temporaryButton.getText().equals("Quitter")){
            dispose();
        }

    }
}
