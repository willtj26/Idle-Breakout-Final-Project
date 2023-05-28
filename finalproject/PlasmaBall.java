import java.awt.*;
import java.util.ArrayList;

public class PlasmaBall extends Balls {
   private int damage;
   public PlasmaBall() {
      super(10, 400, 400, new Color(160, 50, 200), 3, 3);
      damage = 5;
   }
   
   public void collide(Brick r) {
      int counter = 0;
      int bX = getX();
      int bY = getY();
      int rX = r.getX();
      int rTopSide = r.getTopSide();
      int rLeftSide = r.getLeftSide();
      int rY = r.getY();
      int s = getRadius();
      if (rX < bX){
         setDY(getDY() * -1);
         
      }
      else if (rY < bY){
         //setDY(getDY() * -1);
         setdX(getdX() * -1);   
      }
      //Add poison and area of effect
      r.setBrickValue(r.getBrickValue()-damage);
      //System.out.println(r.getBrickValue());
   }
   }
   public int getDamage() {
      return damage;
   }
   public int getSpeed() {
      return getdX();
   }
}

