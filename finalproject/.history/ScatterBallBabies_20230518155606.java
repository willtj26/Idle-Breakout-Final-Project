import java.awt.*;

public class ScatterBallBabies extends Balls {
   private int damage;
   public ScatterBallBabies() {
      super(5, 500, 500, Color.YELLOW, 3, 3);
      damage = 10;
   }
   
   public void collide(BasicBall b, Brick r) {
      b.setDY(0);
      b.setdX(0);
      b.setColor(Color.GRAY);
      r.setBrickValue(r.getBrickValue() - damage);
   }
}

