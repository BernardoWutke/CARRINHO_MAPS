package buttons;

import main.GamePanel;
import main.MouseInput;

import javax.imageio.ImageIO;

import editMap.EditMap;

import java.awt.*;
import java.io.IOException;

public class Buttons {
    
    

    private  boolean move_click = false, hole_click = false, reset_click = false;
    

    MouseInput mouseInput;
    GamePanel gp;
    EditMap editMap;
    public Buttons(MouseInput mouseInput, GamePanel gp) {
        this.mouseInput = mouseInput;
        this.gp = gp;
        editMap = new EditMap(gp);
    }
    
    public boolean isCone_click() {
        return move_click;
    }

    public void setCone_click(boolean move_click) {
        this.move_click = move_click;
    }

    public boolean isRota_click() {
        return hole_click;
    }

    public void setMove_click(boolean hole_click) {
        this.hole_click = hole_click;
    }

    public  void draw(Graphics2D g){
        try {
            if(move_click){
                g.drawImage(ImageIO.read(getClass().getResourceAsStream("/res/assets/ui/button_move_pressed.png")), 142, 542, null);
            } else {
                g.drawImage(ImageIO.read(getClass().getResourceAsStream("/res/assets/ui/button_move.png")), 142 , 542, null);
            } if(hole_click){
                g.drawImage(ImageIO.read(getClass().getResourceAsStream("/res/assets/ui/button_hole_pressed.png")), 142 + 96 , 542, null);
            } else  {
                g.drawImage(ImageIO.read(getClass().getResourceAsStream("/res/assets/ui/button_hole.png")), 142 + 96, 542, null);
            }  if(reset_click){
                g.drawImage(ImageIO.read(getClass().getResourceAsStream("/res/assets/ui/button_reset_pressed.png")), 142 + 192, 542, null);
            } else {
                g.drawImage(ImageIO.read(getClass().getResourceAsStream("/res/assets/ui/button_reset.png")), 142 + 192, 542, null);
            } 
        } catch (IOException e){
            e.printStackTrace();
        }
    }


    public void update(){
        if(mouseInput.x >= 142 && mouseInput.x <= 142 + 64 && mouseInput.y >= 542 && mouseInput.y <= 542 + 32 && mouseInput.cliecked){
            if(mouseInput.cliecked){
                move_click = true;
                System.out.println("Rota button clicked");
            }else {
                move_click = false;
            }
        }
        if(mouseInput.x >= 142 + 96 && mouseInput.x <= 142 + 64 + 96 && mouseInput.y >= 542 && mouseInput.y <= 542 + 32 && mouseInput.cliecked){
            if(mouseInput.cliecked){
                hole_click = true;
                System.out.println("Hole button clicked");
            } else {
                hole_click = false;
            } 
        } 
        if(mouseInput.x >= 142 + 192 && mouseInput.x <= 142 + 64 + 192 && mouseInput.y >= 542  && mouseInput.y <= 542 + 32 ){
   
            if(mouseInput.cliecked){
                reset_click = true;
                System.out.println("Reset button clicked");
                editMap.reset(gp.getMapPath());
            } 

        } else {
            reset_click = false;
        }

        clickBuraco();
       
    }

    void clickBuraco(){
        if (mouseInput.x <= gp.worldWidth && mouseInput.y <= gp.worldHeight && mouseInput.cliecked  && hole_click){
            System.out.println("Buraco clicked");
            editMap.criarBuraco(gp.getMapPath(), Math.round(mouseInput.x/gp.tileSize),  Math.round(mouseInput.y/gp.tileSize));
            gp.repaint();
            hole_click = false;
        } 
        
    }

    // public void update(){
    //     if(mouseInput.x >= 544 && mouseInput.x <= 544 + 64 && mouseInput.y >= 480 && mouseInput.y <= 480 + 64){
    //         if(mouseInput.clicked){
    //             cone_click = true;
    //             mouseInput.clicked = false;
    //         }
    //     } else {
    //         cone_click = false;
    //     }
    // }


}
