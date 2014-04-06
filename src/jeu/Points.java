package jeu;

public class Points {
    private int points=0;

    public Points() {
        this(0);
    }

    public Points(int points) {
        this.points=points;
    }

    public int getPoints() {
        return points;
    }

    public void addPoints() {
        points++;
    }

    public void delPoints() {
        points--;
    }
}
