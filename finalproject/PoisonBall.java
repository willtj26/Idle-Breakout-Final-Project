import java.awt.*;

<<<<<<< HEAD
class PoisonBall extends BouncingCircle {
=======
public class PoisonBall extends Balls {
>>>>>>> 53de6b7c4d05d01875669117a629bd72f10921e1
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

