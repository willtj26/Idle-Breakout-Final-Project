import java.awt.*;
import java.util.ArrayList;

public class BasicBall extends Balls {
   private int damage;
   public BasicBall() {
      super(8, 500, 500, Color.YELLOW, 3, 3);
      damage = 1;
   }
   
   public void collide(Brick r) {
      int counter = 0;
      int bX = getX();
      int bY = getY();
      int dBX = getdX();
      int dBY = getDY();
      int rX = r.getX();
      int rTopSide = r.getTopSide();
      int rLeftSide = r.getLeftSide();
      int rY = r.getY();
      int s = getRadius();
      if (rX < bX+dBX){
         setDY(getDY() * -1);
      }
      else if (rY < bY+dBY){
         //setDY(getDY() * -1);
         setdX(getdX() * -1);   
      }
      //Add poison and area of effect
      r.setBrickValue(r.getBrickValue()-damage);
      //System.out.println(r.getBrickValue());
   }
   public void increaseDamage() {
      damage += 1;
   }
   public int getDamage() {
      return damage;
   }
   public int getSpeed() {
      return getdX();
   }
}

