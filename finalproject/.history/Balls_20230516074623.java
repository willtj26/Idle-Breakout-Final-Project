public abstract class Balls {
   public boolean collide(BasicBall b, Brick r) {
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
   abstract void collide();
}