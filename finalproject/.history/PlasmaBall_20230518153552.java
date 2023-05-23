import java.awt.*;

public class PlasmaBall extends BouncingCircle {
   private int damage;
   public PlasmaBall() {
      super(10, 400, 400, new Color(160, 50, 200), 3, 3);
      damage = 5;
   }
   
   public void collide(BasicBall b, Brick r) {
      b.setDY(getDY() * -1);
      b.setdX(getdX() * -1);
      //area of effect 
      r.setBrickValue(r.getBrickValue() - damage);
   }
}

