import java.awt.*;

public class CannonBall extends BouncingCircle {
   private int damage;
   public CannonBall() {
      super(15, 400, 400, Color.BLACK, 3, 3);
      damage = 50;
   }
   
   public void collide(BasicBall b, Brick r) {
      if(r.getBrickValue()-damage <= 0) {
         r.setBrickValue(r.getBrickValue()-damage);
      }
      else{
         b.setDY(getDY() * -1);
         b.setdX(getdX() * -1);
      }
   }
}

