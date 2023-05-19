import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.ArrayList;

public class Brick extends Rectangle {
    private int topSide;
    private int leftSide;
    private int brickvalue;
    private Color c;
    // Will's Additions
    private int[][] allBricks = new int[20][15];

    public Brick(int x, int y, Color c1, int level) {
        super(40, 10, x, y, c1);
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
        if((brickvalue % 5) == 1) {
            g.setColor(Color.BLUE.brighter());
            for(int i = 2; i <18; i++) {
                for(int j = 2; i < 6; i++) {
                    allBricks[i][j] = brickvalue;
                }
            }
            for(int i = 2; i < 18; i++) {
                for(int j = 9; j < 13; j++) {
                    allBricks[i][j] = brickvalue;
                }
            }
        }
        if((brickvalue % 5) == 2) {
            g.setColor(Color.PINK.darker());
            for(int i = 0; i <20; i++) {
                for(int j = 1; j < 15; j+=2) {
                    allBricks[i][j] = brickvalue;
                }
            }
        }
        if((brickvalue % 5) == 3) {
            g.setColor(Color.GREEN.brighter());
            for(int i = 1; i <8; i++) {
                for(int j = 2; i < 6; i++) {
                    allBricks[i][j] = brickvalue;
                }
                for(int j = 9; i < 14; i++) {
                    allBricks[i][j] = brickvalue;
                }
            }
            for(int i = 12; i < 19; i++) {
                for(int j = 2; j < 18; j++) {
                    allBricks[i][j] = brickvalue;
                }
                for(int j = 9; i < 14; i++) {
                    allBricks[i][j] = brickvalue;
                }
            }
        }
        if((brickvalue % 5) == 4) {
            g.setColor(Color.RED);
            for(int i = 0; i <20; i++) {
                for(int j = 5; j < 10; j++) {
                    allBricks[i][j] = brickvalue;
                }
            }
        }
        if((brickvalue % 5) == 0) {
            g.setColor(Color.ORANGE);
            for(int i = 1; i <20; i+=3) {
                for(int j = 0; j < 15; j++) {
                    allBricks[i][j] = brickvalue;
                }
            }
        }
        for(int[] row : allBricks) {
            for(int column : row) {
                g.setColor(c);
                g.fillRect(getX(), getY(), topSide, leftSide);
                g.drawString(""+brickvalue, topSide, leftSide);
            }

        }
    }

    public void changeValue(int hitValue){
        brickvalue -= hitValue;
    }
}
