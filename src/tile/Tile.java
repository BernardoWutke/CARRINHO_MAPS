package tile;

import java.awt.image.BufferedImage;

public class Tile {
    private BufferedImage image;
    private boolean collision = false;

    public BufferedImage getImage() {
        return image;
    }
    public void setTileImage(BufferedImage image) {
        this.image = image;
    }
    
}
