import java.awt.*;
import java.util.ArrayList;

public class BasicBall extends Balls {
   private int damage;
   public BasicBall() {
      super(8, 500, 500, Color.YELLOW, 3, 3);
      damage = 1;
   }
   
   public void collide(ArrayList<Brick> allBricks) {
      for (Brick r: allBricks)
      {
         setDY(getDY() * -1);
         setdX(getdX() * -1);
         //Add poison and area of effect
         r.setBrickValue(r.getBrickValue()-damage);
      }
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

