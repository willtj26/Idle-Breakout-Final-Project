import java.awt.*;

public class PoisonBall extends BouncingCircle {
   
   public PoisonBall() {
      super(12, 400, 400, new Color(255, 36, 0), 3, 3);
   }
   
   public void collide(BasicBall b, Brick r) {
      int bX = b.getX();
      int bY = b.getY();
      int rX = r.getX();
      int rY = r.getY();
      int s = b.getRadius() * 2;
      if (rX < bX + s && rX + s > bX && rY < bY + s && rY + s > bY) {
         b.setDY(getDY() * -1);
         b.setdX(getdX() * -1);
      }
   }
}