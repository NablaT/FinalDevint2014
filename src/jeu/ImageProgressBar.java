package jeu;

import javax.swing.*;
import java.awt.*;

/**
 * Created by REMI on 12/05/14.
 */
public class ImageProgressBar extends JPanel {

    private Image image;

    public ImageProgressBar(){
        this.setSize(500, 500);

        this.image=new ImageIcon("..\\ressources\\\\image\\\\loading.jpg").getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, image.getWidth(null), image.getHeight(null), null);
    }

}
