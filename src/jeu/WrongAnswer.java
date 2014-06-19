package jeu;

import t2s.SIVOXDevint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * Created by user on 06/04/14.
 */
public class WrongAnswer extends JPanel implements ActionListener,KeyListener {

    private JLabel wrongInfo1;
    private JLabel wrongInfo2;
    private JLabel goodAnswer;
    private JButton next;
    private GridBagConstraints gc;
    private GridBagLayout grid;
    private Game game;
    private SIVOXDevint voix;

    public WrongAnswer(String goodAnswer, Game g){
        this.voix= new SIVOXDevint();
        this.setFocusable(true);
        this.setOpaque(false);
        this.initialize(goodAnswer);
        this.game=g;
        this.next.addActionListener(this);
    }

    public void initialize(String good){

        this.setSize(800, 800);
        this.buildElements(good);
        this.initializeGrid();
        this.setSize(300,300);

    }

    public void buildElements(String answers){
        this.wrongInfo1=new JLabel("Faux",JLabel.CENTER);
        this.wrongInfo1.setFont(new Font("Comic", Font.CENTER_BASELINE, Constantes.sizeText));
        this.wrongInfo1.setForeground(Color.WHITE);
        this.wrongInfo2=new JLabel("La réponse était :",JLabel.CENTER);
        this.wrongInfo2.setFont(new Font("Comic",Font.CENTER_BASELINE,Constantes.sizeText));
        this.wrongInfo2.setForeground(Color.WHITE);
        this.next= new JButton("Prochaine question");
        this.next.setFont(new Font("Comic",Font.CENTER_BASELINE,Constantes.sizeText));
        this.grid=new GridBagLayout();
        this.setLayout(grid);
        this.next.addActionListener(this);
        this.gc = new GridBagConstraints();
        this.goodAnswer=new JLabel(answers,JLabel.CENTER);
        this.goodAnswer.setForeground(Color.WHITE);

        this.goodAnswer.setFont(new Font("Comic",Font.CENTER_BASELINE,Constantes.sizeText));
        this.voix.playText("Faux, la réponse était : "+answers);
    }


    private void initializeGrid() {
        this.gc.fill=GridBagConstraints.BOTH;

        gc.insets = new Insets(5, 5, 5, 5);


        //gc.ipady=gc.anchor=GridBagConstraints.CENTER;;

        gc.weightx=2;
        gc.weighty=1;

        gc.gridx=0;
        gc.gridy=0;

        this.add(this.wrongInfo1, gc);


        gc.weightx=2;
        gc.weighty=1;

        gc.gridx=0;
        gc.gridy=1;

        this.add(this.wrongInfo2, gc);


        gc.weightx=2;
        gc.weighty=1;

        gc.gridx=0;
        gc.gridy=3;

        this.add(this.goodAnswer, gc);


        gc.weightx=2;
        gc.weighty=1;

        gc.gridx=0;
        gc.gridy=4;

        this.add(this.next, gc);

    }

    public void clean(){
        this.removeAll();
        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source= e.getSource();
        this.voix.stop();
        if(source.equals(this.next)){
            this.setVisible(false);
            this.game.maj(0,false);
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()== KeyEvent.VK_ENTER) {
            this.setVisible(false);
            this.game.maj(0,false);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
