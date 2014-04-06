package jeu;

import devintAPI.FenetreAbstraite;
import testQuestion.GestionQuestion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * Created by user on 04/04/14.
 */

public class Game extends JFrame implements ActionListener {

    private GridBagLayout grid;
    private GridBagConstraints gc;
    private IHMAnswer answer;
    private JLabel question;
    private GestionQuestion gestionQuestion;

    public Game(String title) {
        super(title);

        this.init();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    protected void init() {

        this.gestionQuestion=new GestionQuestion();
        this.gestionQuestion.getRdmNumber();
        this.grid= new GridBagLayout();
        this.question= new JLabel(this.gestionQuestion.getAleaObjectQuestion(this.gestionQuestion.getRdm()).getQuestionReponse()[0]);
        this.answer=new IHMAnswer(this.gestionQuestion,this);
        this.gc=new GridBagConstraints();

        this.build();
    }

    public void build(){
        this.setLayout(this.grid);

        this.gc.fill=GridBagConstraints.BOTH;

        gc.insets = new Insets(5, 5, 5, 5);
        gc.weightx=4;

        gc.gridx=0;
        gc.gridy=0;

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
}
