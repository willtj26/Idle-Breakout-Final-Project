import java.awt.*;

public class CannonBall extends Balls {
   private int damage;
   public CannonBall() {
      super(15, 400, 400, Color.BLACK, 3, 3);
      damage = 50;
   }
   
   public void collide(Brick r) {
      if(r.getBrickValue()-damage <= 0) {
         r.setBrickValue(r.getBrickValue()-damage);
      }
      else{
         setDY(getDY() * -1);
         setdX(getdX() * -1);
      }
   }
}

