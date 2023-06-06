import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.ArrayList;
import java.util.Random;

class BreakoutPanel extends JPanel{

   private JFrame myOwner;

   public static final int FRAMEx = 1200;
   public static final int FRAMEy = 850;
   private static final Color BACKGROUND = Color.WHITE.darker();

   private Money money = new Money(25);
   private BufferedImage myImage;
   private Graphics myBuffer;

   private Timer t;

   private ArrayList<Animatable> animationObjects;
   private ArrayList<Balls> allBalls = new ArrayList <Balls>();
   private ArrayList<Brick> allBricks = new ArrayList <Brick>();
   private ArrayList<BrickClass> allBrickClasses = new ArrayList <BrickClass>();
   private ArrayList<BasicBall> allBasicBalls = new ArrayList <BasicBall>();
   private ArrayList<PlasmaBall> allPlasmaBalls = new ArrayList <PlasmaBall>();
   private ArrayList<SniperBall> allSniperBalls = new ArrayList <SniperBall>();
   private ArrayList<ScatterBall> allScatterBalls = new ArrayList <ScatterBall>();
   private ArrayList<CannonBall> allCannonBalls = new ArrayList <CannonBall>();
   private ArrayList<PoisonBall> allPoisonBalls = new ArrayList <PoisonBall>();

   private UpgradePanel upgradePanel;
   // Gui components
   private JButton pauseButton, upgradeMenuButton, basicButton, plasmaButton, sniperButton, scatterButton, cannonButton, poisonButton;

   private JLabel bank, bPrice, pPrice, sPrice, scPrice, cPrice, poPrice, level;
      
   private ImageIcon basicIcon, plasmaIcon, sniperIcon, scatterIcon, cannonIcon, poisonIcon;

   static JLabel label1, label2, label3;

   private int basicNum = 0;
   private int plasmaNum = 0;
   private int sniperNum = 0;
   private int scatterNum = 0;
   private int cannonNum = 0;
   private int poisonNum = 0;
   private int brickNum = 0;

   private int basicPrice = 25;
   private int plasmaPrice = 200;
   private int sniperPrice = 1500;
   private int scatterPrice = 10000;
   private int cannonPrice = 75000;
   private int poisonPrice = 75000;

   private int levelNumber = 1;
   private int dollars = 999999;

   JFrame frame;

   public BreakoutPanel(JFrame f) {
      myOwner = f;
      setPreferredSize(new Dimension(FRAMEx, FRAMEy));
      setLayout(new BorderLayout());
      
      label1 = new JLabel("");
      label2 = new JLabel("");
      label3 = new JLabel("");
      
   
      frame = new JFrame("Upgrades");
      frame.setSize(800, 600);
      frame.setLocation(150, 150);
      frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
      upgradePanel = new UpgradePanel(frame, this, money);
      frame.setContentPane(upgradePanel);
      frame.pack();
      //frame.addMouseListener(f);
      frame.setVisible(false);
   
      try {
         basicIcon = new ImageIcon(this.getClass().getResource("imagefiles/basicball.png"));
         Image image = basicIcon.getImage();
         Image newimage = image.getScaledInstance(75, 50, Image.SCALE_SMOOTH);
         basicIcon = new ImageIcon(newimage);
         
         plasmaIcon = new ImageIcon(this.getClass().getResource("imagefiles/plasmaball.png"));
         image = plasmaIcon.getImage();
         newimage = image.getScaledInstance(75, 50, Image.SCALE_SMOOTH);
         plasmaIcon = new ImageIcon(newimage);
         
         sniperIcon = new ImageIcon(this.getClass().getResource("imagefiles/sniperball.png"));
         image = sniperIcon.getImage();
         newimage = image.getScaledInstance(75, 50, Image.SCALE_SMOOTH);
         sniperIcon = new ImageIcon(newimage);
      
         scatterIcon = new ImageIcon(this.getClass().getResource("imagefiles/scatterball.png"));
         image = scatterIcon.getImage();
         newimage = image.getScaledInstance(75, 50, Image.SCALE_SMOOTH);
         scatterIcon = new ImageIcon(newimage);
      
         cannonIcon = new ImageIcon(this.getClass().getResource("imagefiles/cannonball.png"));
         image = cannonIcon.getImage();
         newimage = image.getScaledInstance(75, 50, Image.SCALE_SMOOTH);
         cannonIcon = new ImageIcon(newimage);
      
         poisonIcon = new ImageIcon(this.getClass().getResource("imagefiles/poisonball.png"));
         image = poisonIcon.getImage();
         newimage = image.getScaledInstance(75, 50, Image.SCALE_SMOOTH);
         poisonIcon = new ImageIcon(newimage);
      
      } catch(Exception e) {
         System.out.println("Failed to load image icons: " + e.getMessage());
         e.printStackTrace();
      }
     
      // Create the button panel
      JPanel buttonPanel = new JPanel(new GridLayout(2, 7));
      //buttonPanel.add(pricePanel, BorderLayout.LINE_END);
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
      
   
      // Add Prices
      bPrice = new JLabel("$"+basicPrice);
      pPrice = new JLabel("$"+plasmaPrice);
      sPrice = new JLabel("$"+sniperPrice);
      scPrice = new JLabel("$"+scatterPrice);
      cPrice = new JLabel("$"+cannonPrice);
      poPrice = new JLabel("$"+poisonPrice);
   
      bank = new JLabel("$"+dollars);
      buttonPanel.add(bank, BorderLayout.PAGE_END);
   
      buttonPanel.add(bPrice, BorderLayout.CENTER);
      buttonPanel.add(pPrice, BorderLayout.CENTER);
      buttonPanel.add(sPrice, BorderLayout.CENTER);
      buttonPanel.add(scPrice, BorderLayout.CENTER);
      buttonPanel.add(cPrice, BorderLayout.CENTER);
      buttonPanel.add(poPrice, BorderLayout.CENTER);
      buttonPanel.add(pauseButton);
      
      level = new JLabel("Lvl: "+levelNumber);
      buttonPanel.add(level, BorderLayout.PAGE_END);
   
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
      allBalls = new ArrayList<Balls>();
      myImage = new BufferedImage(FRAMEx, FRAMEy, BufferedImage.TYPE_INT_RGB);
      myBuffer = myImage.getGraphics();
      myBuffer.setColor(BACKGROUND);
      myBuffer.fillRect(0,0,FRAMEx,FRAMEy);
      bluewall();
      JLabel ballplayground = new JLabel(new ImageIcon(myImage));
      ballplayground.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent e) {
            mouseClickedFunction(e);
            
            //System.out.println(e.getPoint().getX());
            //System.out.println(e.getPoint().getY());
         }
     });
      add(ballplayground, BorderLayout.CENTER);
   
      t = new Timer(5, new AnimationListener());
      t.start();
   }
   
   public void mouseClickedFunction(MouseEvent e){
      double xcoord = e.getPoint().getX();
      double ycoord = e.getPoint().getY();
      for (Brick currentBrick: allBricks){
         if ((int)xcoord > currentBrick.getX() && (int)xcoord < currentBrick.getX()+50 && (int)ycoord+60 > currentBrick.getY() && (int)ycoord+60 < currentBrick.getY()+25){
            currentBrick.setBrickValue(currentBrick.getBrickValue()-1);
            dollars ++;
         } 
      }
   }
   
   public void bluewall(){
      int xcoord = 200;
      int ycoord = 150;
      int lockedycoord = 150;
      for (int w = 0; w < 2; w++){
         for (int i = 0; i < 5; i++){
            for (int x = 0; x < 5; x++){
               BrickClass b1 = new BrickClass(xcoord+50, ycoord+25, Color.BLUE, levelNumber);//Color.BLUE, 80, 30, "1");
               animationObjects.add(b1);
               allBricks.add(b1);
               brickNum++;
               ycoord+=25;
            }
            xcoord+=50;
            ycoord=lockedycoord;
         }
      
         xcoord+=150;
         ycoord = lockedycoord;
         for (int i = 0; i < 5; i++){
            for (int x = 0; x < 5; x++){
               BrickClass b1 = new BrickClass(xcoord+50, ycoord+25, Color.BLUE, levelNumber);//Color.BLUE, 80, 30, "1");
               animationObjects.add(b1);
               allBricks.add(b1);
               brickNum++;
               ycoord+=25;
            }
            xcoord+=50;
            ycoord=lockedycoord;
         }
         xcoord = 200;
         lockedycoord = 425;
         ycoord = 425;
      }
      
   }

   public void animate() {
      
      int totalBalls = basicNum + plasmaNum + sniperNum + scatterNum + cannonNum + poisonNum;
      int totalBricks = brickNum;
      bank.setText("$"+dollars);
      bPrice.setText("$"+basicPrice);
      pPrice.setText("$"+plasmaPrice);
      sPrice.setText("$"+sniperPrice);
      scPrice.setText("$"+scatterPrice);
      cPrice.setText("$"+cannonPrice);
      poPrice.setText("$"+poisonPrice);
   
      myBuffer.setColor(BACKGROUND);
      myBuffer.fillRect(0,0,FRAMEx,FRAMEy);
      
      for(int i = 0; i < totalBalls; i++) { //Iterates through all of the balls within the list
         Balls currentBall = allBalls.get(i); //Gets the currentball
         Brick checkBrick = currentBall.isColliding(allBricks);
         if(checkBrick.getBrickValue() != -10) {
            if (currentBall.getDamage() <= checkBrick.getBrickValue()){
               dollars += Math.abs(currentBall.getDamage());
            }
            else if (currentBall.getDamage() > checkBrick.getBrickValue()){
               dollars += Math.abs(checkBrick.getBrickValue());
            }
            currentBall.collide(checkBrick);
         }
         currentBall.step();
         bank.setText("$"+dollars);
      }
      int counter = -1;
      ArrayList<Brick> tempBrickArray = new ArrayList<Brick>();
      for (Brick currentBrick: allBricks){
         tempBrickArray.add(currentBrick);
      }
      for (Brick currentBrick: tempBrickArray){
         counter++;
         if (currentBrick.getBrickValue() % 10 == 0) {
            currentBrick.setColor(Color.BLUE);
         }
         if (currentBrick.getBrickValue() % 10 == 1) {
            currentBrick.setColor(Color.RED);
         }
         if (currentBrick.getBrickValue() % 10 == 2) {
            currentBrick.setColor(Color.GREEN);
         }
         if (currentBrick.getBrickValue() % 10 == 3) {
            currentBrick.setColor(Color.PINK);
         }
         if (currentBrick.getBrickValue() % 10 == 4) {
            currentBrick.setColor(Color.YELLOW);
         }
         if (currentBrick.getBrickValue() % 10 == 5) {
            currentBrick.setColor(Color.ORANGE);
         }
         if (currentBrick.getBrickValue() % 10 == 6) {
            currentBrick.setColor(Color.BLUE.brighter().brighter());
         }
         if (currentBrick.getBrickValue() % 10 == 7) {
            currentBrick.setColor(new Color(160, 32, 240));
         }
         if (currentBrick.getBrickValue() % 10 == 8) {
            currentBrick.setColor(Color.RED.darker());
         }
         if (currentBrick.getBrickValue() % 10 == 9) {
            currentBrick.setColor(Color.GREEN.brighter());
         }
         //System.out.println("counter: "+counter);
         if (currentBrick.getBrickValue() < 1){
            totalBricks--;
            brickNum--;
            //allBricks.remove(counter);
            //counter--;
            //System.out.println("new counter: "+counter);
            //System.out.println("totalBricks"+totalBricks);
            allBricks.remove(counter);
            counter--;
         }
         else{
            currentBrick.step();
         }
         
      }
      
      if (totalBricks == 0){
         levelNumber++;
         bluewall();
         level.setText("Lvl: "+levelNumber);
      }
      
      for(int k = 0; k < totalBalls; k++){
         BouncingCircle c = allBalls.get(k);
         c.drawMe(myBuffer);
      }
      
      for (Brick r: allBricks) {
         r.drawMe(myBuffer);
      }
      money = new Money(dollars);
      repaint();      
   }
   public Money getMoney() {
      System.out.println(money.getAmount());
      return money;
   }
   public void setMoney(int n) {
      money = new Money(n);
   }

   public BasicBall[] getAllBasicBalls() {
      BasicBall[] b = new BasicBall[allBasicBalls.size()];
      int counter = 0;
      for (BasicBall curball : allBasicBalls) {
         b[counter] = curball;
         counter++;
      }
      System.out.println("Here: "+b.length);
      return b;
   }
   public PlasmaBall[] getAllPlasmaBalls() {
      PlasmaBall[] b = new PlasmaBall[allPlasmaBalls.size()];
      for(int i = 0; i < allPlasmaBalls.size(); i++) {
         b[i] = allPlasmaBalls.get(i);
      }
      return b;
   }
   public SniperBall[] getAllSniperBalls() {
      SniperBall[] b = new SniperBall[allSniperBalls.size()];
      for(int i = 0; i < allSniperBalls.size(); i++) {
         b[i] = allSniperBalls.get(i);
      }
      return b;
   }
   public ScatterBall[] getAllScatterBalls() {
      ScatterBall[] b = new ScatterBall[allScatterBalls.size()];
      for(int i = 0; i < allScatterBalls.size(); i++) {
         b[i] = allScatterBalls.get(i);
      }
      return b;
   }
   public CannonBall[] getAllCannonBalls() {
      CannonBall[] b = new CannonBall[allCannonBalls.size()];
      for(int i = 0; i < allCannonBalls.size(); i++) {
         b[i] = allCannonBalls.get(i);
      }
      return b;
   }
   public PoisonBall[] getAllPoisonBalls() {
      PoisonBall[] b = new PoisonBall[allPoisonBalls.size()];
      for(int i = 0; i < allPoisonBalls.size(); i++) {
         b[i] = allPoisonBalls.get(i);
      }
      return b;
   }
        
   private class AnimationListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         animate();
      }
   }
   private class Listener_basic implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         if(dollars - basicPrice > 0) {
            plasmaButton.setEnabled(true);
            BasicBall ccr = new BasicBall();
            animationObjects.add(ccr);
            allBalls.add(ccr);
            allBasicBalls.add(ccr);
            basicNum++;
            dollars-=basicPrice;
            basicPrice += (int)basicPrice/2;
         }
      }
   }
   private class Listener_plasma implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         if(dollars - plasmaPrice > 0) {
            sniperButton.setEnabled(true);
            PlasmaBall ccr = new PlasmaBall();
            animationObjects.add(ccr);
            allBalls.add(ccr);
            allPlasmaBalls.add(ccr);
            plasmaNum++;
            dollars-=plasmaPrice;
            plasmaPrice += (int)((plasmaPrice * 4)/10);
         }
      }
   }
   private class Listener_sniper implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         if(dollars - sniperPrice > 0) {
            scatterButton.setEnabled(true);
            SniperBall ccr = new SniperBall();
            animationObjects.add(ccr);
            allBalls.add(ccr);
            allSniperBalls.add(ccr);
            sniperNum++;
            dollars-=sniperPrice;
            sniperPrice += (int)((sniperPrice*35)/100);
         }
      }
   }
   private class Listener_scatter implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         if(dollars - scatterPrice > 0) {
            cannonButton.setEnabled(true);
            ScatterBall ccr = new ScatterBall();
            animationObjects.add(ccr);
            allBalls.add(ccr);
            allScatterBalls.add(ccr);
            scatterNum++;
            dollars-=scatterPrice;
            scatterPrice+= (int)((scatterPrice*35)/100);
         }
      }
   }
   private class Listener_cannon implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         if(dollars - cannonPrice > 0) {
            poisonButton.setEnabled(true);
            CannonBall ccr = new CannonBall();
            animationObjects.add(ccr);
            allBalls.add(ccr);
            allCannonBalls.add(ccr);
            cannonNum++;
            dollars-=cannonPrice;
            cannonPrice+=(int)((cannonPrice *3)/10);
         }
      }
   }
   private class Listener_poison implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         if(dollars - poisonPrice > 0) {
            PoisonBall ccr = new PoisonBall();
            animationObjects.add(ccr);
            allBalls.add(ccr);
            allPoisonBalls.add(ccr);
            poisonNum++;
            dollars-=poisonPrice;
            poisonPrice += (int)((poisonPrice *3)/10);
         }
      }
   }
   private class Listener_upgrade implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         System.out.println("Upgrade Menu Open");
         frame.setVisible(true);
      }
   }
   private class Listener_pause implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         if (pauseButton.getText().equals("Pause")) {
            pauseButton.setText("Unpause");
            t.stop();
         } else {
            pauseButton.setText("Pause");
            t.start();
         }
      } 
   }

   ////////////  Mouse Input Stuff /////////////
   /*
   private class Mouse extends MouseAdapter
   {
      public void mouseClicked(MouseEvent e)
      {
         update( e.getX() , e.getY() );
      }
   }   
   private void update(int x, int y)
   {

   //
      display.update(x,y);
      scoreboard.update(display.getCol(),display.getRow(),rgb);
   //
      display.repaint();
   //
      display.requestFocus();
   } */
}

