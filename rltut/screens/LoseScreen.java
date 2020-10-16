package rltut.screens;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import asciiPanel.AsciiPanel;

public class LoseScreen implements Screen {
    private AsciiPanel terminal;

    public LoseScreen(AsciiPanel term){
        this.terminal = term;
    }

    public void displayOutput() {
        terminal.write("You lost.", 1, 1);
        terminal.writeCenter("-- press [enter] to restart --", 22);
    }

    public Screen respondToUserInput(KeyEvent key) {
        return key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen(this.terminal) : this;
    }

    @Override
    public Screen respondToMouseInput(MouseEvent e) {
        // TODO Auto-generated method stub
        return this;
    }
}