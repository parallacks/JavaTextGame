package rltut.screens;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import asciiPanel.AsciiPanel;

public class WinScreen implements Screen {

    private AsciiPanel terminal;

    public WinScreen(AsciiPanel term){
        this.terminal = term;
        
    }

    public void displayOutput() {
        terminal.write("You won.", 1, 1);
        terminal.writeCenter("-- press [enter] to restart --", 22);
    }

    public Screen respondToUserInput(KeyEvent key) {
        return key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen(terminal) : this;
    }

    @Override
    public Screen respondToMouseInput(MouseEvent e) {
        // TODO Auto-generated method stub
        return this;
    }
}