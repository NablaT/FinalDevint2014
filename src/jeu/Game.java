package jeu;

import devintAPI.FenetreAbstraite;
import t2s.SIVOXDevint;
import testQuestion.GestionQuestion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * Created by user on 04/04/14.
 */

public class Game extends JPanel implements ActionListener, KeyListener {
    private SIVOXDevint voix;
    private GridBagLayout grid;
    private GridBagConstraints gc;
    private IHMAnswer answer;
    private JLabel question;
    private GestionQuestion gestionQuestion;

    private JLabel background;

    public Game(String title) {
        super();
        //super(title);
        this.voix = new SIVOXDevint();
        this.init();
    //     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //  this.setSize(500, 300);
        //this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    protected void init() {

        this.setOpaque(false);//setContentPane(new JLabel(new ImageIcon("ressources\\\\image\\\\background.jpg")));
        this.gestionQuestion=new GestionQuestion();
        this.gestionQuestion.getRdmNumber();
        this.grid= new GridBagLayout();
        String s = this.gestionQuestion.getAleaObjectQuestion(this.gestionQuestion.getRdm()).getQuestionReponse()[0];
        this.question= new JLabel(s,JLabel.CENTER);
        this.voix.stop();
        this.voix.playText(s);
        //System.out.println("Je passe par laaaaaaaa");

        this.question.setForeground(Color.WHITE);
        this.background=new JLabel(new ImageIcon("ressources\\image\\button.png"));
      //  this.add(background);
       // this.question.setIcon(new ImageIcon("ressources\\image\\button.png"));
        this.question.setFont(new Font("Comic",Font.CENTER_BASELINE,Constantes.sizeText));


       this.question.setPreferredSize(new Dimension(200, 100));
        this.answer=new IHMAnswer(this.gestionQuestion,this);
        this.gc=new GridBagConstraints();

        this.build();
        this.setSize(600,600);
    }

    public void build(){
        this.setLayout(this.grid);

        this.gc.fill=GridBagConstraints.BOTH;

        gc.insets = new Insets(5, 5, 5, 5);

        gc.gridx=0;
        gc.gridy=0;
        gc.weightx=4;
        gc.weightx=4;


        this.add(this.question, gc);

        gc.gridx=0;
        gc.gridy=1;
        gc.weightx=4;
        gc.weighty=4;

        this.add(this.answer, gc);
        /*this.answer.setVisible(true);
        this.question.setVisible(true);
*/


    }

    public void maj(){
        System.out.println("Je rentre");

        //this.answer.setVisible(false);
        this.remove(question);//question.setVisible(false);
        this.remove(this.answer);
        this.init();
        this.repaint();
        this.revalidate();
    }


    public void setIHMAnswer(IHMAnswer an){
        this.answer=an;
    }
/*
    @Override
    protected String wavAide() {
        return null;
    }

    @Override
    protected String wavAccueil() {
        return null;
    }

    @Override
    protected String wavRegleJeu() {
        return null;
    }

    @Override
    public void changeColor() {

    }*/

    public IHMAnswer getAnswer(){
        return this.answer;
    }

    @Override
public void keyTyped(KeyEvent e) {
    System.out.println("Code touche pressée : " + e.getKeyCode() + " - caractère touche pressée : " + e.getKeyChar());

}

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Code touche pressée : " + e.getKeyCode() + " - caractère touche pressée : " + e.getKeyChar());


    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Code touche pressée : " + e.getKeyCode() + " - caractère touche pressée : " + e.getKeyChar());

    }
}
