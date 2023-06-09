import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.ArrayList;

class BouncingCircle extends Circle implements Animatable
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
   public void step()
   {
      if(getX() <= 0)
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
      setX(getX() + dX);

      if(getY() < 80) {
        if(dY < 0) {
            dY *=-1;
        }
      }
      if (getY() >= 800-getRadius()*2) {
        if(dY > 0) {
            dY*=-1;
        }
      }
      setY(getY()+dY);
   }
}