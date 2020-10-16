package rltut.screens;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

import asciiPanel.AsciiPanel;
import rltut.menus.Menu;
import rltut.menus.Option;

public class StartScreen implements Screen {

    private AsciiPanel terminal;
    private Menu menu;
    public StartScreen(AsciiPanel term){
        this.terminal = term;
        menu = new Menu(65, 15, new ArrayList<Option>(Arrays.asList(new Option("New Game", new PlayScreen(terminal)), new Option("Exit Game", new LoseScreen(terminal)))));
    }

    public void displayOutput() {
        terminal.writeCenter("Welcome to", 2);
        terminal.writeCenter("  ###   #    #   ###    ####", 5);
        terminal.writeCenter(" #   #  #    #  #   #     # ", 6);
        terminal.writeCenter(" #   #  #    #  #   #     # ", 7);
        terminal.writeCenter(" #####  #    #  #####     # ", 8);
        terminal.writeCenter(" #   #   #  #   #   #  #  # ", 9);
        terminal.writeCenter(" #   #    ##    #   #   ##  ", 10);
        displayMenu();
        terminal.writeCenter("-- press [enter] to start --", 30);
    }

    public Screen respondToUserInput(KeyEvent key) {
        return menu.respondToUserInput(key, this);
        // return key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen(this.terminal) : this;
    }

    @Override
    public Screen respondToMouseInput(MouseEvent e) {
        System.out.println(e.getX()/terminal.getCharWidth() + ", " + e.getY()/terminal.getCharHeight());
        System.out.println(e.getXOnScreen()/terminal.getCharWidth() + ", " + e.getYOnScreen()/terminal.getCharHeight());
        
        int inMenuX = (e.getX()/terminal.getCharWidth());
        int inMenuY = (e.getY()/terminal.getCharHeight())-2;
        System.out.println("Menu params: " + menu.getXPositionOnScreen() + ", " + menu.getYPositionOnScreen() + " to " + (menu.getWidthInCharacters()+menu.getXPositionOnScreen()) + ", " +(menu.getHeightInCharacters() + menu.getYPositionOnScreen()));
        if(inMenuX >= menu.getXPositionOnScreen() &&
            inMenuX <= menu.getWidthInCharacters()+menu.getXPositionOnScreen() &&
            inMenuY >= menu.getYPositionOnScreen() &&
            inMenuY <= menu.getHeightInCharacters() + menu.getYPositionOnScreen()){
                return menu.respondToMouseInput(e,inMenuX, inMenuY, this);
            }
        return this;
    }
    private void displayMenu(){
        for (int i = 0; i < menu.getOptionDisplay().size(); i++){
            terminal.write("["+(i+1) + "] " + menu.getOptionDisplay().get(i), menu.getXPositionOnScreen(), menu.getYPositionOnScreen()+i);
        }
    }
}