package jeu;

import t2s.SIVOXDevint;
import testQuestion.GameDependsOnTheme;
import testQuestion.GestionQuestion;
import testQuestion.Question;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


/**
 * Created by user on 04/04/14.
 */
public class IHMAnswer extends JPanel implements ActionListener, KeyListener, MouseListener {

    private SIVOXDevint voix;
    private JPanel answersAfterChoice;

    private JButton duoChoice;
    private JButton carreChoice;
    private JButton hexaChoice;
    private GridBagConstraints gc;
    private GridBagConstraints gc2;
    private GridBagLayout gridBag;
    private GridBagLayout gridBag2;
    private ArrayList<String> list;
    private GestionQuestion gestionQuestion;
    private Game game;
    private GameDependsOnTheme gameDependsOnTheme;
    private int currentButton = 5;


    public IHMAnswer(GestionQuestion gestion, Game g){
        this.voix= new SIVOXDevint();
        this.setOpaque(false);
        this.addKeyListener(this);
        this.gridBag=new GridBagLayout();
        this.duoChoice= new JButton("2 Choix");
        this.duoChoice.setFont(new Font("Comic",Font.CENTER_BASELINE,Constantes.sizeText));
        this.setFocusable(true);
        this.duoChoice.addActionListener(this);
        this.duoChoice.addKeyListener(this);
        this.duoChoice.addMouseListener(this);
        this.carreChoice=new JButton("4 Choix");
        this.carreChoice.setFont(new Font("Comic",Font.CENTER_BASELINE,Constantes.sizeText));
        //this.carreChoice.setIcon(new ImageIcon("ressources\\\\image\\\\button.png"));
        this.repaint();
        this.carreChoice.addActionListener(this);
        this.carreChoice.addKeyListener(this);
        this.carreChoice.addMouseListener(this);


        this.hexaChoice=new JButton("6 Choix");
        this.hexaChoice.setFont(new Font("Comic",Font.CENTER_BASELINE,Constantes.sizeText));
        this.hexaChoice.addKeyListener(this);
        this.hexaChoice.addActionListener(this);
        this.hexaChoice.addMouseListener(this);
        this.gc = new GridBagConstraints();
        this.gestionQuestion=gestion;
        this.game=g;

        this.setVisible(true);
        this.build();
        this.setOpaque(false);
    }
    public void build(){


        this.setSize(800,800);
        this.setLayout(this.gridBag);
        this.gc.fill=GridBagConstraints.BOTH;
        gc.insets = new Insets(5, 5, 5, 5);
        gc.weightx=2;
        gc.weighty=2;

        gc.gridx=0;
        gc.gridy=0;

        this.add(this.duoChoice, gc);

        gc.gridx=1;
        gc.gridy=0;
        this.add(this.carreChoice, gc);


        gc.gridx=2;
        gc.gridy=0;
        this.add(this.hexaChoice, gc);

    }

    public ArrayList<String> buildArray(Question q, int nb){

        ArrayList<String> list= new ArrayList<String>();
        switch(nb){
            case 2:
                String[] res= this.gestionQuestion.getAleaObjectQuestion(this.gestionQuestion.getRdm()).duo();
                for(int i=0;i<nb;i++){
                    list.add(res[i]);
                }
            case 4:
                String[] res2= this.gestionQuestion.getAleaObjectQuestion(this.gestionQuestion.getRdm()).carre();
                for(int i=0;i<nb;i++){
                    list.add(res2[i]);
                }
            case 6:
                String[] res3= this.gestionQuestion.getAleaObjectQuestion(this.gestionQuestion.getRdm()).hexa();
                for(int i=0;i<nb;i++){
                    list.add(res3[i]);
                }
        }
        return list;
    }


    public void majToAnswers(int nb){
        //this.removeAll();

        this.remove(this.carreChoice);
        this.remove(this.hexaChoice);
        this.remove(this.duoChoice);
        this.repaint();
        this.setLayout(null);
        this.addKeyListener((KeyListener) answersAfterChoice);
        Question question=this.gestionQuestion.getAleaObjectQuestion(this.gestionQuestion.getRdm());
       switch(nb){
            case 2:
                this.answersAfterChoice=new IHMDuo(this.buildArray(question,2),question.afficherBonneReponse(),this.game);
                break;
            case 4:
                this.answersAfterChoice=new IHMCarre(this.buildArray(question,4),question.afficherBonneReponse(),this.game);
                break;
            case 6:
                this.answersAfterChoice=new IHMHexa(this.buildArray(question,6),question.afficherBonneReponse(),this.game);
                break;
        }

        this.rebuild();
        this.answersAfterChoice.requestFocus();
        this.revalidate();
    }

    private void rebuild() {
        this.gc = new GridBagConstraints();
        this.setLayout(this.gridBag);
        //this.setSize(300,300);
        this.gc.fill=GridBagConstraints.BOTH;
        gc.insets = new Insets(5, 5, 5, 5);
        gc.gridx=0;
        gc.gridy=0;
        gc.weightx=4;
        gc.weighty=4;
        this.add(this.answersAfterChoice, gc);
        //this.add(new JButton("TEST"), gc2);

    }

    public void setList(ArrayList<String> l){
        this.list=l;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        e.getSource();
    }

    public JButton getDuo(){
        return this.duoChoice;
    }

    public JButton getCarre(){
        return this.carreChoice;
    }

    public JButton getHexa(){
        return this.hexaChoice;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.voix.stop();
        if (e.getKeyCode() == KeyEvent.VK_F1) {
            this.voix.playText(gestionQuestion.getAleaObjectQuestion(
                    gestionQuestion.getRdm()).afficherQuestion());
        }
    }



    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.voix.stop();
        JButton but = (JButton) e.getSource();
        if(but.equals(duoChoice)){
            majToAnswers(2);
        }
        else if(but.equals(carreChoice)){
            majToAnswers(4);
        }
        else if(but.equals(hexaChoice)){
            majToAnswers(6);
        }


    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.voix.stop();
        this.initCursor1();
        JButton but = (JButton) e.getSource();
        this.voix.playText(but.getText());
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public void initCursor1(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage("..\\ressources\\image\\cursor1.png");
        image.getScaledInstance(1000,1000,Image.SCALE_DEFAULT);
        Point hotSpot = new Point(0,0);
        Cursor cursor = toolkit.createCustomCursor(image,hotSpot,"Mouse");
        this.setCursor(cursor);
        // Retourner le chemin complet du répertoire de travail
        String curDir = System.getProperty("user.dir");
    }

}
