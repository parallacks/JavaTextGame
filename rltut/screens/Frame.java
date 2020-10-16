package rltut.screens;

import rltut.Tile;
import java.awt.Color;

public class Frame {
    enum orientation {
        VERTICAL, HORIZONTAL
    }
    private int xPosition, yPosition, widthInCharaters, heightInCharacters;
    private Tile sideSymbol, topSymbol;
    private Frame[] innerFrames;
    private Color frameColor;
    public Frame(int xpos, int ypos, int width, int height){
        this.xPosition = xpos;
        this.yPosition = ypos;
        this.widthInCharaters = width;
        this.heightInCharacters = height;
        this.innerFrames = null;
        sideSymbol = Tile.FR_HOR;
        topSymbol = Tile.FR_VERT;
        frameColor = Color.white;
    }

    public int getXPosition() {
        return this.xPosition;
    }

    public void setXPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getYPosition() {
        return this.yPosition;
    }

    public void setYPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public int getWidthInCharaters() {
        return this.widthInCharaters;
    }

    public void setWidthInCharaters(int widthInCharaters) {
        this.widthInCharaters = widthInCharaters;
    }

    public int getHeightInCharacters() {
        return this.heightInCharacters;
    }

    public void setHeightInCharacters(int heightInCharacters) {
        this.heightInCharacters = heightInCharacters;
    }

    public Tile getSideSymbol() {
        return this.sideSymbol;
    }

    public void setSideSymbol(Tile sideSymbol) {
        this.sideSymbol = sideSymbol;
    }

    public Tile getTopSymbol() {
        return this.topSymbol;
    }

    public void setVertSymbol(Tile vertSymbol) {
        this.topSymbol = vertSymbol;
    }

    public void setColor(Color color){
        this.frameColor = color;
    }

    public Color getColor(){
        return frameColor;
    }
    public Tile getSymbolAt(int x, int y){
        return null;
        //TODO implement
    }

}
