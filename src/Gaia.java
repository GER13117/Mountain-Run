import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Gaia {
    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.setSize(1920, 1080);
        frame.setLocationRelativeTo(null);


        frame.setResizable(true);

        frame.setTitle("Gaia");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}


//TODO: Texturen und Animationen
//TODO: weitere Blöcke / Materialien hinzufügen
//TODO: Terrain: Verschiedene Gelände länge minimum 40 blöcke
//TODO: Fix Movement der Spieler
//TODO: Schlagen, bauen
//TODO: Gegner
//TODO: Waterblock

//TODO: Warum werden immer mehr Blöcke gespeichert