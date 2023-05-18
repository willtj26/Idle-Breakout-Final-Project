import java.awt.*;

public class ScatterBall extends BouncingCircle {
   private int damage;
   public ScatterBall() {
      super(12, 400, 400, Color.ORANGE, 3, 3);
      damage = 10;
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
         r.setBrickValue(r.getBrickValue()-damage);
      }
   }
   //override step method for wall hits
}
