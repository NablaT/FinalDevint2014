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
    private int nBOfPoints;

    //private ProgressBar progressBar;
    private IHMPrincipal ihmPrincipal;
    private JLabel background;

    public Game(IHMPrincipal ihmPrincipal, int NbOfPoints, boolean answerWasCorrect) {
        super();
        this.ihmPrincipal=ihmPrincipal;
        this.nBOfPoints=nBOfPoints;
       // this.voix = new SIVOXDevint();
        this.init(false);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    protected void init(boolean answerWasCorrect) {

        this.setPreferredSize(new Dimension(900, 900));
        this.setOpaque(false);
        this.gestionQuestion=new GestionQuestion();
        this.gestionQuestion.getRdmNumber();
        this.grid= new GridBagLayout();
        this.voix = new SIVOXDevint();
        //this.progressBar=new ProgressBar(answerWasCorrect);
        String s = this.gestionQuestion.getAleaObjectQuestion(this.gestionQuestion.getRdm()).getQuestionReponse()[0];

        this.question= new JLabel(s,JLabel.CENTER);

        System.out.println("AVANT LE PLAY VOX"+ s);
        System.out.println("MAINTENANT LE LABEL "+this.question.getText());
        this.voix.stop();
        this.voix.playText(s);
        s=null;
        this.question.setForeground(Color.WHITE);
        this.question.setFont(new Font("Comic",Font.CENTER_BASELINE,Constantes.sizeText));


        this.question.setPreferredSize(new Dimension(800, 800));
        this.answer=new IHMAnswer(this.gestionQuestion,this);
        this.gc=new GridBagConstraints();

        this.setPreferredSize(new Dimension(900, 900));
        this.build();
        this.setSize(900,900);
    }

    public void build(){
        this.setLayout(this.grid);

        this.gc.fill=GridBagConstraints.BOTH;

        gc.insets = new Insets(5, 5, 5, 5);

        gc.gridx=0;
        gc.gridy=4;
        gc.weightx=4;
        gc.weightx=4;

        this.add(this.question, gc);

        gc.gridx=0;
        gc.gridy=8;
        gc.weightx=10;
        gc.weighty=10;

        this.add(this.answer, gc);
    }

    public void maj(int nbPoints,boolean answerWasCorrect){
        this.voix.stop();
        int step=this.ihmPrincipal.getStep();
        this.remove(question);
        this.remove(this.answer);
        this.voix=null;
        this.question=null;
        int save=this.nBOfPoints;
        //this.remove(this.progressBar);
        /*this.setPreferredSize(new Dimension(1000, 600));
        this.init(answerWasCorrect);
        this.repaint();
        this.revalidate();
        int step=this.ihmPrincipal.getStep();
*/
        this.ihmPrincipal.closeWindow();
        this.ihmPrincipal.dispose();

        System.out.println("RECUPERER " + nbPoints);

        System.out.println("LES POINTS DANS GAME"+save);
        this.nBOfPoints=save+nbPoints;

        System.out.println("LES POINTS DANS GAME"+this.nBOfPoints);
        if(step==13){
            IHMEnd end= new IHMEnd("FIN");
        }
        else if(answerWasCorrect){
            step++;
            System.out.println("NOMBRE DE POINTS "+this.nBOfPoints);
            IHMPrincipal ihm=new IHMPrincipal("Quizz", answerWasCorrect,step,this.nBOfPoints);

        }
        else{
            IHMPrincipal ihm=new IHMPrincipal("Quizz", answerWasCorrect,step,this.nBOfPoints);
        }


        this.voix.stop();
    }


    public void setIHMAnswer(IHMAnswer an){
        this.answer=an;
    }


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
