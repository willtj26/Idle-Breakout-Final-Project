import java.awt.*;

public class PoisonBall extends Balls {
   private int damage;
   public PoisonBall() {
      super(12, 400, 400, new Color(255, 36, 0), 3, 3);
      damage = 20;
   }
   
   public void collide(Brick r) {
      setDY(getDY() * -1);
      setdX(getdX() * -1);
      //Add poison and area of effect
      r.setBrickValue(r.getBrickValue()-damage);
   }
}

