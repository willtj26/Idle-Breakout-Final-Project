import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.ArrayList;

public class Brick extends Rectangle {
    private int brickvalue;
    private Color c;

    public Brick(int x, int y, Color c1, int level) {
        super(40, 10, x, y, c);
        c = c1;
        brickvalue = level;
    }

    public int getBrickValue(){
        return brickvalue;
    }

    public void setBrickValue(int level){
        brickvalue = level;
    }

    public void drawMe(Graphics g){
        g.setColor(c);
        g.fillRect(x, y, topSide, leftSide);
    }
}
