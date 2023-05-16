import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.ArrayList;
import java.lang.Math;

public class PoisonBall extends BouncingCircle {
   
   public PoisonBall() {
      super(12, 400, 400, new Color(255, 36, 0), 3, 3);
   }
   
   public boolean collide(BasicBall b) {
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
