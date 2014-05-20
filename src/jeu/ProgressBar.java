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
    private int step=0;

    public ProgressBar(boolean answerWasCorrect){
        this.setSize(1000, 1000);

        this.panelDroit=new JPanel();
        this.panelDroit.setBackground(Color.RED);

        this.panelDroit.setSize(new Dimension(200, 200));
        this.panelGauche=new JPanel();
        this.panelGauche.setBackground(Color.BLUE);
        this.panelGauche.setSize(new Dimension(200, 200));
        if(answerWasCorrect) this.step++;
        this.progressBar=new ImageProgressBar(step);
        this.progressBar.setLayout(new BorderLayout());
        this.progressBar.setSize(new Dimension(200,200));

        /*this.panelDroit.setVisible(false);
        this.panelGauche.setVisible(false);*/
        //this.panelDroit.setOpaque(false);
        //this.panelGauche.setOpaque(false);
        this.setVisible(true);
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
        this.panelDroit.setLayout(grid);
        this.panelGauche.setLayout(grid);
        this.progressBar.setLayout(grid);
        this.gc.fill=GridBagConstraints.BOTH;
        BorderLayout b=new BorderLayout();
        gc.insets = new Insets(5, 5, 5, 5);

        //this.setLayout(b);
       // this.add(this.progressBar,BorderLayout.CENTER);

        gc.gridx=0;
        gc.gridy=0;
        gc.gridwidth=2;
        gc.gridheight=2;

        this.add(this.panelGauche, gc);

        gc.gridx=2;
        gc.gridy=0;
        gc.gridwidth=2;
        gc.gridheight=2;

        this.add(this.progressBar, gc);



        gc.gridx=4;
        gc.gridy=0;
        gc.gridwidth=2;
        gc.gridheight=2;

        this.add(this.panelDroit, gc);


    }



}
