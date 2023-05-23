import java.awt.*;

public class PlasmaBall extends Balls {
   private int damage;
   public PlasmaBall() {
      super(10, 400, 400, new Color(160, 50, 200), 3, 3);
      damage = 5;
   }
   
   public void collide(Brick r) {
      setDY(getDY() * -1);
      setdX(getdX() * -1);
      //area of effect 
      r.setBrickValue(r.getBrickValue() - damage);
   }
}

