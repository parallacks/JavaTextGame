package rltut.screens;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import asciiPanel.AsciiPanel;
import rltut.CreatureFactory;
import rltut.World;
import rltut.WorldBuilder;
import rltut.entities.Creature;

public class PlayScreen implements Screen {
    private World world;
    private int screenWidth;
    private int screenHeight;
    private AsciiPanel terminal;
    private Creature player;
    private Frame[] frames;
    
    public PlayScreen(AsciiPanel term){
        screenWidth = term.getWidthInCharacters();
        screenHeight = term.getHeightInCharacters();
        this.terminal = term;
        createWorld();
        CreatureFactory creatureFactory = new CreatureFactory(world);
        player = creatureFactory.newPlayer();
        
        frames = new Frame[]{new Frame(0,0,screenWidth-20, screenHeight-15)};
        
    }

    public void displayOutput() {
        terminal.write("You are having fun.", 1, 1);
        int left = getScrollX();
        int top = getScrollY();
   
        displayTiles(terminal, left, top);
        terminal.write(player.glyph(), player.x - left, player.y - top, player.color());
        terminal.writeCenter("-- press [escape] to lose or [enter] to win --", this.terminal.getHeightInCharacters()-2);
    }

    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()){
        case KeyEvent.VK_ESCAPE: return new LoseScreen(terminal);
        case KeyEvent.VK_ENTER: return new WinScreen(terminal);
        case KeyEvent.VK_LEFT:
        case KeyEvent.VK_H: player.moveBy(-1, 0); break;
        case KeyEvent.VK_RIGHT:
        case KeyEvent.VK_L: player.moveBy( 1, 0); break;
        case KeyEvent.VK_UP:
        case KeyEvent.VK_K: player.moveBy( 0,-1); break;
        case KeyEvent.VK_DOWN:
        case KeyEvent.VK_J: player.moveBy( 0, 1); break;
        case KeyEvent.VK_Y: player.moveBy(-1,-1); break;
        case KeyEvent.VK_U: player.moveBy( 1,-1); break;
        case KeyEvent.VK_B: player.moveBy(-1, 1); break;
        case KeyEvent.VK_N: player.moveBy( 1, 1); break;
        }
    
        return this;
    }

    public Screen respondToMouseInput(MouseEvent mouse){
        return this;
    }

    public int getScrollX() {
        return Math.max(0, Math.min(player.x - screenWidth / 2, world.width() - screenWidth));
    }

    public int getScrollY() {
        return Math.max(0, Math.min(player.y - screenHeight / 2, world.height() - screenHeight));
    }

    private void displayTiles(AsciiPanel terminal, int left, int top) {
        for (int x = 0; x < screenWidth; x++){
            for (int y = 0; y < screenHeight; y++){
                int wx = x + left;
                int wy = y + top;

                terminal.write(world.glyph(wx, wy), x, y, world.color(wx, wy));
            }
        }
    }

    private void displayFrames(AsciiPanel terminal, int left, int top) {
        for(Frame f : frames){
            for (int x = 0; x < f.getWidthInCharaters(); x++){
                for (int y = 0; y < f.getHeightInCharacters(); y++){
                    terminal.write(g.getSymbolAt(), x,y, f.getColor());
                }
            }
        }
    }

    private void createWorld(){
        world = new WorldBuilder(this.terminal.getWidthInCharacters()*2, this.terminal.getHeightInCharacters()*2)
              .makeCaves()
              .build();
    }
}