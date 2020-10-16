package rltut.screens;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
//TODO Make this and abstract class so we can have default key handling for an esc menu etc.
public interface Screen {
    public void displayOutput();

    public Screen respondToUserInput(KeyEvent key);
    public Screen respondToMouseInput(MouseEvent e);
}
