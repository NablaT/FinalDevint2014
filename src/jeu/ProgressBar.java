package jeu;

import testQuestion.GestionQuestion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by REMI on 12/05/14.
 */

public class ProgressBar extends JPanel {
    /*private Thread t;
    private JProgressBar bar;*/
    private Image image;
    private JPanel panelGauche;
    private JPanel panelDroit;
    private ImageProgressBar progressBar;
    private GridBagConstraints gc;
    private GridBagLayout grid;

    public ProgressBar(){
        this.setSize(500, 500);
        this.panelDroit=new JPanel();
        this.panelDroit.setBackground(Color.RED);
        this.panelDroit.setSize(new Dimension(100, 500));
        this.panelGauche=new JPanel();
        this.panelGauche.setBackground(Color.RED);
        this.panelGauche.setSize(new Dimension(100, 500));

        this.progressBar=new ImageProgressBar();
        this.progressBar.setSize(new Dimension(300,500));

        /*this.panelDroit.setVisible(false);
        this.panelGauche.setVisible(false);*/
        this.panelDroit.setOpaque(false);
        this.panelGauche.setOpaque(false);
        this.init();
    }


    protected void init() {
        this.setOpaque(false);
        this.grid= new GridBagLayout();

        this.gc=new GridBagConstraints();

        this.build();
    }

    public void build(){
        this.setLayout(this.grid);

        this.gc.fill=GridBagConstraints.BOTH;

        gc.insets = new Insets(5, 5, 5, 5);


        gc.gridx=0;
        gc.gridy=0;
        gc.weightx=1;
        gc.weighty=4;

        this.add(this.panelGauche, gc);

        gc.gridx=1;
        gc.gridy=0;
        gc.weightx=8;
        gc.weighty=4;

        this.add(this.progressBar, gc);



        gc.gridx=2;
        gc.gridy=0;
        gc.weightx=1;
        gc.weighty=4;

        this.add(this.panelDroit, gc);



    }



}
