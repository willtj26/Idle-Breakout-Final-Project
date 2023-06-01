import java.awt.*;
import java.util.ArrayList;

public class SniperBall extends Balls {
   private int damage;
   private ArrayList<Brick> allBricks = new ArrayList<Brick>();
   public SniperBall() {
      super(10, 500, 375, Color.WHITE, 3, 3);
      damage = 5;
   }
   
   public void setArrayBricks(ArrayList<Brick> allbrick){
      allBricks = allbrick;
   }
   
   public ArrayList<Brick> getArrayBricks(){
      return allBricks;
   }
   
   public void collide(Brick r) {
      int counter = 0;
      int bX = getX();
      int bY = getY();
      int rX = r.getX();
      int rTopSide = r.getTopSide();
      int rLeftSide = r.getLeftSide();
      int rY = r.getY();
      int s = getRadius();
      if (rX < bX){
         setDY(getDY() * -1);
         
      }
      else if (rY < bY){
         //setDY(getDY() * -1);
         setdX(getdX() * -1);   
      }
      //Add poison and area of effect
      r.setBrickValue(r.getBrickValue()-damage);
      //System.out.println(r.getBrickValue());
   }
   public void increaseDamage() {
      damage += 5;
   }
   public int getDamage() {
      return damage;
   }
   public int getSpeed() {
      return getdX();
   }
   @Override
   public void step()  //Implement Animatable's required step()
   {
      //Check to see if our circle is too small
      //If so, make sure dX is positive (radius is increasing)
      int currentX = getdX();
      int currentY = getDY();
      double smallest = 10000000;
      Brick smallestBrick = allBricks.get(0);
      
      for (Brick currentBrick: allBricks){
         double distance = ((currentX-currentBrick.getX())*(currentX-currentBrick.getX()))+((currentY-currentBrick.getY())*(currentY-currentBrick.getY()));
         if (distance < smallest){
            smallest = distance;
            smallestBrick = currentBrick;
         }
      }
      
      setdX(smallestBrick.getX()-currentX);
      setDY(smallestBrick.getY()-currentY);
      
      /*
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
      */
   }
}
