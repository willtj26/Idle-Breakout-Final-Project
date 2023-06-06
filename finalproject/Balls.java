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
         if (bX >= rX && bX <= rX + rTopSide && bY >= rY && bY <= rY + rLeftSide) {
            return r; // collision detected
         }
         else if (bX <= rX && bX + s >= rX && rY <= bY && rY + rLeftSide >= bY){
            return r;
         }
         else if (rX <= bX && rX + rTopSide >= bX && bY <= rY && bY+s >= rY){
            return r;
         }
      }
      return current;
   }
   public void setSpeed() {
      setdX(getdX() + 1);
      setDY(getDY() + 1);
   }
}