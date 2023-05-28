import java.awt.*;
public abstract class Brick extends Rectangle {
   private int brickvalue;
   public Brick(int topside, int leftside, int x, int y, Color c, int brickval) {
      super(x, y, topside, leftside,c, brickval);
      brickvalue = brickval;
   }

   public abstract void collide(Balls r);

   //public int getBrickValue(){
   //   return brickvalue;
   //}
   
   //public void setBrickValue(int brickval){
   //   brickvalue = brickval;
   //}

   public boolean isColliding(Balls r) {
      int bX = getX();
      int bY = getY();
      int rX = r.getX();
      int rY = r.getY();
      int s = getTopSide() * 2;
      if (rX < bX + s && rX + s > bX && rY < bY + s && rY + s > bY) {
         return true; // collision detected
      } else {
         return false; // no collision
      }
   }
}