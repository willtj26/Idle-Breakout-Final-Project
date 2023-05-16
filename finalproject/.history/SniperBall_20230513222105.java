import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.ArrayList;
import java.lang.Math;

public class SniperBall extends BouncingCircle {
   
   public SniperBall() {
      super(10, 400, 400, Color.WHITE, 3, 3);
   }
   
   public boolean collide(SniperBall b) {
      int newX = b.getX();
      int newY = b.getY();
      int mainX = getX();
      int mainY = getY();
      int s = b.getRadius() * 2;
      if (mainX < newX + s && mainX + s > newX && mainY < newY + s && mainY + s > newY) {
         return true; // collision detected
      } else {
         return false; // no collision
      }
   }
}
