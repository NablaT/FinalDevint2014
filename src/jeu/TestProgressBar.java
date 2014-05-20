package jeu;

import javax.swing.*;
import java.awt.*;

/**
 * Created by REMI on 17/05/14.
 */
public class TestProgressBar extends JFrame{
    private ProgressBar progressBar;

    public TestProgressBar(){
        progressBar=new ProgressBar(false);
        this.progressBar.setLayout(new BorderLayout());
        this.add(progressBar, BorderLayout.CENTER);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(1600,900);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args){
        TestProgressBar t=new TestProgressBar();
    }
}
