package jeu;

import javax.swing.*;
import java.awt.*;

/**
 * Created by user on 16/05/2014.
 */
public class TestFrame extends JFrame{


    private ProgressBar progressBar;

    public  TestFrame(){
        this.progressBar=new ProgressBar(false);
        this.add(this.progressBar, BorderLayout.CENTER);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(1600,900);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
