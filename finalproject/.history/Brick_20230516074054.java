import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.ArrayList;

public class Brick extends Rectangle {
    private int curX;
    private int curY;
    public Brick(int x, int y, Color c) {
        super(40, 10, x, y, c);
    }  
}