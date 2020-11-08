import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class PlayerPvP {

    int x;
    int y;
    GamePanelPvP panel;
    int width;
    int height;
    //Velocities of the player
    double xspeed;
    double yspeed;

    Rectangle hitBox;

    //Keys
    boolean keyLeft;
    boolean keyRight;
    boolean keyUp;
    boolean keyDown;

    public PlayerPvP(int x, int y, GamePanelPvP panel) {

        this.panel = panel;
        this.x = x;
        this.y = y;

        width = 50;
        height = 100;
        hitBox = new Rectangle(x, y, width, height);
    }

    public void set() {

        //Bedingungen und einschränkungen vertikal
        if (keyLeft && keyRight || !keyLeft && !keyRight) {
            xspeed *= 0.8;
        } else if (keyLeft && !keyRight) {
            xspeed--;
        } else if (keyRight && !keyLeft) {
            xspeed++;
        }
        if (xspeed > 0 && xspeed < 0.75) {
            xspeed = 0;
        }
        if (xspeed < 0 && xspeed > -0.75) {
            xspeed = 0;
        }

        if (xspeed > 7) {
            xspeed = 7;
        }
        if (xspeed < -7) {
            xspeed = -7;
        }

        //Gravitation und un Kollision
        if (keyUp) {


            //check if touching ground
            hitBox.y++;
            for (Wall wall : panel.walls) {
                if (wall.hitBox.intersects(hitBox)) {
                    yspeed = -11;//deaktiviert fliegen
                }
            }
            hitBox.y--;
        }

        yspeed += 0.5;

        //horizontale Kolllision
        hitBox.x += xspeed;
        for (Wall wall : panel.walls) {
            if (hitBox.intersects(wall.hitBox)) {
                hitBox.x -= xspeed;
                while (!wall.hitBox.intersects(hitBox)) {
                    hitBox.x += Math.signum(xspeed);//TODO: Googlen wie signum funktioniert
                }
                hitBox.x -= Math.signum(xspeed);
                xspeed = 0;
                x = hitBox.x;
            }

        }
        //vertikale Kollision
        hitBox.y += yspeed;
        for (Wall wall : panel.walls) {
            if (hitBox.intersects(wall.hitBox)) {//Horizontal
                hitBox.y -= yspeed;
                while (!wall.hitBox.intersects(hitBox)) {
                    hitBox.y += Math.signum(yspeed);
                }
                hitBox.y -= Math.signum(yspeed);
                yspeed = 0;
                y = hitBox.y;
            }

        }


        x += xspeed;
        y += yspeed;

        //Death Code
        if (panel.player.y > 1500) panel.reset1();
        if (panel.player2.y > 1500) panel.reset2();

        //bewegt die Hitbox mit dem Spieler
        hitBox.x = x;
        hitBox.y = y;
    }

    //Platzhalter für animierten Charakter
    public void draw(Graphics2D gtd) {

        gtd.setColor(Color.BLACK);
        gtd.fillRect(x, y, width, height);
    }
}