package tile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import java.awt.*;


import main.GamePanel;

public class TileManager {
    private GamePanel gp;
    private Tile[] tile;
    private int mapTileNum[][];

    public TileManager(GamePanel gp){
        this.gp = gp;
        tile = new Tile[20];
        mapTileNum = new int[gp.maxWorldCol][gp.maxScreenRow];
        getTileImage();
        loadMap(gp.getMapPath());
    }

    public void getTileImage(){
        try{

            tile[1] = new Tile();
            tile[1].setTileImage(ImageIO.read(getClass().getResourceAsStream("/res/assets/ground/ground_left_up.png")));
            
            tile[2] = new Tile();
            tile[2].setTileImage(ImageIO.read(getClass().getResourceAsStream("/res/assets/ground/ground_up.png")));
            
            tile[3] = new Tile();
            tile[3].setTileImage(ImageIO.read(getClass().getResourceAsStream("/res/assets/ground/ground_right_up.png")));
            
            tile[4] = new Tile();
            tile[4].setTileImage(ImageIO.read(getClass().getResourceAsStream("/res/assets/ground/ground_left.png")));

            tile[5] = new Tile();
            tile[5].setTileImage(ImageIO.read(getClass().getResourceAsStream("/res/assets/ground/ground_center.png")));
            
            tile[6] = new Tile();
            tile[6].setTileImage(ImageIO.read(getClass().getResourceAsStream("/res/assets/ground/ground_right.png")));
            
            tile[7] = new Tile();
            tile[7].setTileImage(ImageIO.read(getClass().getResourceAsStream("/res/assets/ground/ground_left_down.png")));

            tile[8] = new Tile();
            tile[8].setTileImage(ImageIO.read(getClass().getResourceAsStream("/res/assets/ground/ground_down.png")));

            tile[9] = new Tile();
            tile[9].setTileImage(ImageIO.read(getClass().getResourceAsStream("/res/assets/ground/ground_right_down.png")));
            
            tile[10] = new Tile();
            tile[10].setTileImage(ImageIO.read(getClass().getResourceAsStream("/res/assets/ground/street.png")));
            
            tile[11] = new Tile();
            tile[11].setTileImage(ImageIO.read(getClass().getResourceAsStream("/res/assets/ground/street_horizontal_line.png")));
            
            tile[12] = new Tile();
            tile[12].setTileImage(ImageIO.read(getClass().getResourceAsStream("/res/assets/ground/street_vertical_line.png")));

            tile[13] = new Tile();
            tile[13].setTileImage(ImageIO.read(getClass().getResourceAsStream("/res/assets/obstacles/hole.png")));
            
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void loadMap(String NameMap){
        try {
            InputStream is = getClass().getResourceAsStream(NameMap);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            
            int col = 0;
            int row = 0;

            while (col < gp.maxWorldCol && row < gp.maxWorldRow) {
                String line =  br.readLine();

                while (col < gp.maxWorldCol ) {
                    String numbers[] = line.split(" ");  
                    int num = Integer.parseInt(numbers[col]);  

                    mapTileNum[col][row] = num;
                    col++;
                }
                if (col == gp.maxWorldCol) {
                    col = 0;
                    row++;
                }
            }
            br.close();
            is.close();    

        } catch (Exception e) {
            
        }
    }

    public void draw(Graphics2D g2 ){
        int worldCol = 0;
        int worldRow = 0;


        while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow){

            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX;
            int screenY = worldY ;

            g2.drawImage(tile[tileNum].getImage(), screenX, screenY, gp.getTileSize(),gp.getTileSize(), null);
            worldCol++;

            if(worldCol == gp.maxWorldCol){
                worldCol = 0;
                worldRow++;
            }
        }
    }
}
