import java.awt.*;

public class ScatterBall extends BouncingCircle {
   private int damage;
   public ScatterBall() {
      super(12, 400, 400, Color.ORANGE, 3, 3);
      damage = 20;
   }
   
   public void collide(BasicBall b, Brick r) {
      b.setDY(getDY() * -1);
      b.setdX(getdX() * -1);
      r.setBrickValue(r.getBrickValue()-damage);
   }
   //override step method for wall hits
   @Override
   public void step()  //Implement Animatable's required step()
   {
      //Check to see if our circle is too small
      //If so, make sure dX is positive (radius is increasing)
      if(getX() <= 0) {
         if(getdX() < 0) {
            // Targeting Feature
            setdX(getdX()*-1);
         }
      }
      
      if(getX() >= 1200 - getRadius()) {
         if(getdX() > 0) {
            // Targeting Feature
            setdX(getdX()*-1);
         }
      }
      setX(getX() + getdX());  //Change the radius a bit - either out or in - for each animation step

      if(getY() < 80) {
        if(getDY() < 0) {
         // Targeting Feature
         setDY(getDY()*-1);
        }
      }
      if (getY() >= 800-getRadius()*2) {
        if(getDY() > 0) {
         // Targeting Feature
         setDY(getDY()*-1);
        }
      }
      setY(getY()+getDY());
   }
}
   

