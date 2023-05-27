import java.awt.*;
import java.util.ArrayList;

public class PlasmaBall extends Balls {
   private int damage;
   public PlasmaBall() {
      super(10, 400, 400, new Color(160, 50, 200), 3, 3);
      damage = 5;
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

