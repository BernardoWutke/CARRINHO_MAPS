package entity;

import java.awt.image.BufferedImage;

public class Entity {
    protected int x,y;
    protected int speed;


    private BufferedImage up, down, left, right;
    private String direction ;

    private int spriteCounter = 0;
    private int spriteNum = 1;

    public BufferedImage getUp() {
        return up;
    }

    public void setUp(BufferedImage up) {
        this.up = up;
    }

    public BufferedImage getDown() {
        return down;
    }

    public void setDown(BufferedImage down) {
        this.down = down;
    }

    public BufferedImage getLeft() {
        return left;
    }

    public void setLeft(BufferedImage left) {
        this.left = left;
    }

    public BufferedImage getRight() {
        return right;
    }

    public void setRight(BufferedImage right) {
        this.right = right;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
