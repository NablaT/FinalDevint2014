package jeu;

import t2s.SIVOXDevint;
import testQuestion.GestionQuestion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

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
    private File themePath;
    //private ProgressBar progressBar;
    private IHMPrincipal ihmPrincipal;
    private JLabel background;
    private long chrono;


    public Game(IHMPrincipal ihmPrincipal, int NbOfPoints, boolean answerWasCorrect) {
        super();
        this.ihmPrincipal=ihmPrincipal;
        if(this.ihmPrincipal.getStep()==0){
            chrono=0;
        }
        this.nBOfPoints=nBOfPoints;
       // this.voix = new SIVOXDevint();
        this.init(false);
        this.setVisible(true);

    }

    public Game(IHMPrincipal ihmPrincipal, int NbOfPoints, boolean answerWasCorrect, File themePath) {
        super();
        this.themePath=themePath;
        this.ihmPrincipal=ihmPrincipal;
        if(this.ihmPrincipal.getStep()==0){
            chrono=0;
        }
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
        this.gestionQuestion=new GestionQuestion(themePath);
        this.gestionQuestion.getRdmNumber();
        this.grid= new GridBagLayout();
        this.voix = new SIVOXDevint();
        //this.progressBar=new ProgressBar(answerWasCorrect);
        String s = this.gestionQuestion.getAleaObjectQuestion(this.gestionQuestion.getRdm()).getQuestionReponse()[0];

        this.question= new JLabel(s,JLabel.CENTER);
        this.voix.stop();
        this.voix.playText(s);
        s=null;
        this.question.setForeground(Color.WHITE);
        this.question.setFont(new Font("Comic",Font.CENTER_BASELINE,Constantes.sizeText));


        this.question.setPreferredSize(new Dimension(800, 800));
        this.answer=new IHMAnswer(this.gestionQuestion,this);
        this.addKeyListener(answer);
        this.answer.requestFocus();
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
        int save=this.ihmPrincipal.getNbOfPoints();
        this.ihmPrincipal.closeWindow();
        this.ihmPrincipal.dispose();
        this.nBOfPoints=save+nbPoints;

        if(step==13 && answerWasCorrect){
            this.chrono=this.chrono+ihmPrincipal.Stop_Chrono();
            IHMEnd end= new IHMEnd("FIN",this.nBOfPoints,this.chrono);
            end.requestFocus();
        }
        else if(step==13 && !(answerWasCorrect)){
            this.chrono=this.chrono+ihmPrincipal.Stop_Chrono();
            IHMPrincipal ihm=new IHMPrincipal("Quizz", answerWasCorrect,step,this.nBOfPoints,themePath);
        }
        else if(answerWasCorrect){
            step++;
            this.chrono=this.chrono+ihmPrincipal.Stop_Chrono();
            IHMPrincipal ihm=new IHMPrincipal("Quizz", answerWasCorrect,step,this.nBOfPoints,themePath);

        }
        else{
            this.chrono=this.chrono+ihmPrincipal.Stop_Chrono();
            IHMPrincipal ihm=new IHMPrincipal("Quizz", answerWasCorrect,step,this.nBOfPoints,themePath);
        }

    }


    public void setIHMAnswer(IHMAnswer an){
        this.answer=an;
    }

    public GestionQuestion getQuestion(){ return gestionQuestion;}

    public IHMAnswer getAnswer(){
        return this.answer;
    }

    public IHMPrincipal getIhmPrincipal(){
        return this.ihmPrincipal;
    }
    @Override
    public void keyTyped(KeyEvent e) {
}

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
