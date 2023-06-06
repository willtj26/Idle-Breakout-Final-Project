import java.awt.*;
import java.util.ArrayList;

public class BasicBall extends Balls {
   private int damage;
   public BasicBall() {
      super(8, 575, 375, Color.YELLOW, 1, 1);
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
      
      
      if ((bX >= rX && bX <= rX+rTopSide && bX - dBX <= rX+rTopSide) && (bY+s+1 > rY || bY >= rY+rLeftSide)){
         System.out.println("2");
         setDY(getDY() * -1);
      }
      
      else if ((bY >= rY && bY <= rY+rLeftSide) && (bX+s+1 > rX || bX >= rX+rTopSide)){
         System.out.println("1");
         setdX(getdX() * -1);
      }
      
      /* 
      else if (dBX > 0 && bY >= rY && bY <= rY+rLeftSide){
         System.out.println("2");
         setdX(getdX() * -1);
      }
      else if (bY+dBY < bY && bX < rX+rTopSide && bX > rX){
         //setDY(getDY() * -1);
         setdX(getdX() * -1);

         setDY(getDY() * -1);   
      }
      */
      
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

