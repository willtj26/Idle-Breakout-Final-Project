import java.awt.*;

public interface BrickWalls{
   public void drawMe();
   public void getBrickArray();
}
        
        
        
        
        
        
        
        
        
/*
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

}
*/