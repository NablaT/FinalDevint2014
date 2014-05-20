package jeu;

import javax.swing.*;
import java.awt.*;

/**
 * Created by REMI on 12/05/14.
 */
public class ImageProgressBar extends JPanel {

    private Image image;
    private int step;
    private int width;

    public ImageProgressBar(int step){
        //this.setSize(50, 500);
        this.step=step;
        this.giveMeGoodImage();
        this.setLayout(new BorderLayout());

    }

    private void giveMeGoodImage() {
        //String path="..\\ressources\\\\image\\\\load"+this.step+".jpg";
        /*String path="..\\ressources\\\\image\\\\loading.png"; //+this.step+".jpg";
        this.image=new ImageIcon(path).getImage();
        this.width=this.getHeight();
        System.out.println("HAUTEUR :"+this.width);*/
        this.setBackground(Color.CYAN);
    }



}
