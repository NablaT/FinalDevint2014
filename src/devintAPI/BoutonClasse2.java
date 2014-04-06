package devintAPI;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;

public class BoutonClasse2 extends JButton implements MouseListener{
    private String name;
    private Image img;
    private int lg=0;

    public BoutonClasse2(String str){
        super(str);
        this.name = str;
        for(int i=0; i<name.length();i++)
        {
            lg=14+lg;
        }
        try {
            img = ImageIO.read(new File("../ressources/images/boutonClean2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.addMouseListener(this);
    }

    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        GradientPaint gp = new GradientPaint(0, 0, Color.blue, 0, 20, Color.cyan, true);
        g2d.setPaint(gp);
        g2d.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
        g2d.setColor(Color.black);
        //g2d.drawString(this.name, this.getWidth() / 2 - (this.getWidth() / 2 /4), (this.getHeight() / 2) + 5);
        g2d.setFont(new Font("Georgia",1,50));
        //FontMetrics font= g2d.getFontMetrics();
        g2d.drawString(this.name, this.getWidth()/2 - lg , (this.getHeight() / 2) + 10);
    }

    public void mouseClicked(MouseEvent event) {
        //Inutile d'utiliser cette m�thode ici
    }

    public void mouseEntered(MouseEvent event) {
        //Nous changeons le fond de notre image pour le jaune lors du survol, avec le fichier fondBoutonHover.png
        try {
            img = ImageIO.read(new File("../ressources/images/boutonSurvol2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mouseExited(MouseEvent event) {
        //Nous changeons le fond de notre image pour le vert lorsque nous quittons le bouton, avec le fichier fondBouton.png
        try {
            img = ImageIO.read(new File("../ressources/images/boutonClean2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mousePressed(MouseEvent event) {
        //Nous changeons le fond de notre image pour le jaune lors du clic gauche, avec le fichier fondBoutonClic.png
        try {
            img = ImageIO.read(new File("../ressources/images/boutonSurvol2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mouseReleased(MouseEvent event) {
        //Nous changeons le fond de notre image pour le orange lorsque nous rel�chons le clic, avec le fichier fondBoutonHover.png
        try {
            img = ImageIO.read(new File("../ressources/images/boutonClean2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}