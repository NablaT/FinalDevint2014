    package jeu;

import javax.imageio.ImageIO;
import javax.swing.*;




import java.awt.AWTException;
import java.awt.Cursor;

import devintAPI.BoutonChoix;
import devintAPI.BoutonClasse2;
import devintAPI.BoutonClasse3;
import devintAPI.BoutonPlay;
import devintAPI.FenetreAbstraite;
import devintAPI.Preferences;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

/** Cette classe est un exemple d'interface de jeu.
 *  Elle �tend DevintFrame pour avoir un Frame et r�agir aux �v�nements claviers
 * Impl�mente ActionListener pour r�agir au clic souris sur le bouton.
 * On surchage la m�thode "keyPressed" pour associer une action � la touche F3
 *
 * @author helene
 *
 */

public class Jeu extends FenetreAbstraite implements ActionListener,KeyListener{

    Toolkit tk = Toolkit.getDefaultToolkit();
    Image img = tk.getImage("../ressources/images/cursor.png");
    Cursor monCurseur = tk.createCustomCursor(img, new Point(16, 16), "cursor");

    // Image d'arriere plan
    private Image background;
    private JLabel score;
    private JLabel menu;
    private JButton back;
    // Calcul des points
    private Points points;
    private JLabel labelpoints;
    private Niveau niveau;
    private JLabel labelniveau;
    private int combo;
    private JLabel labelcombo;

    private Robot robot;
    private int jouer=0;

    private JLabel instruction;
    private boolean win=false;

    private int source=0;

    // Bouton choix
    private JButton bouton1;
    private JButton bouton2=new JButton();
    private JButton bouton3=new JButton();
    private JButton bouton4=new JButton();
    private JButton bouton5=new JButton();
    private JButton bouton6=new JButton();

    private BoutonChoix bouton1l;
    private BoutonChoix bouton2l;
    private BoutonChoix bouton3l;
    private BoutonChoix bouton4l;

    private BoutonChoix answer1;
    private BoutonChoix answer2;
    private BoutonChoix answer3;
    private BoutonChoix answer4;
    private BoutonChoix answer5;
    private BoutonChoix answer6;

    private BoutonChoix duo;
    private BoutonChoix carre;
    private BoutonChoix hexa;

    // le bouton pour la question
    // est une variable d'instance car il doit �tre accessible
    // dans la m�thode actionPerformed
    private JButton question;

    // un label
    // est une variable d'instance car il doit �tre accessible
    // dans la m�thode changeColor, qui g�re les pr�f�rences
    private JTextArea lb1;

    // appel au constructeur de la classe m�re
    public Jeu(String title) {
        super(title);
    }

    // renvoie le fichier wave contenant le message d'accueil
    protected  String wavAccueil() {
        return "../ressources/sons/glados/presentationa.wav";
    }

    // renvoie le fichier wave contenant la r�gle du jeu
    protected  String wavRegleJeu() {
        return "../ressources/sons/glados/reglesa.wav";
    }

    // renvoie le fichier wave contenant la r�gle du jeu
    protected  String wavAide() {
        return "../ressources/sons/glados/reglesa.wav";
    }

    // d�finition de la m�thode abstraite "init()"
    // initialise le frame
    protected void init() {

        try {
            robot=new Robot();
        } catch (AWTException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        //IMAGE DE FOND
        background=Toolkit.getDefaultToolkit().getImage("../ressources/images/jeu.png");
        try{
            MediaTracker mt = new MediaTracker(this);
            mt.addImage(background,0);
            mt.waitForAll();
        }catch(Exception e){e.printStackTrace();}
        setContentPane(new ContentPane(background));
        setLayout(null);
        // back=new JButton();

        // Style d'ecriture
        Font fontgrand = new Font("Georgia",1,40);
        Font fontpetit = new Font("Georgia",1,25);
        Font fonttrespetit = new Font("Georgia",1,30);

        // Initialisation
        points=new Points();
        niveau=new Niveau();

        bouton1=new JButton("CHOIX 1");
        bouton2=new JButton("CHOIX 2");
        bouton3=new JButton("CHOIX 3");
        bouton1l= new BoutonChoix("Réponse 1");
        bouton2l=new BoutonChoix("Réponse 2");
        bouton3l=new BoutonChoix("Réponse 3");

        duo = new BoutonChoix("Duo");
        carre = new BoutonChoix("Carré");
        hexa = new BoutonChoix("Hexa");

        answer1 = new BoutonChoix("Réponse 1");
        answer2 = new BoutonChoix("Réponse 2");
        answer3 = new BoutonChoix("Réponse 3");
        answer4 = new BoutonChoix("Réponse 4");
        answer5 = new BoutonChoix("Réponse 5");
        answer6 = new BoutonChoix("Réponse 6");

        // LECTURE DU SON
        BoutonPlay jouerSon=new BoutonPlay("");
        jouerSon.setBounds(267,150,1066,220);
        jouerSon.setOpaque(false);
        jouerSon.setContentAreaFilled(false);
        jouerSon.setBorderPainted(false);
        //add(jouerSon);

        // BOUTON LIER
        jouerSon.addActionListener(new JouerSon());

        /**
         * Affichage des instruction
         */
        instruction=new JLabel("CLIQUER SUR LA BONNE REPONSE",JLabel.CENTER);
        instruction.setFont(fontgrand);
        instruction.setBounds(150,330,1000,400);
        add(instruction);

        /**
         * Affichage de la question :
         */
        JLabel question = new JLabel(("Question ici :"));
        question.setFont(fontgrand);
        question.setBounds(650,0,800,600);
        this.add(question);

        /**
         * Affichage du niveau
         */
        labelniveau=new JLabel("Niveau  : "+niveau.getNiveau());
        labelniveau.setFont(fontpetit);
        labelniveau.setBounds(1150,600,500,400);
        add(labelniveau);

        /**
         * Affichage des points
         */
        labelpoints=new JLabel("Points   : "+points.getPoints());
        labelpoints.setFont(fontpetit);
        labelpoints.setBounds(1150,410,500,400);
        add(labelpoints);

        /**
         * Bouton de choix ( duo / hexa .. )
         */
        duo.setBounds(475, 400, 170, 50);
        this.add(duo);
        duo.addActionListener(this);

        carre.setBounds(675, 400, 170, 50);
        this.add(carre);
        carre.addActionListener(this);

        hexa.setBounds(875, 400, 170, 50);
        this.add(hexa);
        hexa.addActionListener(this);
    }

    /**
     * This method create the two button for the duo mode.
     */
    private void duo() {

        this.remove(duo);
        this.remove(carre);
        this.remove(hexa);

        // BOUTON CHOIX 1
        answer1.setBounds(325,593,275,200);
        add(answer1);
        answer1.addActionListener(this);

        // BOUTON CHOIX 2
        answer2.setBounds(683,593,275,200);
        add(answer2);
        answer2.addActionListener(this);

        this.revalidate();
        this.repaint();
    }


    private void carre() {

        this.remove(duo);
        this.remove(carre);
        this.remove(hexa);

        // BOUTON CHOIX 1
        answer1.setBounds(275, 555, 275, 120);
        this.add(answer1);
        bouton1l.addActionListener(this);

        // BOUTON CHOIX 2
        answer2.setBounds(275, 693, 275, 120);
        add(answer2);
        answer2.addActionListener(this);

        // BOUTON CHOIX 3
        answer3.setBounds(690,555,275,120);
        add(answer3);
        answer3.addActionListener(this);

        // BOUTON CHOIX 4
        answer4.setBounds(690,693,275,120);
        add(answer4);
        answer4.addActionListener(this);

        this.revalidate();
        this.repaint();
    }


    private void hexa() {

        this.remove(duo);
        this.remove(carre);
        this.remove(hexa);

        // BOUTON CHOIX 1
        answer1.setBounds(175, 555, 275, 120);
        this.add(answer1);
        bouton1l.addActionListener(this);

        // BOUTON CHOIX 2
        answer2.setBounds(175, 693, 275, 120);
        add(answer2);
        answer2.addActionListener(this);

        // BOUTON CHOIX 3
        answer3.setBounds(490,555,275,120);
        add(answer3);
        answer3.addActionListener(this);

        // BOUTON CHOIX 4
        answer4.setBounds(490,693,275,120);
        add(answer4);
        answer4.addActionListener(this);

        // BOUTON CHOIX 5
        answer5.setBounds(790,555,275,120);
        add(answer5);
        answer5.addActionListener(this);

        // BOUTON CHOIX 6
        answer6.setBounds(790,693,275,120);
        add(answer6);
        answer6.addActionListener(this);

        this.revalidate();
        this.repaint();
    }


    // lire la question si clic sur le bouton
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("Duo")){
            duo();
        } else if(ae.getActionCommand().equals("Carré")) {
            carre();
        } else if (ae.getActionCommand().equals("Hexa")) {
            hexa();
        } else if(ae.getActionCommand().equals("Réponse 1") || ae.getActionCommand().equals("Réponse 2") || ae.getActionCommand().equals("Réponse 3") ||
                ae.getActionCommand().equals("Réponse 4") || ae.getActionCommand().equals("Réponse 5") || ae.getActionCommand().equals("Réponse 6")) {
            restart();
        }
    }

    /**
     * This method remove all the answer and add the button duo / carre / hexa :
     */
    private void restart() {
        this.remove(answer1);
        this.remove(answer2);
        this.remove(answer3);
        this.remove(answer4);
        this.remove(answer5);
        this.remove(answer6);

        this.add(duo);
        this.add(carre);
        this.add(hexa);

        this.revalidate();
        this.repaint();
    }


     /**
     * Pour modifier les couleurs de fond et de premier plan de la fen�tre
     * Cette fonction est appel�e par la fonction "changeColor" de la classe "Preferences"
     * � chaque fois que l'on presse F3
     *
     * on change la couleur du texte principal
     **/
    public  void changeColor() {
        // on r�cup�re les couleurs de base dans la classe Preferences
        Preferences pref = Preferences.getData();
        lb1.setBackground(pref.getCurrentBackgroundColor());
        lb1.setForeground(pref.getCurrentForegroundColor());
    }


    private class ContentPane extends JPanel{
        private Image image;
        public ContentPane(Image leFond){super();image=leFond;}
        public void paintComponent(Graphics g){g.drawImage(image,0,0,null);}
    }

    // Gere la reussite ou non de la question
    public void question() {
        voix.stop();
        if(niveau.getNiveau()==0) {
            if(source==2) {
                voix.playWav("../ressources/sons/glados/joke1a.wav");
                points.addPoints();
                win=true;
                instruction.setText("BONNE REPONSE ! NIVEAU SUIVANT !");
            } else if(source==1) {
                voix.playWav("../ressources/sons/glados/bad1a.wav");
                //bouton1l.setEnabled(false);
                //bouton1l.setChange("",new File("../ressources/images/BoutonN2.png"));
                instruction.setText("MAUVAISE REPONSE !");
                points.delPoints();
            } else if(source==3) {
                voix.playWav("../ressources/sons/glados/bad2a.wav");
                bouton3l.setEnabled(false);
                bouton3l.setChange("",new File("../ressources/images/BoutonN2.png"));
                instruction.setText("MAUVAISE REPONSE !");
                points.delPoints();
            }
        }
        if(niveau.getNiveau()==1) {
            if(source==1) {
                voix.playWav("../ressources/sons/glados/joke2a.wav");
                points.addPoints();
                win=true;
                instruction.setText("BONNE REPONSE ! NIVEAU SUIVANT !");
            } else if(source==2) {
                voix.playWav("../ressources/sons/glados/bad3a.wav");
                bouton2l.setEnabled(false);
                bouton2l.setChange("",new File("../ressources/images/BoutonN2.png"));
                instruction.setText("MAUVAISE REPONSE !");
                points.delPoints();
            } else if(source==3) {
                voix.playWav("../ressources/sons/glados/bad2a.wav");
                bouton3l.setEnabled(false);
                bouton3l.setChange("",new File("../ressources/images/BoutonN2.png"));
                instruction.setText("MAUVAISE REPONSE !");
                points.delPoints();
            }
        }
        if(niveau.getNiveau()==2) {
            if(source==3) {
                voix.playWav("../ressources/sons/glados/joke3a.wav");
                points.addPoints();
                win=true;
                instruction.setText("BONNE REPONSE ! NIVEAU SUIVANT !");
            } else if(source==2) {
                voix.playWav("../ressources/sons/glados/bad4a.wav");
                bouton2l.setEnabled(false);
                bouton2l.setChange("",new File("../ressources/images/BoutonN2.png"));
                instruction.setText("MAUVAISE REPONSE !");
                points.delPoints();
            } else if(source==1) {
                voix.playWav("../ressources/sons/glados/bad1a.wav");
                bouton1l.setEnabled(false);
                bouton1l.setChange("",new File("../ressources/images/BoutonN2.png"));
                instruction.setText("MAUVAISE REPONSE !");
                points.delPoints();
            }
        }
        if(niveau.getNiveau()==3) {
            if(source==3) {
                voix.playWav("../ressources/sons/glados/joke4a.wav");
                points.addPoints();
                win=true;
                instruction.setText("BONNE REPONSE ! NIVEAU SUIVANT !");
            } else if(source==2) {
                voix.playWav("../ressources/sons/glados/bad3a.wav");
                bouton2l.setEnabled(false);
                bouton2l.setChange("",new File("../ressources/images/BoutonN2.png"));
                instruction.setText("MAUVAISE REPONSE !");
                points.delPoints();
            } else if(source==1) {
                voix.playWav("../ressources/sons/glados/bad5a.wav");
                bouton1l.setEnabled(false);
                bouton1l.setChange("",new File("../ressources/images/BoutonN2.png"));
                instruction.setText("MAUVAISE REPONSE !");
                points.delPoints();
            }
        }
        if(niveau.getNiveau()==4) {
            if(source==2) {
                voix.playWav("../ressources/sons/glados/joke5a.wav");
                points.addPoints();
                win=true;
                instruction.setText("BONNE REPONSE ! NIVEAU SUIVANT !");
            } else if(source==1) {
                voix.playWav("../ressources/sons/glados/bad6a.wav");
                bouton1l.setEnabled(false);
                bouton1l.setChange("",new File("../ressources/images/BoutonN2.png"));
                instruction.setText("MAUVAISE REPONSE !");
                points.delPoints();
            } else if(source==3) {
                voix.playWav("../ressources/sons/glados/bad4a.wav");
                bouton3l.setEnabled(false);
                bouton3l.setChange("",new File("../ressources/images/BoutonN2.png"));
                instruction.setText("MAUVAISE REPONSE !");
                points.delPoints();
            }
        }
        if(niveau.getNiveau()==5) {
            if(source==3) {
                voix.playWav("../ressources/sons/glados/joke6a.wav");
                points.addPoints();
                win=true;
                instruction.setText("BONNE REPONSE ! NIVEAU SUIVANT !");
            } else if(source==1) {
                voix.playWav("../ressources/sons/glados/bad3a.wav");
                bouton1l.setEnabled(false);
                bouton1l.setChange("",new File("../ressources/images/BoutonN2.png"));
                instruction.setText("MAUVAISE REPONSE !");
                points.delPoints();
            } else if(source==2) {
                voix.playWav("../ressources/sons/glados/bad7a.wav");
                bouton2l.setEnabled(false);
                bouton2l.setChange("",new File("../ressources/images/BoutonN2.png"));
                instruction.setText("MAUVAISE REPONSE !");
                points.delPoints();
            }
        }
        if(niveau.getNiveau()==6) {
            if(source==1) {
                voix.playWav("../ressources/sons/glados/joke7a.wav");
                points.addPoints();
                win=true;
                instruction.setText("BONNE REPONSE ! NIVEAU SUIVANT !");
            } else if(source==2) {
                voix.playWav("../ressources/sons/glados/bad4a.wav");
                bouton2l.setEnabled(false);
                bouton2l.setChange("",new File("../ressources/images/BoutonN2.png"));
                instruction.setText("MAUVAISE REPONSE !");
                points.delPoints();
            } else if(source==3) {
                voix.playWav("../ressources/sons/glados/bad2a.wav");
                bouton3l.setEnabled(false);
                bouton3l.setChange("",new File("../ressources/images/BoutonN2.png"));
                instruction.setText("MAUVAISE REPONSE !");
                points.delPoints();
            }
        }
        if(niveau.getNiveau()==7) {
            if(source==3) {
                voix.playWav("../ressources/sons/glados/joke1a.wav");
                points.addPoints();
                win=true;
                instruction.setText("BONNE REPONSE ! NIVEAU SUIVANT !");
            } else if(source==2) {
                voix.playWav("../ressources/sons/glados/bad1a.wav");
                bouton2l.setEnabled(false);
                bouton2l.setChange("",new File("../ressources/images/BoutonN2.png"));
                instruction.setText("MAUVAISE REPONSE !");
                points.delPoints();
            } else if(source==1) {
                voix.playWav("../ressources/sons/glados/bad6a.wav");
                bouton1l.setEnabled(false);
                bouton1l.setChange("",new File("../ressources/images/BoutonN2.png"));
                instruction.setText("MAUVAISE REPONSE !");
                points.delPoints();
            }
        }
        if(niveau.getNiveau()==8) {
            if(source==2) {
                voix.playWav("../ressources/sons/glados/joke4a.wav");
                points.addPoints();
                win=true;
                instruction.setText("BONNE REPONSE ! NIVEAU SUIVANT !");
            } else if(source==1) {
                voix.playWav("../ressources/sons/glados/bad2a.wav");
                bouton1l.setEnabled(false);
                bouton1l.setChange("",new File("../ressources/images/BoutonN2.png"));
                instruction.setText("MAUVAISE REPONSE !");
                points.delPoints();
            } else if(source==3) {
                voix.playWav("../ressources/sons/glados/bad7a.wav");
                bouton3l.setEnabled(false);
                bouton3l.setChange("",new File("../ressources/images/BoutonN2.png"));
                instruction.setText("MAUVAISE REPONSE !");
                points.delPoints();
            }
        }
        if(win) {
            niveau.addNiveau();
            bouton1l.setEnabled(false);
            bouton2l.setEnabled(false);
            bouton3l.setEnabled(false);
            newQuestion();
            requestFocus();
            win=false;
        }
        labelpoints.setText("Points : "+points.getPoints());
    }

    public void newQuestion() {
        // Image des instruments


        if(niveau.getNiveau()==1) {
            bouton1l.setChange("trompette",new File("../ressources/images/trompette.png")); //Bonne reponse
            bouton2l.setChange("violon",new File("../ressources/images/violon.png"));
            bouton3l.setChange("saxophone",new File("../ressources/images/saxophone.png"));
        }
        if(niveau.getNiveau()==2) {
            bouton1l.setChange("accordeon",new File("../ressources/images/accordeon.png"));
            bouton2l.setChange("saxophone",new File("../ressources/images/saxophone.png"));
            bouton3l.setChange("cornemuse",new File("../ressources/images/cornemuse.png"));
        }
        if(niveau.getNiveau()==3) {
            bouton1l.setChange("ocarina",new File("../ressources/images/ocarina.png"));
            bouton2l.setChange("batterie",new File("../ressources/images/batterie.png"));
            bouton3l.setChange("djridou",new File("../ressources/images/djridou.png"));
        }
        if(niveau.getNiveau()==4) {
            bouton1l.setChange("flute",new File("../ressources/images/flute.png"));
            bouton2l.setChange("harmonica",new File("../ressources/images/harmonica.png"));
            bouton3l.setChange("maracasse",new File("../ressources/images/maracasse.png"));
        }
        if(niveau.getNiveau()==5) {
            bouton1l.setChange("guitare",new File("../ressources/images/guitare.png"));
            bouton2l.setChange("triangle",new File("../ressources/images/triangle.png"));
            bouton3l.setChange("piano",new File("../ressources/images/piano.png"));
        }
        if(niveau.getNiveau()==6) {
            bouton1l.setChange("orgue",new File("../ressources/images/orgue.png")); //BOnne reponse
            bouton2l.setChange("accordeon",new File("../ressources/images/accordeon.png"));
            bouton3l.setChange("sifflet",new File("../ressources/images/sifflet.png"));
        }
        if(niveau.getNiveau()==7) {
            bouton1l.setChange("cornemuse",new File("../ressources/images/cornemuse.png"));
            bouton2l.setChange("harmonica",new File("../ressources/images/harmonica.png"));
            bouton3l.setChange("triangle",new File("../ressources/images/triangle.png"));
        }
        if(niveau.getNiveau()==8) {
            bouton1l.setChange("orgue",new File("../ressources/images/orgue.png"));
            bouton2l.setChange("ocarina",new File("../ressources/images/ocarina.png"));
            bouton3l.setChange("harpe",new File("../ressources/images/harpe.png"));
        }
        if(niveau.getNiveau()==9) {
            niveau.setNiveau(0);
            bouton1l.setChange("harpe",new File("../ressources/images/harpe.png"));
            bouton2l.setChange("tambour",new File("../ressources/images/tambour.png"));
            bouton3l.setChange("guitare",new File("../ressources/images/guitare.png"));
            instruction.setText("BRAVO VOUS AVEZ FINI LE JEU");
        }
        labelpoints.setText("Points : "+points.getPoints());
        labelniveau.setText("Niveau : "+niveau.getNiveau());
        bouton1l.setEnabled(true);
        bouton2l.setEnabled(true);
        bouton3l.setEnabled(true);
        jouer=0;
    }

    class JouerSon implements ActionListener{
        public void actionPerformed(ActionEvent arg0){
            voix.stop();
            jouer=1;
            instruction.setText("CLIQUER SUR UN DES INSTRUMENTS");
            if(niveau.getNiveau()==0){
                voix.playWav("../ressources/sons/sons/tambour.wav");
            }
            if(niveau.getNiveau()==1) {
                voix.playWav("../ressources/sons/sons/trompette.wav");
            }
            if(niveau.getNiveau()==2) {
                voix.playWav("../ressources/sons/sons/cornemuse.wav");
            }
            if(niveau.getNiveau()==3) {
                voix.playWav("../ressources/sons/sons/djridou.wav");
            }
            if(niveau.getNiveau()==4) {
                voix.playWav("../ressources/sons/sons/harmonica.wav");
            }
            if(niveau.getNiveau()==5) {
                voix.playWav("../ressources/sons/sons/piano.wav");
            }
            if(niveau.getNiveau()==6) {
                voix.playWav("../ressources/sons/sons/orgue.wav");
            }
            if(niveau.getNiveau()==7) {
                voix.playWav("../ressources/sons/sons/triangle.wav");
            }
            if(niveau.getNiveau()==8) {
                voix.playWav("../ressources/sons/sons/ocarina.wav");
            }
            requestFocus();
        }
    }

    class bouton1 implements ActionListener{
        public void actionPerformed(ActionEvent arg0){
            source=1;
            voix.stop();
            question();
        }
    }


    public void mettreTimer(int timer) {
        Timer timer1 = new Timer();
        timer1.start();
        while (timer1.isAlive()) {
            // faire un traitement...
            try {
                // et faire une pause
                timer1.sleep(timer);
            } catch (InterruptedException ex) {
            }
        }
    }

    // Permet de mettre un timer
    //mettreTimer(2000);
    //permet d'ouvrir une nouvelle fenetre
    //new UneImage("aze");
}
