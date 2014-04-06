package jeu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by user on 06/04/14.
 */
public class GoodAnswer extends JPanel implements ActionListener {

    private JLabel good;
    private JButton next;
    private GridBagLayout grid;
    private GridBagConstraints gc;
    private Game game;

    public GoodAnswer(Game g){
        this.game=g;
        this.good= new JLabel("BRAVO !");
        this.next= new JButton("Question suivante");
        this.next.addActionListener(this);
        this.setVisible(true);
        this.initialize();
    }
    public void initialize(){

        this.setSize(800, 800);
        this.buildElements();
        this.initializeGrid();
        this.setSize(300,300);

    }

    public void buildElements(){
        this.grid=new GridBagLayout();
        this.setLayout(grid);
        this.gc = new GridBagConstraints();
    }


    private void initializeGrid() {
        this.gc.fill=GridBagConstraints.BOTH;

        gc.insets = new Insets(5, 5, 5, 5);


        //gc.ipady=gc.anchor=GridBagConstraints.CENTER;;

        gc.weightx=2;
        gc.weighty=1;

        gc.gridx=0;
        gc.gridy=0;

        this.add(this.good, gc);


        gc.weightx=2;
        gc.weighty=1;

        gc.gridx=0;
        gc.gridy=1;

        this.add(this.next, gc);


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source= e.getSource();
        JButton but=(JButton) source;
        if(but.getText().equals("Question suivante")){
            this.setVisible(false);
            this.game.maj();
        }

    }
}
