import javax.swing.JFrame;
import javax.swing.WindowConstants;


/**
 * MainMethod
 */
public class Main {
    public static void main(String[] args) {
        StartMenu mainFrame = new StartMenu();
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainFrame.setLocationRelativeTo(null);

        mainFrame.setResizable(true);

        mainFrame.setTitle("Gaia");
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}


//TODO: randomiser, um zwischen verschiedenen Steinen zu wählen
//TODO: EndScreen: IMG für den jeweiligen Gewinner
//TODO: JavaDoc Kommentare erweitern
//TODO: TerrainGen fixen!!!!!