import java.awt.*;
public abstract class Balls extends BouncingCircle {
   public Balls(int side, int x, int y, Color c, int dXval, int dYval) {
      super(side, x, y, c, dXval, dYval);
   }

   public abstract void collide(BasicBall b, Brick r);

   public boolean isColliding(BasicBall b, Brick r) {
      int bX = b.getX();
      int bY = b.getY();
      int rX = r.getX();
      int rY = r.getY();
      int s = b.getRadius() * 2;
      if (rX < bX + s && rX + s > bX && rY < bY + s && rY + s > bY) {
         return true; // collision detected
      } else {
         return false; // no collision
      }
   }
}