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

   private int basicPrice = 25;
   private int plasmaPrice = 200;
   private int sniperPrice = 1500;
   private int scatterPrice = 10000;
   private int cannonPrice = 75000;
   private int poisonPrice = 75000;

   private int levelNumber = 0;

   public BreakoutPanel(JFrame f) {
      myOwner = f;
      setPreferredSize(new Dimension(1000, 1000));
      setLayout(new BorderLayout());

      try {
         basicIcon = new ImageIcon(this.getClass().getResource("imagefiles/basicball.png"));
         Image image = basicIcon.getImage();
         Image newimage = image.getScaledInstance(75, 50, java.awt.Image.SCALE_SMOOTH);
         basicIcon = new ImageIcon(newimage);
         
         plasmaIcon = new ImageIcon(this.getClass().getResource("imagefiles/plasmaball.png"));
         image = plasmaIcon.getImage();
         newimage = image.getScaledInstance(75, 50, java.awt.Image.SCALE_SMOOTH);
         plasmaIcon = new ImageIcon(newimage);
         
         sniperIcon = new ImageIcon(this.getClass().getResource("imagefiles/sniperball.png"));
         image = sniperIcon.getImage();
         newimage = image.getScaledInstance(75, 50, java.awt.Image.SCALE_SMOOTH);
         sniperIcon = new ImageIcon(newimage);

         scatterIcon = new ImageIcon(this.getClass().getResource("imagefiles/scatterball.png"));
         image = scatterIcon.getImage();
         newimage = image.getScaledInstance(75, 50, java.awt.Image.SCALE_SMOOTH);
         scatterIcon = new ImageIcon(newimage);

         cannonIcon = new ImageIcon(this.getClass().getResource("imagefiles/cannonball.png"));
         image = cannonIcon.getImage();
         newimage = image.getScaledInstance(75, 50, java.awt.Image.SCALE_SMOOTH);
         cannonIcon = new ImageIcon(newimage);

         poisonIcon = new ImageIcon(this.getClass().getResource("imagefiles/poisonball.png"));
         image = poisonIcon.getImage();
         newimage = image.getScaledInstance(75, 50, java.awt.Image.SCALE_SMOOTH);
         poisonIcon = new ImageIcon(newimage);

      } catch(Exception e) {
         System.out.println("Failed to load image icons: " + e.getMessage());
         e.printStackTrace();
     }
     
      // Create the button panel
      JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
      JPanel pricePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
      buttonPanel.add(pricePanel, BorderLayout.SOUTH);
      add(buttonPanel, BorderLayout.NORTH);

      // Add the buttons
      basicButton = new JButton(basicIcon);
      plasmaButton = new JButton(plasmaIcon);
      sniperButton = new JButton(sniperIcon);
      scatterButton = new JButton(scatterIcon);
      cannonButton = new JButton(cannonIcon);
      poisonButton = new JButton(poisonIcon);
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

      // Add Prices
      JLabel bPrice = new JLabel(Integer.toString(basicPrice));
      JLabel pPrice = new JLabel(Integer.toString(plasmaPrice));
      JLabel sPrice = new JLabel(Integer.toString(sniperPrice));
      JLabel scPrice = new JLabel(Integer.toString(scatterPrice));
      JLabel cPrice = new JLabel(Integer.toString(cannonPrice));
      JLabel poPrice = new JLabel(Integer.toString(poisonPrice));

      pricePanel.add(bPrice);
      pricePanel.add(pPrice);
      pricePanel.add(sPrice);
      pricePanel.add(scPrice);
      pricePanel.add(cPrice);
      pricePanel.add(poPrice);

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
         pauseButton.setText("Unpause");
         // pauseButton.removeActionListener(Listener_pause());
         // pauseButton.addActionListener(Listener_unpause());
      }
   }
   private class Listener_unpause implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         t.start();
         pauseButton.setText("Pause");
         // pauseButton.removeActionListener(Listener_unpause());
         // pauseButton.addActionListener(Listener_pause());
      }
   }
}