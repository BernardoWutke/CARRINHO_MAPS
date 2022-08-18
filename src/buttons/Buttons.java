package buttons;
import main.GamePanel;
import main.MouseInput;
import javax.imageio.ImageIO;
import editmap.EditMap;
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
    
    public boolean isMove_click() {
        return move_click;
    }

    public void setMove_click(boolean move_click) {
        this.move_click = move_click;
    }

    public boolean isHole_click() {
        return hole_click;
    }

    public void setHole_click(boolean hole_click) {
        this.hole_click = hole_click;
    }

    public  void draw(Graphics2D g){
        try {
            if(move_click){
                g.drawImage(ImageIO.read(getClass().getResourceAsStream("/res/assets/ui/button_move_pressed.png")), 142, 542, null);
            } else {
                g.drawImage(ImageIO.read(getClass().getResourceAsStream("/res/assets/ui/button_move.png")), 142 , 542, null);
            } 
            if(hole_click){
                g.drawImage(ImageIO.read(getClass().getResourceAsStream("/res/assets/ui/button_hole_pressed.png")), 142 + 96 , 542, null);
            } else  {
                g.drawImage(ImageIO.read(getClass().getResourceAsStream("/res/assets/ui/button_hole.png")), 142 + 96, 542, null);
            }  
            if(reset_click){
                g.drawImage(ImageIO.read(getClass().getResourceAsStream("/res/assets/ui/button_reset_pressed.png")), 142 + 192, 542, null);
            } else {
                g.drawImage(ImageIO.read(getClass().getResourceAsStream("/res/assets/ui/button_reset.png")), 142 + 192, 542, null);
            } 
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void update(){
        if(mouseInput.getMousePositionX() >= 142 && mouseInput.getMousePositionX() <= 142 + 64 && mouseInput.getMousePositionY() >= 542 && mouseInput.getMousePositionY() <= 542 + 32 && mouseInput.isClicked() && !gp.getPlayer().getIsMove()){
            if(mouseInput.isClicked()){
                move_click = true;
            }else {
                move_click = false;
            }
        }
        if(mouseInput.getMousePositionX() >= 142 + 96 && mouseInput.getMousePositionX() <= 142 + 64 + 96 && mouseInput.getMousePositionY() >= 542 && mouseInput.getMousePositionY() <= 542 + 32 && mouseInput.isClicked() && mouseInput.isClicked() && !gp.getPlayer().getIsMove()){
            if(mouseInput.isClicked()){
                hole_click = true;
            } else {
                hole_click = false;
            } 
        } 
        if(mouseInput.getMousePositionX() >= 142 + 192 && mouseInput.getMousePositionX() <= 142 + 64 + 192 && mouseInput.getMousePositionY() >= 542  && mouseInput.getMousePositionY() <= 542 + 32 && mouseInput.isClicked() && !gp.getPlayer().getIsMove() ){
            if(mouseInput.isClicked()){
                reset_click = true;
                editMap.reset(gp.getMapPath());
            } 

        } else {
            reset_click = false;
        }

        clickBuraco();
       
    }

    void clickBuraco(){
        if (mouseInput.getMousePositionX() <= gp.worldWidth && mouseInput.getMousePositionY() <= gp.worldHeight && mouseInput.isClicked()  && hole_click){
            editMap.criarBuraco(gp.getMapPath(), Math.round(mouseInput.getMousePositionX()/gp.tileSize),  Math.round(mouseInput.getMousePositionY()/gp.tileSize));
            gp.repaint();
            hole_click = false;
        } 
        
    }

}
