import java.awt.*;
import java.util.ArrayList;

public class CannonBall extends Balls {
   private int damage;
   public CannonBall() {
      super(15, 400, 400, Color.BLACK, 3, 3);
      damage = 50;
   }
   
   public void collide(ArrayList<Brick> allBricks) {
      for (Brick r: allBricks){
         setDY(getDY() * -1);
         setdX(getdX() * -1);
         //Add poison and area of effect
         r.setBrickValue(r.getBrickValue()-damage);
      }
   }

}

