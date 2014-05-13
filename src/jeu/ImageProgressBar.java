package jeu;

import javax.swing.*;
import java.awt.*;

/**
 * Created by REMI on 12/05/14.
 */
public class ImageProgressBar extends JPanel {

    private Image image;
    private int step;

    public ImageProgressBar(int step){
        this.setSize(500, 500);
        this.step=step;
        this.giveMeGoodImage();

    }

    private void giveMeGoodImage() {
        String path="..\\ressources\\\\image\\\\load"+this.step+".jpg";
        this.image=new ImageIcon(path).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, image.getWidth(null), image.getHeight(null), null);
    }

}
