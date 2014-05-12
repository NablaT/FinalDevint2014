package jeu;

import t2s.SIVOXDevint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Created by user on 05/04/14.
 */

public class IHMChoiceOption extends JPanel {
/*implements ActionListener, MouseListener 
    protected SIVOXDevint voix;
    protected ArrayList<JButton> buttonAnswers;
    protected GridBagLayout grid;
    protected GridBagConstraints gc;
    protected Game game;
    protected String goodAnswer;
    protected ArrayList<String> answers;

    public IHMChoiceOption(ArrayList<String> answers, String goodAnswer, Game g, int nb){
        this.voix = new SIVOXDevint();
        this.setOpaque(false);
        this.goodAnswer=goodAnswer;
        this.game=g;
        this.buildAnswer(nb);
        this.initializeAnswer(nb);
    }

    private void initializeAnswer(int nb) {
        this.buildAnswer(nb);
        this.setLayout(grid);
        //this.initializeGrid();
        this.setSize(300,300);
    }

    public void buildAnswer(int n){
        switch(n){
            case 2:
                this.buildDuo();
            case 4:
                this.buildCarre();
            case 6:
                this.buildHexa();
            default:
                break;
        }
    }

    private void buildHexa() {
        for(int i=0;i<6;i++){
            this.buttonAnswers.add(new JButton(answers.get(i)));
            this.buttonAnswers.get(i).setFont(new Font("Comic",Font.CENTER_BASELINE,Constantes.sizeText));
            this.buttonAnswers.get(i).addActionListener(this);
            this.buttonAnswers.get(i).addMouseListener(this);
        }
        this.grid=new GridBagLayout();

        this.gc = new GridBagConstraints();
    }

    private void buildCarre() {
        for(int i=0;i<4;i++){
            this.buttonAnswers.add(new JButton(answers.get(i)));
            this.buttonAnswers.get(i).setFont(new Font("Comic",Font.CENTER_BASELINE,Constantes.sizeText));
            this.buttonAnswers.get(i).addActionListener(this);
            this.buttonAnswers.get(i).addMouseListener(this);
        }
        this.grid=new GridBagLayout();

        this.gc = new GridBagConstraints();
    }

    private void buildDuo() {
        for(int i=0;i<2;i++){
            this.buttonAnswers.add(new JButton(answers.get(i)));
            this.buttonAnswers.get(i).setFont(new Font("Comic",Font.CENTER_BASELINE,Constantes.sizeText));
            this.buttonAnswers.get(i).addActionListener(this);
            this.buttonAnswers.get(i).addMouseListener(this);
        }
        this.grid=new GridBagLayout();

        this.gc = new GridBagConstraints();

    }



    public void build(){

    }

    @Override
    public void actionPerformed(ActionEvent e) {

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

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }*/
}
