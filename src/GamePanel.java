import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class GamePanel extends JPanel implements ActionListener {
    Player player;
    Timer gameTimer;
    ImprovedNoise improvedNoise;

    //Biomes biomes;
    ArrayList<Wall> walls = new ArrayList<>();
    //Variablen zum Definieren der Kamerposition
    int cameraX;
    int cameraY;
    int offset;
    int s = 50;

    // gerundete Fenstergröße für vereinfachte verwendung
    int windowHeight = 1100;//1100, da bei 1080 immer 20 px verschiebung war
    int windowWidth = 1920;
    int bottomRow = windowHeight - 100;

    //Import Images for the different solids
    String imageWall = "res/textures/gras.png"; //Placeholder
    String imageStone = "res/textures/stone.png"; //Placeholder


    public GamePanel(){
        music();
        //einfügen des Spieler-Objekts
        player = new Player(400,300,this);

        reset1();

        //Timer um Spiel laufen zu lassen.
        gameTimer = new Timer();
        gameTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                player.set();
                //zeichnet walls wenn sie  kurz davor sind ins sichtfeld zu kommen
                if(walls.get(walls.size() - 1).x < (windowWidth + 100) ){
                    offset += windowWidth;
                    makeWalls(offset);
                    //System.out.println(walls.size()); //prints the amount of generated walls

                }
                for( Wall wall: walls){
                    wall.set(cameraX, cameraY);
                }
                //entfernt walls außerhalb des Bildschirms
                for(int i = 0; i<walls.size(); i++){
                    if(walls.get(i).x < -windowWidth){
                        walls.remove(i);
                    }
                }

                repaint();

            }
        }, 0, 17);


    }

    public void reset1(){
        player.x = 300;
        player.y = 150;
        cameraX = 150;
        cameraY = 500;
        player.xspeed = 0;
        player.yspeed = 0;
        walls.clear();
        offset = -150;
        makeWalls(offset);
    }


    public void makeWalls(int offset) {
        improvedNoise = new ImprovedNoise();

        Random rand = new Random();
        int index = rand.nextInt(2);
        System.out.println(index);
        //biomes = new Biomes();


        switch (index){
            case 0:
                for(int i=0; i<40; i++) {
                    walls.add(new Wall((offset + i*50), bottomRow, s, s, imageStone));
                }
                walls.add(new Wall((offset+ 3*50), (bottomRow-150), s, s, imageWall));
            break;
            case 1:
                //biomes.Mountain1();

                //BottomLayer Texture: Stone
                for(int i=0; i<40; i++) {
                    walls.add(new Wall((offset + i*50), bottomRow, s, s, imageStone));
                }
                //Grass or dirt
                for(int i=2; i<= 4; i++) walls.add(new Wall((offset+ i*50), bottomRow-50, s, s, imageWall));
                walls.add(new Wall((offset+ 4*50), (bottomRow-100), s, s, imageWall));
                for(int i=4; i<= 6; i++) walls.add(new Wall((offset+ i*50), bottomRow-150, s, s, imageWall));
                for(int i=6; i<= 9; i++) walls.add(new Wall((offset+ i*50), bottomRow-100, s, s, imageWall));
                walls.add(new Wall((offset+ 9*50), bottomRow-150, s, s, imageWall));
                for(int i=9; i<= 11; i++) walls.add(new Wall((offset+ i*50), bottomRow-200, s, s, imageWall));
                for(int i=11; i<= 13; i++) walls.add(new Wall((offset+ i*50), bottomRow-250, s, s, imageWall));
                for(int i=14; i<= 15; i++) walls.add(new Wall((offset+ i*50), bottomRow-300, s, s, imageWall));
                for(int i=15; i<= 19; i++) walls.add(new Wall((offset+ i*50), bottomRow-350, s, s, imageWall));
                for(int i=15; i<= 16; i++) walls.add(new Wall((offset+ i*50), bottomRow-400, s, s, imageWall));
                for(int i=19; i<= 23; i++) walls.add(new Wall((offset+ i*50), bottomRow-500, s, s, imageWall));
                for(int i=21; i<= 22; i++) walls.add(new Wall((offset+ i*50), bottomRow-550, s, s, imageWall));
                for(int i=22; i<= 23; i++) walls.add(new Wall((offset+ i*50), bottomRow-500, s, s, imageWall));
                for(int i=23; i<= 26; i++) walls.add(new Wall((offset+ i*50), bottomRow-450, s, s, imageWall));
                walls.add(new Wall((offset+ 27*50), bottomRow-400, s, s, imageWall));
                for(int i=27; i<= 28; i++) walls.add(new Wall((offset+ i*50), bottomRow-350, s, s, imageWall));
                for(int i=28; i<= 29; i++) walls.add(new Wall((offset+ i*50), bottomRow-300, s, s, imageWall));
                for(int i=29; i<= 30; i++) walls.add(new Wall((offset+ i*50), bottomRow-250, s, s, imageWall));
                for(int i=30; i<= 36; i++) walls.add(new Wall((offset+ i*50), bottomRow-200, s, s, imageWall));
                for(int i=33; i<= 34; i++) walls.add(new Wall((offset+ i*50), bottomRow-250, s, s, imageWall));
                walls.add(new Wall((offset+ 36*50), bottomRow-150, s, s, imageWall));
                for(int i=36; i<= 39; i++) walls.add(new Wall((offset+ i*50), bottomRow-100, s, s, imageWall));
                walls.add(new Wall((offset+ 39*50), bottomRow-50, s, s, imageWall));
                walls.add(new Wall((offset+ 14*50), bottomRow-250, s, s, imageWall));
                walls.add(new Wall((offset+ 26*50), bottomRow-400, s, s, imageWall));

                //Stone
                for(int i=4; i<= 8; i++) walls.add(new Wall((offset+ i*50), bottomRow-50, s, s, imageStone));
                for(int i=15; i<= 38; i++) walls.add(new Wall((offset+ i*50), bottomRow-50, s, s, imageStone));
                walls.add(new Wall((offset+ 5*50), bottomRow-100, s, s, imageStone));
                for(int i=16; i<= 19; i++) walls.add(new Wall((offset+ i*50), bottomRow-100, s, s, imageStone));
                for(int i=24; i<= 35; i++) walls.add(new Wall((offset+ i*50), bottomRow-100, s, s, imageStone));
                for(int i=17; i<= 18; i++) walls.add(new Wall((offset+ i*50), bottomRow-150, s, s, imageStone));
                for(int i=26; i<= 35; i++) walls.add(new Wall((offset+ i*50), bottomRow-150, s, s, imageStone));
                walls.add(new Wall((offset+ 21*50), bottomRow-200, s, s, imageStone));
                for(int i=27; i<= 29; i++) walls.add(new Wall((offset+ i*50), bottomRow-200, s, s, imageStone));
                for(int i=21; i<= 24; i++) walls.add(new Wall((offset+ i*50), bottomRow-250, s, s, imageStone));
                for(int i=27; i<= 28; i++) walls.add(new Wall((offset+ i*50), bottomRow-250, s, s, imageStone));
                for(int i=16; i<= 21; i++) walls.add(new Wall((offset+ i*50), bottomRow-300, s, s, imageStone));
                walls.add(new Wall((offset+ 20*50), bottomRow-350, s, s, imageStone));
                break;
            /*case 0:
                for (double i = 0; i < 40; i+= 0.02){
                    double terrainHeight = improvedNoise.noise(i) * 100;
                    int rTerrainHeight = ((int) terrainHeight)*25;
                    walls.add(new Wall((int)(offset + (i*50*50)), bottomRow- rTerrainHeight,s,s, imageWall));
                    System.out.println(rTerrainHeight);
                }
                break;*/
            default:
                for(int i=0; i<40; i++) {
                    walls.add(new Wall((offset + i*50), bottomRow, s, s, imageWall));
                }

        }
        /*
        //Altes Test Terrain
        for(int i = 50; i < windowWidth-50; i += 50){
            walls.add(new Wall(i, windowHeight-80, 50, 50));

        }

        //Left endwall
        walls.add(new Wall(50, bottomRow-50, 50, 50));

        //middle walls from left to right
        walls.add(new Wall(450, bottomRow-50, 50, 50));

        walls.add(new Wall(600, bottomRow-100, 50, 50));
        walls.add(new Wall(600, bottomRow-50, 50, 50));

        walls.add(new Wall(650, bottomRow-50, s, s));
        walls.add(new Wall(650, bottomRow-100, s, s));
        walls.add(new Wall(650, bottomRow-150, s, s));

        walls.add(new Wall(700, bottomRow-100, 50, 50));
        walls.add(new Wall(700, bottomRow-50, 50, 50));

        walls.add(new Wall(750, bottomRow-50, 50, 50));


        //right endwall
        walls.add(new Wall(1850, bottomRow-100, s, s ));
        walls.add(new Wall(1850, bottomRow-50, s, s ));
        */
    }

    public void paint(Graphics g){
        super.paint(g);

        Graphics2D gtd = (Graphics2D) g;
        player.draw(gtd);

        for(Wall wall: walls){
            wall.draw(gtd);
        }
    }




    public void keyPressed(KeyEvent e) {
        //movement player 1
        if(e.getKeyChar() == 'a') player.keyLeft = true;
        if(e.getKeyChar() == 'd') player.keyRight = true;
        if(e.getKeyChar() == 'w') player.keyUp = true;

        //respawn
        if(e.getKeyChar() == 'r') reset1();

    }

    public void keyReleased(KeyEvent e) {
        //stop movement player1
        if(e.getKeyChar() == 'a') player.keyLeft = false;
        if(e.getKeyChar() == 'd') player.keyRight = false;
        if(e.getKeyChar() == 'w') player.keyUp = false;

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
    }
    public static void music(){
        Random rand = new Random();
        int index = rand.nextInt(3);
        String filepath;
        switch (index){
            case 0:
                filepath = "res/Music/far-from-the-world.mp3";
                break;
            case 1:
                filepath = "res/Music/impavid.mp3";
                break;
            case 2:
                filepath = "res/Music/mountains.mp3";
                break;
            default:
                filepath = "Music/song1.wav"; //Einfach irgendein Path es wird so oder so ein error geschmissen
        }

        MusicStuff musicObject;
        musicObject = new MusicStuff();
        musicObject.playMusic(filepath);
    }


}
