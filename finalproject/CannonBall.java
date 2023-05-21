import java.awt.*;

class CannonBall extends BouncingCircle {
   private int damage;
   public CannonBall() {
      super(15, 400, 400, Color.BLACK, 3, 3);
      damage = 50;
   }
   
   public void collide(BasicBall b, Brick r) {
      int bX = b.getX();
      int bY = b.getY();
      int rX = r.getX();
      int rY = r.getY();
      int s = b.getRadius() * 2;
      if (rX < bX + s && rX + s > bX && rY < bY + s && rY + s > bY) {
         if(r.getBrickValue()-damage <= 0) {
            r.setBrickValue(r.getBrickValue()-damage);
         }
         else{
            b.setDY(getDY() * -1);
            b.setdX(getdX() * -1);
         }
      }
   }
}
