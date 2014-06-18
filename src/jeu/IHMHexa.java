package jeu;

import t2s.SIVOXDevint;
import testQuestion.GestionQuestion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Created by user on 04/04/14.
 */
public class IHMHexa extends JPanel implements ActionListener, MouseListener,KeyListener{
    private SIVOXDevint voix;
    private JButton answer1;
    private JButton answer2;
    private JButton answer3;
    private JButton answer4;
    private JButton answer5;
    private JButton answer6;
    private GridBagLayout grid;
    private GridBagConstraints gc;
    private String goodAnswer;
    private Game game;
    private String choixReponse;
    private ArrayList<String> answers;
    private boolean end;
    private boolean bonneReponse;

    public IHMHexa(ArrayList<String> answers, String goodAnswer,Game g){
        this.answers = answers;
        this.choixReponse="";
        this.setFocusable(true);
        this.requestFocusInWindow();
        //super(answers,goodAnswer,g,6);
        this.addKeyListener(this);
        this.voix = new SIVOXDevint();
        this.setOpaque(false);
        this.goodAnswer=goodAnswer;
        this.game=g;
        this.initialize(answers);
        this.goodAnswer=goodAnswer;
    }

    public void initialize(ArrayList<String> answers){

            this.buildElements(answers);
            this.setLayout(grid);
            this.initializeGrid();

        this.setSize(300,300);
    }

    public void buildElements(ArrayList<String> answers){
        this.answer1= new JButton(answers.get(0));
        this.answer1.setFont(new Font("Comic",Font.CENTER_BASELINE,Constantes.sizeText));
        this.answer2= new JButton(answers.get(1));
        this.answer2.setFont(new Font("Comic",Font.CENTER_BASELINE,Constantes.sizeText));
        this.answer3= new JButton(answers.get(2));
        this.answer3.setFont(new Font("Comic",Font.CENTER_BASELINE,Constantes.sizeText));
        this.answer4= new JButton(answers.get(3));
        this.answer4.setFont(new Font("Comic",Font.CENTER_BASELINE,Constantes.sizeText));
        this.answer5= new JButton(answers.get(4));
        this.answer5.setFont(new Font("Comic",Font.CENTER_BASELINE,Constantes.sizeText));
        this.answer6= new JButton(answers.get(5));
        this.answer6.setFont(new Font("Comic",Font.CENTER_BASELINE,Constantes.sizeText));


        this.answer1.addActionListener(this);
        this.answer1.addMouseListener(this);
        this.answer2.addActionListener(this);
        this.answer2.addMouseListener(this);
        this.answer4.addActionListener(this);
        this.answer4.addMouseListener(this);
        this.answer3.addActionListener(this);
        this.answer3.addMouseListener(this);
        this.answer5.addActionListener(this);
        this.answer5.addMouseListener(this);
        this.answer6.addActionListener(this);
        this.answer6.addMouseListener(this);

        this.grid=new GridBagLayout();

        this.gc = new GridBagConstraints();
    }


    private void initializeGrid() {
        this.gc.fill=GridBagConstraints.BOTH;

        gc.insets = new Insets(5, 5, 5, 5);

		/*
        gc.ipady=gc.anchor=GridBagConstraints.CENTER;;
*/
		/* weightx définit le nombre de cases en abscisse */
        gc.weightx=2;

		/* weightx définit le nombre de cases en ordonnée */
        gc.weighty=2;

		/*
    pour dire qu'on ajoute un composant en position (i, j), on définit
    gridx=i et gridy=j
    */
        gc.gridx=0;
        gc.gridy=0;

		/* On ajoute le composant au panel en précisant le GridBagConstraints*/
        this.add(this.answer1, gc);

        gc.gridx=1;
        gc.gridy=0;
        this.add(this.answer2, gc);

        gc.gridx=0;
        gc.gridy=1;
        this.add(this.answer3, gc);

        gc.gridx=1;
        gc.gridy=1;
        this.add(this.answer4, gc);

        gc.gridx=2;
        gc.gridy=0;
        this.add(this.answer5, gc);


        gc.gridx=2;
        gc.gridy=1;
        this.add(this.answer6, gc);


    }

    public String getGoodAnswer(){
        return this.goodAnswer;
    }

    public void clean(){
        this.removeAll();
        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source= e.getSource();
        JButton but= (JButton) source;
        if(!(but.getText().equals(this.goodAnswer))){
            this.clean();
            gc.weightx=2;
            gc.weighty=2;
            gc.gridx=0;
            gc.gridy=0;
            this.add(new WrongAnswer(this.goodAnswer,this.game),gc);
            this.revalidate();
        }
        else{
            this.clean();
            gc.weightx=2;
            gc.weighty=2;
            gc.gridx=0;
            gc.gridy=0;
            this.add(new GoodAnswer(this.game,6),gc);
            this.revalidate();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //System.out.println(e);
        JButton but = (JButton) e.getSource();
        this.voix.playText(but.getText());
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.voix.stop();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_F1) {
            GestionQuestion gestionQuestion = this.game.getQuestion();
            this.voix.playText(gestionQuestion.getAleaObjectQuestion(
                    gestionQuestion.getRdm()).afficherQuestion());
        }
        if (e.getKeyCode() == KeyEvent.VK_1){
            this.voix.stop();
            this.voix.playText(answers.get(0));
            this.choixReponse = answers.get(0);
        }
        if (e.getKeyCode() == KeyEvent.VK_2){
            this.voix.stop();
            this.voix.playText(answers.get(1));
            this.choixReponse = answers.get(1);
        }
        if (e.getKeyCode() == KeyEvent.VK_3){
            this.voix.stop();
            this.voix.playText(answers.get(2));
            this.choixReponse = answers.get(2);
        }
        if (e.getKeyCode() == KeyEvent.VK_4){
            this.voix.stop();
            this.voix.playText(answers.get(3));
            this.choixReponse = answers.get(3);
        }
        if (e.getKeyCode() == KeyEvent.VK_5){
            this.voix.stop();
            this.voix.playText(answers.get(4));
            this.choixReponse = answers.get(4);
        }
        if (e.getKeyCode() == KeyEvent.VK_6){
            this.voix.stop();
            this.voix.playText(answers.get(5));
            this.choixReponse = answers.get(5);
        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER){

            if(!end){
                if(!choixReponse.equals(goodAnswer)){
                    this.clean();
                    gc.weightx=2;
                    gc.weighty=2;
                    gc.gridx=0;
                    gc.gridy=0;
                    JPanel wrongAnswer = new WrongAnswer(this.goodAnswer,this.game);
                    wrongAnswer.requestFocus();
                    this.add(wrongAnswer,gc);
                    this.revalidate();
                    this.bonneReponse=false;
                }
                else{
                    this.clean();
                    gc.weightx=2;
                    gc.weighty=2;
                    gc.gridx=0;
                    gc.gridy=0;
                    JPanel goodAnswer= new GoodAnswer(this.game,6);
                    goodAnswer.requestFocus();
                    this.add(goodAnswer,gc);
                    this.revalidate();
                    this.bonneReponse=true;
                }
                end=true;
            }else{
                if(bonneReponse){
                    this.game.maj(6,true);
                }else{
                    this.game.maj(0,false);
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
