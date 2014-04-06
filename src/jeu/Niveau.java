package jeu;

public class Niveau {

    private int niveau=0;

    public Niveau() {
        this(0);
    }

    public Niveau(int niveau) {
        this.niveau=niveau;
    }

    public void addNiveau() {
        niveau++;
    }

    public void setNiveau(int niveau) {
        this.niveau=niveau;
    }

    public int getNiveau() {
        return niveau;
    }
}
