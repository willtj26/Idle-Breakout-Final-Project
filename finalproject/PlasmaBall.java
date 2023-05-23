import java.awt.*;

<<<<<<< HEAD
class PlasmaBall extends BouncingCircle {
=======
public class PlasmaBall extends Balls {
>>>>>>> 53de6b7c4d05d01875669117a629bd72f10921e1
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

