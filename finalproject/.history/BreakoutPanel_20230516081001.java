import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.ArrayList;

class BreakoutPanel extends JPanel {

   private JFrame myOwner;

   public static final int FRAME = 1000;
   private static final Color BACKGROUND = Color.WHITE.darker();

   private BufferedImage myImage;
   private Graphics myBuffer;

   private Timer t;

   private ArrayList<Animatable> animationObjects;
   private ArrayList<BouncingCircle> allBalls = new ArrayList <BouncingCircle>();

   // Gui components
   private JButton pauseButton, upgradeMenuButton, basicButton, plasmaButton, sniperButton, scatterButton, cannonButton, poisonButton;

      
   private ImageIcon basicIcon, plasmaIcon, sniperIcon, scatterIcon, cannonIcon, poisonIcon;

   private int basicNum = 0;
   private int plasmaNum = 0;
   private int sniperNum = 0;
   private int scatterNum = 0;
   private int cannonNum = 0;
   private int poisonNum = 0;

   private int levelNumber = 0;

   public BreakoutPanel(JFrame f) {
      myOwner = f;
      setPreferredSize(new Dimension(1000, 1000));
      setLayout(new BorderLayout());

      try {
         basicIcon = new ImageIcon(this.getClass().getResource("/finalproject/imagefiles/basicball.jpeg"));
         plasmaIcon = new ImageIcon(this.getClass().getResource("/finalproject/imagefiles/plasmaball.jpeg"));
         sniperIcon = new ImageIcon(this.getClass().getResource("/finalproject/imagefiles/sniperball.jpeg"));
         scatterIcon = new ImageIcon(this.getClass().getResource("/finalproject/imagefiles/scatterball.jpeg"));
         cannonIcon = new ImageIcon(this.getClass().getResource("/finalproject/imagefiles/cannonball.jpeg"));
         poisonIcon = new ImageIcon(this.getClass().getResource("/finalproject/imagefiles/basicball.jpeg"));
      }
      catch(Exception e) {

      }
      // Create the button panel
      JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
      add(buttonPanel, BorderLayout.NORTH);

      // Add the buttons
      basicButton = new JButton("Basic Ball");
      plasmaButton = new JButton("Plasma Ball");
      sniperButton = new JButton("Sniper Ball");
      scatterButton = new JButton("Scatter Ball");
      cannonButton = new JButton("Cannon Ball");
      poisonButton = new JButton("Poison Ball");
      upgradeMenuButton = new JButton("Upgrades");
      pauseButton = new JButton("Pause");

      buttonPanel.add(basicButton);
      buttonPanel.add(plasmaButton);
      buttonPanel.add(sniperButton);
      buttonPanel.add(scatterButton);
      buttonPanel.add(cannonButton);
      buttonPanel.add(poisonButton);
      buttonPanel.add(upgradeMenuButton);
      buttonPanel.add(pauseButton);

      // Add action listeners
      basicButton.addActionListener(new Listener_basic());
      plasmaButton.addActionListener(new Listener_plasma());
      sniperButton.addActionListener(new Listener_sniper());
      scatterButton.addActionListener(new Listener_scatter());
      cannonButton.addActionListener(new Listener_cannon());
      poisonButton.addActionListener(new Listener_poison());
      upgradeMenuButton.addActionListener(new Listener_upgrade());
      pauseButton.addActionListener(new Listener_pause());

      // Create the ball bouncing area
      animationObjects = new ArrayList<Animatable>();
      allBalls = new ArrayList<BouncingCircle>();
      myImage = new BufferedImage(FRAME, FRAME, BufferedImage.TYPE_INT_RGB);
      myBuffer = myImage.getGraphics();
      myBuffer.setColor(BACKGROUND);
      myBuffer.fillRect(0,0,FRAME,FRAME);

      // Add the ball bouncing area
      add(new JLabel(new ImageIcon(myImage)), BorderLayout.CENTER);

      t = new Timer(5, new AnimationListener());
      t.start();
   }

   public void animate() {
      int totalBalls = basicNum + plasmaNum + sniperNum + scatterNum + cannonNum + poisonNum;
      myBuffer.setColor(BACKGROUND);
      myBuffer.fillRect(0,0,FRAME,FRAME);
      for(int i = 0; i < totalBalls; i++) {
         BouncingCircle currentBall = allBalls.get(i);
         currentBall.step();

         // The collide method should not be a boolean, I had the idea to check collision here and then do a different "Collide" action depending on the ball.
         // There are a couple errors rn, I made BasicBall implement "Balls", but I am pretty sure I did it incorrecly.  Also "Collide" shouln't be a boolean method.
         // All Ball classes need thier "Collide" method to be fixed to represent thier action.
         // Also, I am pretty sure the step method needs to be updated, especially for sniper and scatter.
         // I believe we need to make another ball class for the little balls that come from the scatter ball.

      /*   int newX = currentBall.getX();
         int newY = currentBall.getY();
         int mainX = getX();
         int mainY = getY();
         int s = currentBall.getRadius() * 2;
         if (mainX < newX + s && mainX + s > newX && mainY < newY + s && mainY + s > newY) {
            collide(currentBall);
         } */
      }
   
      for(int k = 0; k < totalBalls; k++){
         BouncingCircle c = allBalls.get(k);
         c.drawMe(myBuffer);
      }
      repaint();
   }     
   private class AnimationListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         animate();
      }
   }
   private class Listener_basic implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         plasmaButton.setEnabled(true);
         BasicBall ccr = new BasicBall();
         animationObjects.add(ccr);
         allBalls.add(ccr);
         basicNum++;
      }
   }
   private class Listener_plasma implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         sniperButton.setEnabled(true);
         PlasmaBall ccr = new PlasmaBall();
         animationObjects.add(ccr);
         allBalls.add(ccr);
         plasmaNum++;
      }
   }
   private class Listener_sniper implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         scatterButton.setEnabled(true);
         SniperBall ccr = new SniperBall();
         animationObjects.add(ccr);
         allBalls.add(ccr);
         sniperNum++;
      }
   }
   private class Listener_scatter implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         cannonButton.setEnabled(true);
         ScatterBall ccr = new ScatterBall();
         animationObjects.add(ccr);
         allBalls.add(ccr);
         scatterNum++;
      }
   }
   private class Listener_cannon implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         poisonButton.setEnabled(true);
         CannonBall ccr = new CannonBall();
         animationObjects.add(ccr);
         allBalls.add(ccr);
         cannonNum++;
      }
   }
   private class Listener_poison implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         PoisonBall ccr = new PoisonBall();
         animationObjects.add(ccr);
         allBalls.add(ccr);
         poisonNum++;
      }
   }
   private class Listener_upgrade implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         System.out.println("Upgrade Menu Open");
      }
   }
   private class Listener_pause implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         t.stop();
         pauseButton.setEnabled(false);
         JButton unpause = new JButton();
         System.out.println("Pause");
      }
   }
}