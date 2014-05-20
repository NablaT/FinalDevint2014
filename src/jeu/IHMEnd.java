package jeu;

import devintAPI.MenuAbstrait;

import javax.swing.*;
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

    /**
     * constructeur,
     *
     * @param title : le nom du jeu
     */

    public IHMEnd(String title) {
        super(title);
        String path= "ressources\\image\\les_boucans.jpg";
        this.setBackground(Color.BLACK);
       //JLabel label=new JLabel(new ImageIcon(path));
        //label.setLayout(new BorderLayout());
       //this.add(label, BorderLayout.CENTER);
        JLabel label=new JLabel(new ImageIcon(path));
        label.setPreferredSize(new Dimension(1600,900));
       this.setContentPane(label);
        //this.setContentPane(label);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(1600,900);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
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
