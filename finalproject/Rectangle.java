import java.awt.*;

public class Rectangle implements Animatable
{
   //fields
   private int topSide;
   private int leftSide;
   private int x;  //x coordinate of top left corner
   private int y;  //y coordinate of top left corner
   private Color c;
   private int brickvalue;
   
   //constructors
   public Rectangle()
   {
      topSide = 10;
      leftSide = 5;
      x = 10;
      y = 10;
      c = Color.WHITE;
   }
   public Rectangle(int topSideValue, int leftSideValue, int xValue, int yValue, Color cValue, int brickval)
   {
      topSide = topSideValue;
      leftSide = leftSideValue;
      x = xValue;
      y = yValue;
      c = cValue;
      brickvalue = brickval;
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
   public int getBrickValue(){
      return brickvalue;
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
   public void setBrickValue(int brickval){
      brickvalue = brickval;
   }
   
   public void step(){
      setBrickValue(getBrickValue());
      setX(getX());
      setY(getY());
   }
   
   //instance methods
   public void drawMe(Graphics g)
   {
      
      g.setColor(c);
      g.fillRect(x, y, topSide, leftSide);
      g.setFont(new Font("Serif", Font.BOLD, 25));
      g.setColor(Color.BLACK);
      g.drawString(""+brickvalue, x, y+leftSide-3);
      g.drawRect(x,y,topSide,leftSide);
   }
   
   //other useful Java methods
   
   //(leave this commented out until the assignment tells you to use it)
   public String toString()
   {
      return "Square at " + x + ", " + y + " with top side length " + topSide + " and color set to " + c;
   }
   
   
}