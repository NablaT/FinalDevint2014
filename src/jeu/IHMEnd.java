package jeu;

import devintAPI.MenuAbstrait;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import t2s.SIVOXDevint;

/**
 * Created by REMI on 19/05/14.
 */

public class IHMEnd extends JFrame implements ActionListener, KeyListener {

    private JTextField labelInfo;
    private JLabel labelInfo2;
    private int score;
    private JButton returnButton;
    private GridBagLayout grid;
    private GridBagConstraints gc;
    private int nbOfPoints;
    private long chrono;
    /**
     * constructeur,
     *
     * @param title : le nom du jeu
     */

    public IHMEnd(String title, int nbOfPoints, long chrono) {
        super(title);
        String path= "..\\ressources\\image\\fireworks-wallpaper-38935.jpg";
        this.setBackground(Color.BLACK);
        JLabel label=new JLabel(new ImageIcon(path));

        this.setContentPane(label);
        //label.setLayout(new BorderLayout());
        //this.add(label, BorderLayout.CENTER);
        this.nbOfPoints=nbOfPoints;

        this.grid=new GridBagLayout();

        this.setLayout(this.grid);
        //JPanel panel= (JPanel) this.getContentPane();


//        this.setLayout(new BorderLayout());

        this.labelInfo=new JTextField("Bravo ! Tu as totalisé "+nbOfPoints);
        this.labelInfo2= new JLabel("Bravo ! Tu as totalisé "+nbOfPoints+ " points");
        this.labelInfo2.setForeground(Color.WHITE);

        this.labelInfo.setPreferredSize(new Dimension(500,500));

        Border border = BorderFactory.createLineBorder(Color.WHITE);

        Font font1 = new Font("SansSerif", Font.BOLD, 80);
        //Font f=new Font("SansSerif", Font.CENTER_BASELINE, 40);
        this.labelInfo2.setFont(font1);
                /*
                 * To set JTextField's border use,
                 * void setBorder(Border b)
                 * method.
                 */

       // labelInfo.setFont(font1);
        labelInfo2.setBorder(border);
        this.labelInfo2.setOpaque(false);
        this.build();
       /* this.labelInfo2=new JLabel("Vous avez obtenus");
        this.labelInfo=new JLabel(nbOfPoints+ " points !");
        this.returnButton=new JButton("Retour Menu");*/

        //this.labelInfo.setBackground(Color.WHITE);
        //this.add(labelInfo, BorderLayout.CENTER);

        this.labelInfo.setVisible(true);

        //this.setContentPane(label);
       // this.getContentPane().add(label);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(1600,900);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }


    public void build(){

        this.grid.location(800,800);
        this.gc=new GridBagConstraints();
        this.gc.fill=GridBagConstraints.REMAINDER;

        gc.insets = new Insets(5, 5, 5, 5);

        gc.gridx=4;
        gc.gridy=16;
        gc.gridwidth=2;
        gc.gridheight=2;

        this.add(this.labelInfo2,gc);

    }
/*
    @Override
    protected String[] nomOptions() {
        return new String[0];
    }

    @Override
    protected void lancerOption(int i) {

    }

    @Override
    protected String wavAccueil() {
        return null;
    }

    @Override
    protected String wavRegleJeu() {
        return null;
    }*/



    @Override
    public void actionPerformed(ActionEvent e) {

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
