import java.awt.*;
import java.util.ArrayList;

public class CannonBall extends Balls {
   private int damage;
   public CannonBall() {
      super(15, 600, 500, Color.BLACK, 3, 3);
      damage = 50;
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
      if (rX < bX) {
         if(r.getBrickValue()-damage > 0) {
            setdX(getdX() * -1);
         }
      }
      if (rY < bY) {
         if(r.getBrickValue()-damage > 0) {
            setDY(getDY() * -1);
         }
      }
      r.setBrickValue(r.getBrickValue()-damage);
      //System.out.println(r.getBrickValue());
   }
   public void increaseDamage() {
      damage += 25;
   }
   public int getDamage() {
      return damage;
   }
   public int getSpeed() {
      return getdX();
   }
}

