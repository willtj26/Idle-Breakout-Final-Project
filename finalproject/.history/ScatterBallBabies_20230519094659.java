import java.awt.*;

public class ScatterBallBabies extends Balls {
   private int damage;
   public ScatterBallBabies() {
      super(5, 500, 500, Color.YELLOW, 3, 3);
      damage = 10;
   }
   
   public void collide(Brick r) {
      setDY(0);
      setdX(0);
      setColor(Color.WHITE.darker());
      r.setBrickValue(r.getBrickValue() - damage);
   }
}

