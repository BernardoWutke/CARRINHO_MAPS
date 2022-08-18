package main;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.event.MouseInputListener;


public class MouseInput implements MouseListener, MouseInputListener {
    private boolean clicked = false;
    private int mousePositionX, mousePositionY;

    public boolean isClicked() {
        return clicked;
    }
    public int getMousePositionX() {
        return mousePositionX;
    }
    public int getMousePositionY() {
        return mousePositionY;
    }

    public void clearMouse() {
        clicked = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        clicked = true;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        clicked = false;
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

    @Override
    public void mouseDragged(MouseEvent e) {
       
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mousePositionX = e.getX();
        mousePositionY = e.getY();
        
    }

}
