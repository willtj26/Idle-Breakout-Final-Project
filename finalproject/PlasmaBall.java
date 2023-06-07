import java.awt.*;
import java.util.ArrayList;

public class PlasmaBall extends Balls {
   private int damage;
   public PlasmaBall() {
      super(10, 600, 500, new Color(160, 50, 200), 2, 2);
      damage = 5;
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
      if ((bX >= rX && bX <= rX+rTopSide && bX - dBX <= rX+rTopSide) && (bY+s+1 > rY || bY >= rY+rLeftSide)){
         setDY(getDY() * -1);
      }
      
      else if ((bY >= rY && bY <= rY+rLeftSide) && (bX+s+1 > rX || bX >= rX+rTopSide)){
         setdX(getdX() * -1);
      }
      //Add poison and area of effect
      r.setBrickValue(r.getBrickValue()-damage);
   }
   public int getDamage() {
      return damage;
   }
   public void increaseDamage() {
      damage += 25;
   }
   public int getSpeed() {
      return getdX();
   }
}

