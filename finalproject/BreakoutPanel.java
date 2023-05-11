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

   private JLabel title = new JLabel("Idle Breakout!");

   private JButton pauseButton, upgradeMenuButton, basicButton, plasmaButton, sniperButton, scatterButton, cannonButton, poisonButton;
   
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
      title.setText("Idle Breakout!");
      title.setBounds(450, 5, 100, 10);
      add(title, BorderLayout.NORTH);

      JPanel north = new JPanel(new GridLayout(1, 8));

      pauseButton = new JButton("Pause");
      upgradeMenuButton = new JButton("Upgrades");
      basicButton = new JButton("Basic Ball");
      plasmaButton = new JButton("Plasma Ball");
      sniperButton = new JButton("Sniper Ball");
      scatterButton = new JButton("Scatter Ball");
      cannonButton = new JButton("Cannon Ball");
      poisonButton = new JButton("Poison Ball");
   
      north.add(basicButton);
      north.add(plasmaButton);
      north.add(sniperButton);
      north.add(scatterButton);
      north.add(cannonButton);
      north.add(poisonButton);
      north.add(upgradeMenuButton);
      north.add(pauseButton);
   
      north.setBounds(0, 200, 1000, 50);

      add(north, );
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