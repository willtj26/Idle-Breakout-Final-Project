import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.ArrayList;

public class Brick extends Rectangle {
    private ArrayList<Integer> xCoords;
    private ArrayList<Integer> yCoords;
    private int curX;
    private int curY;
    public Brick(int x, int y, Color c) {
        super(40, 10, x, y, c);
        xCoords.add(x);
        yCoords.add(y);
    }  
    public int getY(int index) {
        return yCoords[index];
    }  
    public int getX(int index) {
        return xCoords[index];
    }  
    public void setY(int index, int value) {
        yCoords[index] = value;
    }
    public void setX(int index, int value) {
        xCoords[index] = value;
    }
}
