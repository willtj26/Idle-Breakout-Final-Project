import java.awt.*;

public class Rectangle implements Animatable
{
   //fields
   private int topSide;
   private int leftSide;
   private int x;  //x coordinate of top left corner
   private int y;  //y coordinate of top left corner
   private Color c;
   
   //constructors
   public Rectangle()
   {
      topSide = 10;
      leftSide = 5;
      x = 10;
      y = 10;
      c = Color.WHITE;
   }
   public Rectangle(int topSideValue, int leftSideValue, int xValue, int yValue, Color cValue)
   {
      topSide = topSideValue;
      leftSide = leftSideValue;
      x = xValue;
      y = yValue;
      c = cValue;
   }
   
   //accessors
   public int getTopSide()
   {
      return topSide;
   }
   public int getLeftSide() {
      return leftSide;
   }
   public int getX()
   {
      return x;
   }
   public int getY()
   {
      return y;
   }
   public Color getColor()
   {
      return c;
   }
   
   //modifiers
   public void setTopSide(int sideValue)
   {
      topSide = sideValue;
   }
   public void setLeftSide(int sidevalue) {
      leftSide = sidevalue;
   }
   public void setX(int xValue)
   {
      x = xValue;
   }
   public void setY(int yValue)
   {
      y = yValue;
   }
   public void setColor(Color cValue)
   {
      c = cValue;
   }
   
   public void step(){
      setX(getX());
      setY(getY());
   }
   
   //instance methods
   public void drawMe(Graphics g)
   {
      g.setColor(c);
      //g.drawLine(x, y, x+40, y);
      //g.drawLine(x, y, x, y+40);
      //g.drawLine(x, y+40, x+40, y);
      //g.drawLine(x+40, y, x, y+40);
      g.fillRect(x, y, topSide, leftSide);
   }
   
   //other useful Java methods
   
   //(leave this commented out until the assignment tells you to use it)
   public String toString()
   {
      return "Square at " + x + ", " + y + " with top side length " + topSide + " and color set to " + c;
   }
   
   
}