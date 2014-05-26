package jeu;

import devintAPI.MenuAbstrait;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**.
 * Created by user on 07/04/14.
 *
 */
public class IHMPrincipal extends MenuAbstrait implements ActionListener, KeyListener {

    private Game game;
    private GridBagLayout grid;
    private GridBagConstraints gc;
    private File themePath;

    private int nextButton=-1;
    private int currentButton=-1;
    private int nbOfPoints;
    private GridLayout grid2;
    private boolean answerWasCorrect;
   // private ProgressBar progressBar;
    private int step;
    static long chrono = 0 ;

    public IHMPrincipal(String title, boolean answerWasCorrect, int step, int nbOfPoints){

        super(title);
        this.step=step;
        this.answerWasCorrect=answerWasCorrect;
        int save=this.nbOfPoints;
        chrono = java.lang.System.currentTimeMillis() ;
        this.nbOfPoints=nbOfPoints;
        String path= "..\\ressources\\\\image\\\\bg"+step+".jpg";
        this.setContentPane(new JLabel(new ImageIcon(path)));

       // this.progressBar=new ProgressBar(false);
        // this.progressBar.setLayout(new BorderLayout());
        this.build();
        //  this.progressBar.setSize(new Dimension(300,400));
        JButton[] but=new JButton[3];
        but[0]=(this.game.getAnswer().getDuo());
        but[1]=(this.game.getAnswer().getCarre());
        but[2]=(this.game.getAnswer().getHexa());

        super.setBoutonOption(but);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(1600,900);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    public IHMPrincipal(String title, boolean answerWasCorrect, int step, int nbOfPoints , File themePath){

        super(title);
        this.themePath=themePath;
        this.step=step;
        this.answerWasCorrect=answerWasCorrect;
        int save=this.nbOfPoints;

        this.nbOfPoints=nbOfPoints;
        String path= "..\\ressources\\\\image\\\\bg"+step+".jpg";
        this.setContentPane(new JLabel(new ImageIcon(path)));

        // this.progressBar=new ProgressBar(false);
        // this.progressBar.setLayout(new BorderLayout());
        this.build();
        //  this.progressBar.setSize(new Dimension(300,400));
        JButton[] but=new JButton[3];
        but[0]=(this.game.getAnswer().getDuo());
        but[1]=(this.game.getAnswer().getCarre());
        but[2]=(this.game.getAnswer().getHexa());

        super.setBoutonOption(but);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(1600,900);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    public void build(){
        this.game=new Game(this, this.nbOfPoints,false);
        this.game.setPreferredSize(new Dimension(950,600));
        this.grid=new GridBagLayout();
        //this.grid2=new GridLayout(6,8);

        System.out.println("LES POINTS "+this.nbOfPoints);
        this.setLayout(this.grid);
       // this.setLayout(new BorderLayout());
       // this.add(this.progressBar,BorderLayout.NORTH);
        //this.add(this.game, BorderLayout.CENTER);

        this.grid.location(500, 500);
        //  this.progressBar.setLocation(0, 250);
        this.gc=new GridBagConstraints();
        // this.grid.setConstraints(this.progressBar, gc);
        this.grid.setConstraints(this.game,this.gc);
        this.gc.fill=GridBagConstraints.REMAINDER;

        gc.insets = new Insets(5, 5, 5, 5);

        //  gc.gridx=4;
        //  gc.gridy=0;
        //   gc.gridwidth=15;
        //   gc.gridheight=5;

        // this.add(this.progressBar, gc);

        gc.gridx=4;
        gc.gridy=16;
        gc.gridwidth=2;
        gc.gridheight=2;

        this.add(this.game, gc);

    }

    public void maj(int NbOfPoints, boolean answerWasCorrect){
        this.remove(game);
        System.out.println("LES POINTS DANS LA MAJ"+this.nbOfPoints);
        this.game=new Game(this,NbOfPoints,answerWasCorrect);
        this.repaint();
        this.revalidate();
    }

    public int getStep(){
        return this.step;
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

    static long Stop_Chrono() {
        long chrono2 = java.lang.System.currentTimeMillis() ;
        long temps = chrono2 - chrono ;
        temps=temps/(1000);
        return temps;
    }

    public int getNbOfPoints(){
        return this.nbOfPoints;
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
