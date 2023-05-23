import java.awt.*;

public class Brick extends Rectangle {
    private int topSide;
    private int leftSide;
    private int brickvalue;
    private Color c;
    private int x;
    private int y;

    public Brick(Color c1, int level) {
        super(40, 10, x1, y1, c1);
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
        g.drawString(""+brickvalue, topSide, leftSide);
    }

    public void changeValue(int hitValue){
        brickvalue -= hitValue;
    }
}
