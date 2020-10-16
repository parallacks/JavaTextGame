package rltut.menus;

import rltut.screens.Screen;

public class Option {
    
    private String displayString;
    private Screen screen;

    public Option (String str, Screen scr){
        this.displayString = str;
        this.screen = scr;
    }
    
    public String getDisplayString(){return this.displayString;}
    public Screen getScreen(){return this.screen;}
}
