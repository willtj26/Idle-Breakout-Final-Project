import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.ArrayList;

class BreakoutPanel extends JPanel {

   public static final int FRAME = 500;
   private static final Color BACKGROUND = Color.WHITE.darker();
   
   private BufferedImage myImage;
   private Graphics myBuffer;

   private Timer t;

   private ArrayList<Animatable> animationObjects;
   private ArrayList<BouncingCircle> allBalls = new ArrayList <BouncingCircle>();
   
   ////////////////// Gui Stuff

   private JLabel title = new JLabel("ColorChange Squares + GUI");
   private JLabel r = new JLabel("Red: ");
   private JLabel g = new JLabel("Green: ");
   private JLabel b = new JLabel("Blue: ");
   
   private JSlider speedSlider, sizeSlider;

   private JTextField redBox, greenBox, blueBox;
   private JButton resetButton, randomButton, givenButton, disableButton, enableButton;
   
   //////////////////
   

   public BreakoutPanel() {
      setLayout(new BorderLayout()); // Set the layout manager to BorderLayout
      
      myImage =  new BufferedImage(FRAME, FRAME, BufferedImage.TYPE_INT_RGB);
      myBuffer = myImage.getGraphics();
      myBuffer.setColor(BACKGROUND);
      myBuffer.fillRect(0,0,FRAME,FRAME);
      
      animationObjects = new ArrayList<Animatable>();
      allBalls = new ArrayList<BouncingCircle>();
      
      //////////////// GUI stuff
   
      JPanel panel = new JPanel();
      panel.setLayout(new GridLayout(2, 1));

      JPanel north = new JPanel(new GridLayout(1, 1));
      JPanel east = new JPanel(new GridLayout(3, 2));
      JPanel south = new JPanel(new GridLayout(1, 5));
      JPanel southeast = new JPanel(new GridLayout(2, 1));
      
      title.setText("Color Change Squares + GUI");
      north.add(title);
   
      r.setText("Red: ");
      g.setText("Green: ");
      b.setText("Blue: ");
      redBox = new JTextField(3);
      greenBox = new JTextField(3);
      blueBox = new JTextField(3);
   
      east.add(r);
      east.add(redBox);
      east.add(g);
      east.add(greenBox);
      east.add(b);
      east.add(blueBox);

      southeast.add(speedSlider);
      southeast.add(sizeSlider);

      resetButton = new JButton("Reset");
      randomButton = new JButton("Add Random");
      givenButton = new JButton("Add Given Color");
      disableButton = new JButton("Disable Color Change");
      enableButton = new JButton("Enable Color Change");
   
      south.add(resetButton);
      south.add(randomButton);
      south.add(givenButton);
      south.add(disableButton);
      south.add(enableButton);
   
      enableButton.setEnabled(false);
   
      panel.add(east);
      panel.add(southeast);

      add(panel, BorderLayout.EAST);
      add(north, BorderLayout.NORTH);
      add(south, BorderLayout.SOUTH);
      ///////////////
      
      t = new Timer(5, new AnimationListener());
      t.start();
   }

   
   public void paintComponent(Graphics g) {
      g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
   }

   public void animate() {
      myBuffer.setColor(BACKGROUND);
      myBuffer.fillRect(0,0,FRAME,FRAME);
      repaint();
   }   
   private class AnimationListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         animate();
      }
   }
   
}