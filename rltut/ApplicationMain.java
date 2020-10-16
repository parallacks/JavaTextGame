package rltut;

import javax.swing.JFrame;
import java.awt.event.MouseListener;

import asciiPanel.AsciiPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

import rltut.screens.Screen;
import rltut.screens.StartScreen;

public class ApplicationMain extends JFrame implements KeyListener, MouseListener {
    private static final long serialVersionUID = 1060623638149583738L;

    private AsciiPanel terminal;
    private Screen screen;

    public ApplicationMain() {
        super();
        terminal = new AsciiPanel(150, 50);
        add(terminal);
        pack();
        screen = new StartScreen(terminal);
        addMouseListener(this);
        addKeyListener(this);
        repaint();
    }

    public void repaint() {
        terminal.clear();
        screen.displayOutput();
        super.repaint();
    }

    public void keyPressed(KeyEvent e) {
        screen = screen.respondToUserInput(e);
        repaint();
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
        
    }

    public static void main(String[] args) {
        ApplicationMain app = new ApplicationMain();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        // System.out.println("Mouse Clicked");
    }
    @Override
    public void mousePressed(MouseEvent e) { // TODO Auto-generated method stub
        System.out.println("Mouse Pressed");
        screen = screen.respondToMouseInput(e);
        repaint();
    }
    @Override
    public void mouseReleased(MouseEvent e) {// TODO Auto-generated method stub
        // System.out.println("Mouse Released");
    }
    @Override
    public void mouseEntered(MouseEvent e) {// TODO Auto-generated method stub
        // System.out.println("Mouse Entered");
    }
    @Override
    public void mouseExited(MouseEvent e) {// TODO Auto-generated method stub
        // System.out.println("Mouse Exited");
    }
   
}