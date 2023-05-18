import java.awt.*;

public class SniperBall extends BouncingCircle {
   
   public SniperBall() {
      super(10, 400, 400, Color.WHITE, 3, 3);
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
      }
   }
   /*@Override
   public void step()  //Implement Animatable's required step()
   {
      //Check to see if our circle is too small
      //If so, make sure dX is positive (radius is increasing)
      if(getX() <= 0)
      {
         if(dX < 0)
         {
            dX *= -1;
         }
      }
      
      if(getX() >= 1000 - getRadius()*2)
      {
         if(dX > 0)
         {
            dX *= -1;
         }
      }
      setX(getX() + dX);  //Change the radius a bit - either out or in - for each animation step

      if(getY() < 110) {
        if(dY < 0) {
            dY *=-1;
        }
      }
      if (getY() >= 910-getRadius()*2) {
        if(dY > 0) {
            dY*=-1;
        }
      }
      setY(getY()+dY);
   }*/

}
