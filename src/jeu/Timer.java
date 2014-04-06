package jeu;

public class Timer extends Thread {
    public void run() {
        long start = System.currentTimeMillis();
        // boucle tant que la dur�e de vie du thread est < � 5 secondes
        while (System.currentTimeMillis() < (start + (1000 * 5))) {
            // traitement
            System.out.println("Ligne affich�e par le thread");
            try {
                // pause
                Thread.sleep(500);
            } catch (InterruptedException ex) {
            }
        }
    }
}
