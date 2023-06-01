import java.awt.*;

public class BrickClass extends Brick{
   private int bricklevel;
   private int x;
   private int y;
   private Color c;
   public BrickClass(int x1, int y1, Color c1, int brickvalue) {
      super(x1, y1, 50, 25, c1, brickvalue);
      bricklevel = brickvalue;
      x = x1;
      y = y1;
      c = c1;
   }
   
   public void collide(Balls r) {
      System.out.println("Colliding");
      //setDY(getDY() * -1);
      //setdX(getdX() * -1);
      //Add poison and area of effect
      //super.setBrickValue(bricklevel damage);
   }
}

