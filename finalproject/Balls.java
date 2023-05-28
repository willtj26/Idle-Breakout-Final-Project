import java.awt.*;
import java.util.ArrayList;

public abstract class Balls extends BouncingCircle {
   public Balls(int side, int x, int y, Color c, int dXval, int dYval) {
      super(side, x, y, c, dXval, dYval);
   }

   public abstract void collide(Brick r);
   public abstract void increaseDamage();
   public abstract int getDamage();
   public abstract int getSpeed();

   public Brick isColliding(ArrayList<Brick> allBricks) {
      Brick current = new BrickClass(3, 3, Color.BLACK, -10);
      for (Brick r: allBricks){
         int bX = getX();
         int bY = getY();
         int rX = r.getX();
         int rTopSide = r.getTopSide();
         int rLeftSide = r.getLeftSide();
         int rY = r.getY();
         int s = getRadius();
         if (rX < bX + s && rX + rTopSide > bX && rY < bY + s && rY + rLeftSide > bY) {
            return r; // collision detected
         } else {
            current = current; // no collision
         }
      }
      return current;
   }
   public void setSpeed() {
      setdX(getdX() + 1);
      setDY(getDY() + 1);
   }
}