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
 * Created by user on 04/04/14.
 */
public class IHMDuo extends JPanel implements ActionListener, MouseListener{
    private SIVOXDevint voix;
    private JButton answer1;
    private JButton answer2;
    private GridBagLayout grid;
    private GridBagConstraints gc;
    private Game game;
    private String goodAnswer;

    public IHMDuo(ArrayList<String> answers, String goodAnswer, Game g){
        this.voix = new SIVOXDevint();
        this.setOpaque(false);
        this.initialize(answers);
        this.goodAnswer=goodAnswer;
        this.game=g;
        //this.setVisible(true);
    }

    public void initialize(ArrayList<String> answers){

        this.setSize(800,800);
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
        this.grid=new GridBagLayout();
        this.answer1.addActionListener(this);
        this.answer1.addMouseListener(this);
        this.answer2.addActionListener(this);
        this.answer2.addMouseListener(this);
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

    }

    public void clean(){
        this.removeAll();
        this.repaint();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source= e.getSource();
        JButton but= (JButton) source;
      //  this.setVisible(false);
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
            this.add(new GoodAnswer(this.game,2),gc);
            this.revalidate();
        }
    }
    public String getGoodAnswer(){
        return this.goodAnswer;
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
}
