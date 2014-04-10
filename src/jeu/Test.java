package jeu;

import javax.swing.*;
import java.awt.*;

/**
 * Created by user on 07/04/14.
 */
public class Test extends JFrame {
        private Image fond;
        public Test(){
            super("Test");
            fond = Toolkit.getDefaultToolkit().getImage("resources\\image\\japon.jpg");
            try{
                System.out.println("dans le try");
                MediaTracker mt = new MediaTracker(this);
                mt.addImage(fond,0);
                mt.waitForAll();
            }catch(Exception e){
                System.out.println("pb");
                e.printStackTrace();}
            setContentPane(new ContentPane(fond));
            getContentPane().add(new JLabel("Bonjour"));
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(400,400);setLocationRelativeTo(null);setVisible(true);
        }
        private class ContentPane extends JPanel{
            private Image image;
            public ContentPane(Image leFond){super();image=leFond;}
            public void paintComponent(Graphics g){g.drawImage(image,0,0,null);}
        }
        public static void main(String[] args){new Test();}

}
