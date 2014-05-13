package jeu;

import devintAPI.MenuAbstrait;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**.
 * Created by user on 07/04/14.
 */
public class IHMPrincipal extends MenuAbstrait implements ActionListener, KeyListener {

    private Game game;
    private GridBagLayout grid;
    private GridBagConstraints gc;

    private ImageBackground background;

    private int nextButton=-1;
    private int currentButton=-1;
    private int nbOfPoints=0;

    public IHMPrincipal(String title){

        super(title);

        this.setContentPane(new JLabel(new ImageIcon("..\\ressources\\\\image\\\\background.jpg")));

        this.build();

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(1600,900);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        JButton[] but=new JButton[3];
        but[0]=(this.game.getAnswer().getDuo());
        but[1]=(this.game.getAnswer().getCarre());
        but[2]=(this.game.getAnswer().getHexa());


        super.setBoutonOption(but);

    }

    public void build(){
        this.game=new Game(this, 0,false);
        this.game.setPreferredSize(new Dimension(1000,600));
        this.grid=new GridBagLayout();
        this.grid.location(500,500);
        this.gc=new GridBagConstraints();

        this.gc.gridheight=10;
        this.gc.gridwidth=10;

        gc.insets = new Insets(5, 5, 5, 5);
        gc.weightx=14;
        gc.weighty=14;
        gc.gridx=4;
        gc.gridy=4;

        this.setLayout(this.grid);
        this.add(this.game, gc);

    }

    public void maj(int NbOfPoints, boolean answerWasCorrect){
        this.remove(game);
        this.game=new Game(this,NbOfPoints,answerWasCorrect);
        this.repaint();
        this.revalidate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

}
    public void closeWindow(){
        this.dispose();
    }
    public Game getGame(){
        return this.game;
    }
    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        System.out.println("Code touche pressée : " + e.getKeyCode() + " - caractère touche pressée : " + e.getKeyChar());
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            //this.game.
            System.out.println(this.game.getAnswer().getDuo().getX());
            if(this.currentButton==-1){
                this.currentButton = 0;
                super.setFocusedButton(currentButton);
            }
            else{
                unFocusedButton(currentButton);
                currentButton = (currentButton - 1) % 3;
                setFocusedButton(currentButton);
            }
            System.out.println("LEFT: Current button"+currentButton);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            // m�thode � rendre concr�te par h�ritage
            //lancerOption(optionCourante);
            if(this.currentButton==-1){
                this.currentButton = 0;
                super.setFocusedButton(currentButton);
            }
            else{
                unFocusedButton(currentButton);
                currentButton = (currentButton +1) % 3;
                setFocusedButton(currentButton);

            }
            System.out.println("RIGHT: Current button"+currentButton);

        }
        Object source = e.getSource();
        System.out.println("Avant ENTER");
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if(currentButton==0){
                System.out.println("duo");
                this.game.getAnswer().majToAnswers(2);
            }
            else if(currentButton==1){
                System.out.println("carre");
                this.game.getAnswer().majToAnswers(4);
            }
            else if(currentButton==2){
                System.out.println();
                this.game.getAnswer().majToAnswers(6);
            }
        }

    }



    @Override
    public void keyReleased(KeyEvent e) {
    }

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
    }
}
