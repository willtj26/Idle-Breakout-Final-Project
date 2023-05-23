import java.awt.*;

public abstract class FourBrickWall extends Brick implements BrickWalls{
   private int[][] intBrickArray;
   private Brick[][] BrickArray;
   private int levelnumber;
   private int x = 80;
   private int y = 30;
   
   public FourBrickWall(int level){
      levelnumber = level;
      for (int i = 0; i < 13; i++){
         if (i==7||i==8||i==9){
            for (int w = 0; w < 12; w++){
               BrickArray[i][w] = Brick(" ", x+40, y+10, Color.WHITE);
            }
         }
         
         else{
            for (int x = 0; x < 12; x++){
               if (x==6){
                  BrickArray[i][x] = Brick(" ", x+40, y+10, Color.WHITE);
               }
               else{
                  BrickArray[i][x] = Brick(levelnumber, x+40, y+10, Color.BLUE);
               }
            }
         }
      }   
   }
}