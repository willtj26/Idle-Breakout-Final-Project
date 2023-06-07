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
   public Brick getBrick(int row) {
      Brick t = getArrayBricks()[row];
      return t;
   }
   
   public Brick[] getArrayBricks(){
      Brick[] a = new Brick[allBricks.size()];
      return a;
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
   public void step() {
      double smallestDistance = Double.MAX_VALUE;
      Brick targetBrick = null;

      int currentX = getX();
      int currentY = getY();

      for (Brick currentBrick : allBricks) {
         double distance = Math.sqrt(Math.pow(currentBrick.getX() - currentX, 2) + Math.pow(currentBrick.getY() - currentY, 2));
         if (distance < smallestDistance) {
            smallestDistance = distance;
            targetBrick = currentBrick;
         }
      }

      if (targetBrick != null) {
         double angle = Math.atan2(targetBrick.getY() - currentY, targetBrick.getX() - currentX);
         setdX((int) (Math.cos(angle) * getX()));
         setDY((int) (Math.sin(angle) * getY()));
      }

      super.step();
   }

}