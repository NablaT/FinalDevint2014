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
public class IHMCarre extends JPanel implements ActionListener, MouseListener,KeyListener {
    private SIVOXDevint voix;
    private JButton answer1;
    private JButton answer2;
    private JButton answer3;
    private JButton answer4;
    private GridBagLayout grid;
    private GridBagConstraints gc;
    private String goodAnswer;
    private Game game;
    private String choixReponse;
    private ArrayList<String> answers;
    private boolean end;
    private boolean bonneReponse;

    public IHMCarre(ArrayList<String> answers,String goodAnswer,Game g){
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.voix = new SIVOXDevint();
        this.addKeyListener(this);
        this.setOpaque(false);
        this.game=g;
        this.initialize(answers);

        this.goodAnswer=goodAnswer;
    }

    public void initialize(ArrayList<String> answers){
        this.answers = answers;
        this.choixReponse="";
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

        this.answer1.addActionListener(this);
        this.answer1.addMouseListener(this);
        this.answer2.addActionListener(this);
        this.answer2.addMouseListener(this);
        this.answer4.addActionListener(this);
        this.answer4.addMouseListener(this);
        this.answer3.addActionListener(this);
        this.answer3.addMouseListener(this);
        this.grid=new GridBagLayout();

        this.gc = new GridBagConstraints();
    }


    private void initializeGrid() {
        this.gc.fill=GridBagConstraints.BOTH;

        gc.insets = new Insets(5, 5, 5, 5);
        gc.weighty=2;
        gc.weightx=2;

        gc.gridx=0;
        gc.gridy=0;

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
            this.add(new GoodAnswer(this.game,4),gc);
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
        this.voix.stop();
        if(!end){
            if (e.getKeyCode() == KeyEvent.VK_F2){
                this.voix.playText(" Pour répéter la question, veuillez appuyer sur F1" + "Vous pouvez jouer avec la souris ou avec F1 et les chiffres");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                this.voix.playText("Appuyer sur un chiffre pour écouter une réponse, puis appuyer sur entrée pour valider");
            }
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
            if (e.getKeyCode() == KeyEvent.VK_ENTER){
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
                        JPanel goodAnswer= new GoodAnswer(this.game,4);
                        goodAnswer.requestFocus();
                        this.add(goodAnswer,gc);
                        this.revalidate();
                        this.bonneReponse=true;
                    }
                end=true;
            }
        }
        else{
            if (e.getKeyCode() == KeyEvent.VK_F2){
                this.voix.playText(" Pour aller à la question suivante, veuillez appuyer sur entré");
            }
            if( e.getKeyCode()== KeyEvent.VK_ENTER){
                if(bonneReponse){
                    this.game.maj(4,true);
                }else{
                    this.game.maj(0,false);
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e){

        }
    }

