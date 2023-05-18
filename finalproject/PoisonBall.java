import java.awt.*;

public class PoisonBall extends BouncingCircle {
   private int damage;
   public PoisonBall() {
      super(12, 400, 400, new Color(255, 36, 0), 3, 3);
      damage = 20;
   }
   
   public void collide(BasicBall b, Brick r) {
      b.setDY(getDY() * -1);
      b.setdX(getdX() * -1);
      //Add poison and area of effect
      r.setBrickValue(r.getBrickValue()-damage);
   }
}

