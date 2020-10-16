package rltut.menus;

import rltut.screens.Screen;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Menu {
    
    protected int widthInCharacters;
    protected int heightInCharacters;
    protected int xPositionOnScreen;
    protected int yPositionOnScreen;
    protected ArrayList<Option> options;
    public Menu(int xpos, int ypos, ArrayList<Option> ops){
        this.heightInCharacters= ops.size();
        int width = 0;
        for(Option op : ops){
            if (op.getDisplayString().length() > width){
                width = op.getDisplayString().length();
            }
        }
        this.widthInCharacters = width+4;
        this.xPositionOnScreen = xpos;
        this.yPositionOnScreen = ypos;
        this.options = ops;
    }
    public int getWidthInCharacters(){return this.widthInCharacters;}
    public int getHeightInCharacters(){return this.heightInCharacters;}
    public int getXPositionOnScreen(){return this.xPositionOnScreen;}
    public int getYPositionOnScreen(){return this.yPositionOnScreen;}
    public ArrayList<String> getOptionDisplay(){
        ArrayList<String> display = new ArrayList<>();
        for (Option op : this.options){
            display.add(op.getDisplayString());
        }
        return display;
    }

    public Screen respondToUserInput(KeyEvent e, Screen callback){
        // System.out.println(e.getKeyChar());
        for(int i = 0; i < this.options.size(); i++){
            if (Integer.toString(i+1).equals(Character.toString(e.getKeyChar()))){
                return this.options.get(i).getScreen();
            }
        }
        return callback;
    };
     public Screen respondToMouseInput(MouseEvent e, int termCharX, int termCharY, Screen callback){
        int inMenuX = termCharX - xPositionOnScreen;
        int inMenuY = termCharY - yPositionOnScreen;
        System.out.println(inMenuX + ", " + inMenuY);
        for(int i = 0; i < this.options.size(); i++){
            if (i == inMenuY){
                return this.options.get(i).getScreen();
            }
        }
        return callback;
     }
}
