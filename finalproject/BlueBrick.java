import java.awt.*;

public class BlueBrick extends Brick {
   private int bricklevel;
   private int x;
   private int y;
   public BlueBrick(int x1, int y1, int brickvalue) {
      super(x1, y1, 50, 25, Color.BLUE, brickvalue);
      bricklevel = brickvalue;
      x = x1;
      y = y1;
   }
   
   public void collide(Balls r) {
      System.out.println("Colliding");
      //setDY(getDY() * -1);
      //setdX(getdX() * -1);
      //Add poison and area of effect
      //super.setBrickValue(bricklevel damage);
   }
}

