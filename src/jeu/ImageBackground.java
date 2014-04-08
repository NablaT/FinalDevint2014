package jeu;

import javax.swing.*;
import java.awt.*;

/**
 * Created by user on 07/04/14.
 */
public class ImageBackground extends JComponent {

    private Image image;

    public ImageBackground(Image image) {
        this.image = image;
    }
    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, null);
    }
}
