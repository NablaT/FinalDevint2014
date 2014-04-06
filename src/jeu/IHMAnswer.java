package jeu;

import testQuestion.GestionQuestion;
import testQuestion.Question;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by user on 04/04/14.
 */
public class IHMAnswer extends JPanel implements ActionListener {

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

    public IHMAnswer(GestionQuestion gestion, Game g){
        this.gridBag=new GridBagLayout();
        this.duoChoice= new JButton("Duo");
        this.duoChoice.addActionListener(this);
        this.carreChoice=new JButton("Carre");
        this.carreChoice.addActionListener(this);
        this.hexaChoice=new JButton("Hexa");
        this.hexaChoice.addActionListener(this);
        this.gc = new GridBagConstraints();
        this.gestionQuestion=gestion;
        this.game=g;
        this.setVisible(true);
        this.build();
    }

    public void build(){

        this.setSize(800,800);
        System.out.println("Dans le build");
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

    /// ICI LES MODIFS POUR CHARGER LES REPONSES
    public void majToAnswers(int nb){
        this.removeAll();
        this.repaint();
        this.setLayout(null);
        Question question=this.gestionQuestion.getAleaObjectQuestion(this.gestionQuestion.getRdm());
       switch(nb){
            case 2:
                this.answersAfterChoice=new IHMDuo(this.buildArray(question,2),question.afficherBonneReponse(),this.game);
                ArrayList<String> list=this.buildArray(question,2);
                for(int i=0;i<2;i++){
                    System.out.println(list.get(i));
                }
                break;
            case 4:
                this.answersAfterChoice=new IHMCarre(this.buildArray(question,4),question.afficherBonneReponse(),this.game);break;
            case 6:
                this.answersAfterChoice=new IHMHexa(this.buildArray(question,6),question.afficherBonneReponse(),this.game);break;
        }

        this.rebuild();
        this.add(this.answersAfterChoice);
        this.revalidate();
    }

    private void rebuild() {
        this.gc = new GridBagConstraints();
        this.setLayout(this.gridBag);
        this.setBackground(Color.red);
        //this.setSize(300,300);
        this.gc.fill=GridBagConstraints.BOTH;
        gc.insets = new Insets(5, 5, 5, 5);
        gc.gridx=0;
        gc.gridy=0;
        gc.weightx=4;
        gc.weighty=4;
        this.add(this.answersAfterChoice, gc);
        // this.add(new JButton("TEST"), gc2);

    }

    public void setList(ArrayList<String> l){
        this.list=l;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("action performed");
        Object source = e.getSource();
       // this.setVisible(false);
        if(source.equals(this.duoChoice)){
            System.out.println("duo");
            this.majToAnswers(2);
        }
        else if(source.equals(this.carreChoice)){
            System.out.println("carre");
            this.majToAnswers(4);
        }
        else if(source.equals(this.hexaChoice)){
            System.out.println();
            this.majToAnswers(6);

        }
    }
}
