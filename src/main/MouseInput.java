package main;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.event.MouseInputListener;

import static com.sun.java.accessibility.util.AWTEventMonitor.*;

public class MouseInput implements MouseListener, MouseInputListener {
    public boolean cliecked = false;
    public int x, y;

    public void clearMouse() {
        cliecked = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        cliecked = true;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        cliecked = false;
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
        x = e.getX();
        y = e.getY();
        
    }

}
