import java.awt.*;

public class PlasmaBall extends BouncingCircle {
   
   public PlasmaBall() {
      super(10, 400, 400, new Color(160, 180, 200), 3, 3);
   }
   
   public boolean collide(BasicBall b) {
      int newX = b.getX();
      int newY = b.getY();
      int mainX = getX();
      int mainY = getY();
      int s = b.getRadius() * 2;
      if (mainX < newX + s && mainX + s > newX && mainY < newY + s && mainY + s > newY) {
         return true; // collision detected
      } else {
         return false; // no collision
      }
   }
}
