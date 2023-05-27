import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.ArrayList;


public class FourBrickWall extends JPanel{
   private int[][] intBrickArray;
   private Brick[][] BrickArray = new Brick[13][12];
   private int levelnumber;
   private int x = 80;
   private int y = 30;
   
   public FourBrickWall(){
      String level = "1";
      levelnumber = Integer.parseInt(level);
      for (int i = 0; i < 13; i++){
         if (i==7||i==8||i==9){
            for (int w = 0; w < 12; w++){
               Brick b1 = new Brick(Color.WHITE, " ");
               BrickArray[i][w] = b1; 
            }
         }
         
         else{
            for (int x = 0; x < 12; x++){
               if (x==6){
                  Brick b2 = new Brick(Color.WHITE, " ");
                  BrickArray[i][x] = b2;
               }
               else{
                  Brick b3 = new Brick(Color.BLUE, ""+levelnumber);
                  BrickArray[i][x] = b3;
               }
            }
         }
      }
   }
   
   public Brick[][] getBrickArray(){
      return BrickArray;
   }
   
   public JPanel drawMe(){
      System.out.println("here");
      JPanel brickpanel = new JPanel();
      System.out.println("1");
      brickpanel.setLayout(new GridLayout(BrickArray.length, BrickArray[0].length));
      
      for (int i = 0; i < BrickArray.length; i++){
         for (int x = 0; x < BrickArray[0].length; x++){
            Brick tempBrick = BrickArray[i][x];
            add(tempBrick);
         }
      }
      return brickpanel;
   }
}