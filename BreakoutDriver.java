import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.ArrayList;
import java.lang.NumberFormatException;

public class BreakoutDriver
{
   public static void main(String[] args)
   { 
      JFrame frame = new JFrame("Panel Swapping");
      frame.setSize(600, 430);
      frame.setLocation(20, 20);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new BreakoutPanel());  //Pass "frame" to PanelSwapPanel so it can give frame commands (!)
      frame.pack();  //Allow PanelSwapPanel to decide the size
      frame.setVisible(true);
   }
}