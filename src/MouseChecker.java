import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseChecker implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
        int offset = MainFrame.panel.cameraX;


        if (e.getButton() == MouseEvent.BUTTON1) {
            float x = (e.getX() - offset) / 50;
            int xPos = ((int) x) * 50;
            float y = e.getY() / 50;
            int yPos = ((int) y) * 50;
            MainFrame.panel.walls.add(new Wall(xPos, yPos, MainFrame.panel.s, MainFrame.panel.s, MainFrame.panel.stone));
            System.out.println("M1");
            Gaia.socketConnection.send("test");
            System.out.println("M2");
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
