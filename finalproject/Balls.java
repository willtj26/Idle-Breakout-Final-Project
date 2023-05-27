import java.awt.*;
import java.util.ArrayList;

public abstract class Balls extends BouncingCircle {
   public Balls(int side, int x, int y, Color c, int dXval, int dYval) {
      super(side, x, y, c, dXval, dYval);
   }

   public abstract void collide(ArrayList<Brick> allBricks);
   public abstract void increaseDamage();
   public abstract int getDamage();
   public abstract int getSpeed();

   public boolean isColliding(ArrayList<Brick> allBricks) {
      boolean current = false;
      for (Brick r: allBricks){
         int bX = getX();
         int bY = getY();
         int rX = r.getX();
         int rY = r.getY();
         int s = getRadius() * 2;
         if (rX < bX + s && rX + s > bX && rY < bY + s && rY + s > bY) {
            return true; // collision detected
         } else {
            current = false; // no collision
         }
      }
      return current;
   }
   public void setSpeed() {
      setdX(getdX() + 1);
      setDY(getDY() + 1);
   }
}