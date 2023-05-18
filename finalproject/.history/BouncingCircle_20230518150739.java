import java.awt.*;


public class BouncingCircle extends Circle implements Animatable
{
   private int dX;  // how much it will move each step (speed)
   private int dY;
      
   // constructors
   public BouncingCircle()
   {
      super(10, 250, 250, Color.BLACK);
      dX = 3;
      dY = 3;
   }
   public BouncingCircle(int side, int x, int y, Color c, int dXval, int dYval) {
      super(side, x, y, c);
      dX = dXval;
      dY = dYval;
   }
   //accessors
   public int getdX()
   {
      return dX;
   }
   public int getDY()
   {
      return dY;
   }
   
   //modifiers
   public void setdX(int dXValue)
   {
      dX = dXValue;
   }
   public void setDY(int dYValue)
   {
      dY = dYValue;
   }
      
   //instance methods
   public void step()  //Implement Animatable's required step()
   {
      //Check to see if our circle is too small
      //If so, make sure dX is positive (radius is increasing)
      if(getX() <= 0+getRadius())
      {
         if(dX < 0)
         {
            dX *= -1;
         }
      }
      
      if(getX() >= 1200 - getRadius())
      {
         if(dX > 0)
         {
            dX *= -1;
         }
      }
      setX(getX() + dX);  //Change the radius a bit - either out or in - for each animation step

      if(getY() < 100) {
        if(dY < 0) {
            dY *=-1;
        }
      }
      if (getY() >= 850-getRadius()) {
        if(dY > 0) {
            dY*=-1;
        }
      }
      setY(getY()+dY);
   }
}