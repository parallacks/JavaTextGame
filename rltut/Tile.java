package rltut;

import java.awt.Color;
import asciiPanel.AsciiPanel;

public enum Tile {
    FLOOR((char)250, AsciiPanel.yellow),
    WALL((char)177, AsciiPanel.yellow),
    BOUNDS('x', AsciiPanel.brightBlack),
    FR_HOR((char)186, AsciiPanel.white),
    FR_VERT((char)205, AsciiPanel.white),
    FR_UP_R_COR((char)187, AsciiPanel.white),
    FR_UP_L_COR((char)201, AsciiPanel.white),
    FR_LOW_R_COR((char)188, AsciiPanel.white),
    FR_LOW_L_COR((char)200, AsciiPanel.white),
    FR_LOW_T((char)202, AsciiPanel.white),
    FR_UP_T((char)203, AsciiPanel.white),
    FR_R_T((char)185, AsciiPanel.white),
    FR_L_T((char)204, AsciiPanel.white),
    FR_CROSS((char)206, AsciiPanel.white);

    private char glyph;
    public char glyph() { return glyph; }

    private Color color;
    public Color color() { return color; }

    Tile(char glyph, Color color){
        this.glyph = glyph;
        this.color = color;
    }

    public boolean isDiggable() {
        return this == Tile.WALL;
    }

    public boolean isGround() {
        return this != WALL && this != BOUNDS;
    }
}