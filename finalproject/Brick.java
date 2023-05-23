import java.awt.*;

public class Brick extends Rectangle {
    private int topSide;
    private int leftSide;
    private int brickvalue;
    private Color c;
<<<<<<< HEAD
    private int x;
    private int y;
=======
    // Will's Additions
    private int[][] allBricks = new int[20][15];
>>>>>>> 53de6b7c4d05d01875669117a629bd72f10921e1

    public Brick(int x1, int y1, Color c1, int level) {
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
<<<<<<< HEAD
        g.setColor(c);
        g.fillRect(x, y, topSide, leftSide);
        g.drawString(""+brickvalue, topSide, leftSide);
=======
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
>>>>>>> 53de6b7c4d05d01875669117a629bd72f10921e1
    }

    public void changeValue(int hitValue){
        brickvalue -= hitValue;
    }
}
