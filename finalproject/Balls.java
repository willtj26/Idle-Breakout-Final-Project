import java.awt.*;
public abstract class Balls extends BouncingCircle {
   public Balls(int side, int x, int y, Color c, int dXval, int dYval) {
      super(side, x, y, c, dXval, dYval);
   }

   public abstract void collide(Brick r);
   public abstract void increaseDamage();
   public abstract int getDamage();
   public abstract int getSpeed();

   public boolean isColliding(Brick r) {
      int bX = getX();
      int bY = getY();
      int rX = r.getX();
      int rY = r.getY();
      int s = getRadius() * 2;
      if (rX < bX + s && rX + s > bX && rY < bY + s && rY + s > bY) {
         return true; // collision detected
      } else {
         return false; // no collision
      }
   }
   public void setSpeed() {
      setdX(getdX() + 1);
      setDY(getDY() + 1);
   }
}