package jeu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by user on 04/04/14.
 */
public class IHMCarre extends JPanel implements ActionListener {

    private JButton answer1;
    private JButton answer2;
    private JButton answer3;
    private JButton answer4;
    private GridBagLayout grid;
    private GridBagConstraints gc;
    private String goodAnswer;
    private Game game;

    public IHMCarre(ArrayList<String> answers,String goodAnswer,Game g){
        this.game=g;
        this.initialize(answers);

        this.goodAnswer=goodAnswer;
    }

    public void initialize(ArrayList<String> answers){

        this.buildElements(answers);
        this.setLayout(grid);
        this.initializeGrid();
        this.setSize(300,300);
    }

    public void buildElements(ArrayList<String> answers){
        this.answer1= new JButton(answers.get(0));
        this.answer2= new JButton(answers.get(1));
        this.answer3= new JButton(answers.get(2));
        this.answer4= new JButton(answers.get(3));

        this.answer1.addActionListener(this);
        this.answer2.addActionListener(this);

        this.answer4.addActionListener(this);
        this.answer3.addActionListener(this);
        this.grid=new GridBagLayout();

        this.gc = new GridBagConstraints();
    }


    private void initializeGrid() {
        this.gc.fill=GridBagConstraints.BOTH;

        gc.insets = new Insets(5, 5, 5, 5);
        gc.weighty=2;

        gc.gridx=0;
        gc.gridy=0;

        this.add(this.answer1, gc);

        gc.gridx=1;
        gc.gridy=0;
        this.add(this.answer2, gc);

        gc.gridx=0;
        gc.gridy=1;
        this.add(this.answer3, gc);

        gc.gridx=1;
        gc.gridy=1;
        this.add(this.answer4, gc);
    }

    public String getGoodAnswer(){
        return this.goodAnswer;
    }

    public void clean(){
        this.removeAll();
        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source= e.getSource();
        JButton but= (JButton) source;
        if(!(but.getText().equals(this.goodAnswer))){
            this.clean();
            this.add(new WrongAnswer(this.goodAnswer,this.game));
            this.revalidate();
        }
        else{
            this.clean();
            this.add(new GoodAnswer(this.game));
            this.revalidate();
        }
    }
}
