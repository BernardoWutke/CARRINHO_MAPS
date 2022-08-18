package main;

import buttons.Buttons;
import entity.Player;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel  extends JPanel implements Runnable {
    // SCREEN SETTINGS
    public final int originalTileSize = 16; //16x16 tile
    public final int scale = 2;
    public final int tileSize = originalTileSize * scale;
    

    public int getTileSize() {
        return tileSize;
    }

    public final int maxSCreenCol = 17;
    public final int maxScreenRow = 18;
    public final int screenWidth = tileSize * maxSCreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    private  String mapPath = "/res/maps/map02.txt";
    TileManager tileM = new TileManager(this);
    
    public String getMapPath() {
        //tileM.loadMap(mapPath);
        return mapPath;
    }
    public void setMapPath(String mapPath) {
        this.mapPath = mapPath;
        tileM.loadMap(mapPath);
    }

    public void loadMaps() {
        tileM.loadMap(mapPath);
    }

    // WORLD SETTINGS
    public final int maxWorldCol = 17;
    public final int maxWorldRow = 17;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;


    MouseInput MouseInput = new MouseInput();
    Thread gameThread;

    Buttons buttons = new Buttons(MouseInput, this);
    
    Player player = new Player(this, MouseInput,buttons);

    public Player getPlayer() {
        return player;
    }
   
    // GAME SETTINGS
    private int fps = 60;

    // Set player position default
    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.GRAY);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.addMouseListener(MouseInput);
        this.addMouseMotionListener(MouseInput);
    }
    public void startGameThread(){

        gameThread = new Thread(this);
        gameThread.start();
    }

    public void run() {
        int intervalDefalt = 1000000000;
        double drawInterval = 1000000000 / fps;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        start();

        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += currentTime - lastTime;
            
            lastTime = currentTime;

            if(delta >= 1){
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if(timer >= intervalDefalt){
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
                tileM.loadMap(mapPath);
            }
        }
    }

    public void start(){
        player.update();
        player.decodificarRota(0,0);
    }

    public  void update() {
        player.vereficarMovimento();
        player.update();
        buttons.update();
        MouseInput.clearMouse();
    }

    public  void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        tileM.draw(g2);
        buttons.draw(g2);
        player.draw(g2);
        g2.dispose();
    }

}
