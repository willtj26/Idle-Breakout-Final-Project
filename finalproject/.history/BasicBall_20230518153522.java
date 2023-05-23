import java.awt.*;

public class BasicBall extends Balls {
   private int damage;
   public BasicBall() {
      super(8, 500, 500, Color.YELLOW, 3, 3);
      damage = 1;
   }
   
   public void collide(BasicBall b, Brick r) {
      b.setDY(getDY() * -1);
      b.setdX(getdX() * -1);
      r.setBrickValue(r.getBrickValue() - damage);
   }
}

