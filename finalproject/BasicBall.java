import java.awt.*;

public class BasicBall extends BouncingCircle /*implements Balls*/ {
   private int damage;
   public BasicBall() {
      super(8, 500, 500, Color.YELLOW, 3, 3);
      damage = 1;
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
         r.setBrickValue(r.getBrickValue() - damage);
      }
   }
}
