package jeu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by user on 07/04/14.
 */
public class IHMPrincipal extends JFrame implements ActionListener {

    private Game game;
    private GridBagLayout grid;
    private GridBagConstraints gc;

    private ImageBackground background;


    public IHMPrincipal(String title){

        super(title);

           // BufferedImage img=ImageIO.read(new File("ressources\\image\\ardoise.png"));
            //this.setContentPane(new ImageBackground(img));

       this.setContentPane(new JLabel(new ImageIcon("ressources\\\\image\\\\background.jpg")));


        this.build();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setPreferredSize(new Dimension(1600,900));
        this.setSize(1600,900);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void build(){
        this.game=new Game("Quizz");
        this.game.setPreferredSize(new Dimension(700,400));
        this.grid=new GridBagLayout();
        this.grid.location(500,500);
        this.gc=new GridBagConstraints();

        this.gc.gridheight=10;
        this.gc.gridwidth=10;
       // this.setLayout(this.grid);


       // this.gc.fill=GridBagConstraints.NONE;


        gc.insets = new Insets(5, 5, 5, 5);
        gc.weightx=10;
        gc.weighty=10;
        gc.gridx=4;
        gc.gridy=4;

        this.setLayout(this.grid);
        this.add(this.game, gc);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
