import java.awt.*;

public class Circle {
   //fields
   private int r;
   private int x;  //x coordinate of top left corner
   private int y;  //y coordinate of top left corner
   private Color c;
   
   //constructors
   public Circle() {
      r = 10;
      x = 200;
      y = 20;
      c = Color.BLACK;
   }
/*    public Circle(Square s) {
      r = s.getSide() / 2;
      x = s.getX() + r;
      y = s.getY() + r;
      c = s.getColor().darker();
   } */
   
   public Circle(int rValue, int xValue, int yValue, Color cValue) {
      r = rValue;
      x = xValue;
      y = yValue;
      c = cValue;
   }
   
   //accessors
   public int getRadius() {
      return r;
   }
   public int getX() {
      return x;
   }
   public int getY() {
      return y;
   }
   public Color getColor() {
      return c;
   }
   
   //modifiers
   public void setRadius(int rValue) {
      r = rValue;
   }
   public void setX(int xValue) {
      x = xValue;
   }
   public void setY(int yValue) {
      y = yValue;
   }
   public void setColor(Color cValue) {
      c = cValue;
   }
   
   //instance methods
   public void drawMe(Graphics g) {
      g.setColor(c);
      g.fillOval(x - r, y - r, r*2, r*2);
   }
   
   public String toString()
   {
      return "Circle at center " + x + ", " + y + " with radius " + r + " and color set to " + c;
   }
}