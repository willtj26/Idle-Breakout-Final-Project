import javax.swing.*;

public class TempDriver {
   public static void main(String[] args) { 
      JFrame frame = new JFrame("IDLE BREAKOUT!");
      frame.setSize(600, 430);
      frame.setLocation(20, 20);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new TempPanel(frame));
      frame.pack();
      frame.setVisible(true);
   }
}