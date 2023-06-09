import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.ArrayList;
import java.lang.reflect.Array;


class UpgradePanel extends JPanel {

    public static final int FRAMEx = 900;
    public static final int FRAMEy = 600;
    public JFrame f;

    private Timer t;

    private Money money;
    private JButton exitButton, basicSpeedButton, basicDamageButton, plasmaSpeedButton, plasmaDamageButton, sniperSpeedButton,  sniperDamageButton, scatterDamageButton, scatterBabiesButton, cannonSpeedButton,  cannonDamageButton, poisonSpeedButton, poisonDamageButton, mouseDamageButton;
    private ImageIcon basicIcon, plasmaIcon, sniperIcon, scatterIcon, cannonIcon, poisonIcon;

    private JLabel basicSpeedLabel, plasmaSpeedLabel, sniperSpeedLabel, scatterBabiesLabel, cannonSpeedLabel, poisonSpeedLabel, basicDamageLabel, plasmaDamageLabel, sniperDamageLabel, scatterDamageLabel, cannonDamageLabel, poisonDamageLabel, mouseDamageLabel;

    private int basicSpeedPrice = 100;
    private int plasmaSpeedPrice = 250;
    private int sniperSpeedPrice = 7500; 
    private int scatterBabiesPrice = 50000;
    private int cannonSpeedPrice = 75000;
    private int poisonSpeedPrice = 75000;
    private int basicDamagePrice = 250; 
    private int plasmaDamagePrice = 1000; 
    private int sniperDamagePrice = 8000; 
    private int scatterDamagePrice = 50000; 
    private int cannonDamagePrice = 100000;
    private int poisonDamagePrice = 100000;
    private int mouseDamagePrice = 50;
    public boolean windowIsOpen;

    private BasicBall[] allBasicBalls;
    private PlasmaBall[] allPlasmaBalls;
    private SniperBall[] allSniperBalls;
    private ScatterBall[] allScatterBalls;
    private CannonBall[] allCannonBalls;
    private PoisonBall[] allPoisonBalls;

    private BreakoutPanel bb;

    public UpgradePanel(JFrame f, BreakoutPanel b, Money m) {
        bb = b;
        setPreferredSize(new Dimension(FRAMEx, FRAMEy));
        setLayout(new BorderLayout());
        money = m;

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
        JPanel buttonPanel = new JPanel(new GridLayout(6, 6));
        buttonPanel.setBorder(new EmptyBorder(0, 30, 150, 30));
        //buttonPanel.add(pricePanel, BorderLayout.LINE_END);
  
  
        // Add the buttons
        /*
        basicSpeedButton = new JButton("Speed \n" + getSpeed() + ">>" + getSpeed()+1);
        plasmaSpeedButton = new JButton("Speed \n" + getSpeed() + ">>" + getSpeed()+5);
        sniperSpeedButton = new JButton("Speed \n" + getSpeed() + ">>" + getSpeed()+5);
        scatterBabiesButton = new JButton("Speed \n" + getSpeed() + ">>" + getSpeed()+10);
        cannonSpeedButton = new JButton("Speed \n" + getSpeed() + ">>" + getSpeed()+25);
        poisonSpeedButton = new JButton("Speed \n" + getSpeed() + ">>" + getSpeed()+25);
        exitButton = new JButton("Exit");
       */
        basicSpeedButton = new JButton("Basic Speed +1");
        plasmaSpeedButton = new JButton("Plasma Speed +1");
        sniperSpeedButton = new JButton("Sniper Speed +1");
        scatterBabiesButton = new JButton("Add Scatter Baby");
        cannonSpeedButton = new JButton("Cannon Speed +1");
        poisonSpeedButton = new JButton("Poison Speed +1");

        exitButton = new JButton("Exit");
        
        basicSpeedLabel = new JLabel(""+basicSpeedPrice);
        plasmaSpeedLabel = new JLabel(""+plasmaSpeedPrice);
        sniperSpeedLabel = new JLabel(""+sniperSpeedPrice);
        scatterBabiesLabel = new JLabel(""+scatterBabiesPrice);
        cannonSpeedLabel = new JLabel(""+cannonSpeedPrice);
        poisonSpeedLabel = new JLabel(""+poisonSpeedPrice);


  /*
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
  */
        // Add action listeners
        basicSpeedButton.addActionListener(new Listener_basicSpeed());
        plasmaSpeedButton.addActionListener(new Listener_plasmaSpeed());
        sniperSpeedButton.addActionListener(new Listener_sniperSpeed());
        scatterBabiesButton.addActionListener(new Listener_scatterBaby());
        cannonSpeedButton.addActionListener(new Listener_cannonSpeed());
        poisonSpeedButton.addActionListener(new Listener_poisonSpeed());

        exitButton.addActionListener(new Listener_exit());

        JLabel label = new JLabel(basicIcon);
        buttonPanel.add(label);
        JLabel label1 = new JLabel(plasmaIcon);
        buttonPanel.add(label1);
        JLabel label2 = new JLabel(sniperIcon);
        buttonPanel.add(label2);
        JLabel label3 = new JLabel(scatterIcon);
        buttonPanel.add(label3);
        JLabel label4 = new JLabel(cannonIcon);
        buttonPanel.add(label4);
        JLabel label5 = new JLabel(poisonIcon);
        buttonPanel.add(label5);

        buttonPanel.add(basicSpeedButton);
        buttonPanel.add(plasmaSpeedButton);
        buttonPanel.add(sniperSpeedButton);
        buttonPanel.add(scatterBabiesButton);
        buttonPanel.add(cannonSpeedButton);
        buttonPanel.add(poisonSpeedButton);

        buttonPanel.add(basicSpeedLabel, BorderLayout.NORTH);
        buttonPanel.add(plasmaSpeedLabel, BorderLayout.NORTH);
        buttonPanel.add(sniperSpeedLabel, BorderLayout.NORTH);
        buttonPanel.add(scatterBabiesLabel, BorderLayout.NORTH);
        buttonPanel.add(cannonSpeedLabel, BorderLayout.NORTH);
        buttonPanel.add(poisonSpeedLabel, BorderLayout.NORTH);
        
        basicDamageButton = new JButton("Basic Damage +1");
        plasmaDamageButton = new JButton("Plasma Damage +5");
        sniperDamageButton = new JButton("Sniper Damage +5");
        scatterDamageButton = new JButton("Scatter Damage +10");
        cannonDamageButton = new JButton("Cannon Damage +25");
        poisonDamageButton = new JButton("Poison Damage +25");

        mouseDamageButton = new JButton("Mouse Damage +1");

        basicDamageButton.addActionListener(new Listener_basicDamage());
        plasmaDamageButton.addActionListener(new Listener_plasmaDamage());
        sniperDamageButton.addActionListener(new Listener_sniperDamage());
        scatterDamageButton.addActionListener(new Listener_scatterDamage());
        cannonDamageButton.addActionListener(new Listener_cannonDamage());
        poisonDamageButton.addActionListener(new Listener_poisonDamage());

        mouseDamageButton.addActionListener(new Listener_mouseDamage());

        /*basicDamageButton.setEnabled(false);
        basicSpeedButton.setEnabled(false);
        plasmaDamageButton.setEnabled(false);
        plasmaSpeedButton.setEnabled(false);
        sniperDamageButton.setEnabled(false);
        sniperSpeedButton.setEnabled(false);
        scatterBabiesButton.setEnabled(false);
        scatterDamageButton.setEnabled(false);
        cannonDamageButton.setEnabled(false);
        cannonSpeedButton.setEnabled(false);
        poisonDamageButton.setEnabled(false);
        poisonSpeedButton.setEnabled(false);*/

        basicDamageLabel = new JLabel("" + basicDamagePrice + "\n \n");
        plasmaDamageLabel = new JLabel("" + plasmaDamagePrice + "\n \n");
        sniperDamageLabel = new JLabel("" + sniperDamagePrice + "\n \n");
        scatterDamageLabel = new JLabel("" + scatterDamagePrice + "\n \n");
        cannonDamageLabel = new JLabel("" + cannonDamagePrice + "\n \n");
        poisonDamageLabel = new JLabel("" + poisonDamagePrice + "\n \n");

       mouseDamageLabel = new JLabel("" + mouseDamagePrice);

        buttonPanel.add(basicDamageButton);
        buttonPanel.add(plasmaDamageButton);
        buttonPanel.add(sniperDamageButton);
        buttonPanel.add(scatterDamageButton);
        buttonPanel.add(cannonDamageButton);
        buttonPanel.add(poisonDamageButton);

        buttonPanel.add(basicDamageLabel, BorderLayout.NORTH);
        buttonPanel.add(plasmaDamageLabel, BorderLayout.NORTH);
        buttonPanel.add(sniperDamageLabel, BorderLayout.NORTH);
        buttonPanel.add(scatterDamageLabel, BorderLayout.NORTH);
        buttonPanel.add(cannonDamageLabel, BorderLayout.NORTH);
        buttonPanel.add(poisonDamageLabel, BorderLayout.NORTH);

       buttonPanel.add(mouseDamageButton, BorderLayout.WEST);
       buttonPanel.add(mouseDamageLabel, BorderLayout.WEST);

        buttonPanel.setBounds(50, 50, FRAMEx -100, FRAMEy -100);
        add(buttonPanel, BorderLayout.CENTER);
        add(exitButton, BorderLayout.SOUTH);
  /*
        // Create the ball bouncing area
        animationObjects = new ArrayList<Animatable>();
        allBalls = new ArrayList<Balls>();
        myImage = new BufferedImage(FRAMEx, FRAMEy, BufferedImage.TYPE_INT_RGB);
        myBuffer = myImage.getGraphics();
        myBuffer.setColor(BACKGROUND);
        myBuffer.fillRect(0,0,FRAMEx,FRAMEy);
  
        // Add the ball bouncing area
        add(new JLabel(new ImageIcon(myImage)), BorderLayout.CENTER);
  */
        t = new Timer(5, new AnimationListener());
        t.start(); 
     }
     
     public void animate() {
        /*if(money.getAmount() < basicSpeedPrice && basicSpeedButton.isEnabled()) {
            basicSpeedButton.setEnabled(false);
         }
         if(money.getAmount() < plasmaSpeedPrice && plasmaSpeedButton.isEnabled()) {
            plasmaSpeedButton.setEnabled(false);
         }
         if(money.getAmount() < sniperSpeedPrice && sniperSpeedButton.isEnabled()) {
            sniperSpeedButton.setEnabled(false);
         }
         if(money.getAmount() < scatterBabiesPrice && scatterBabiesButton.isEnabled()) {
            scatterBabiesButton.setEnabled(false);
         }
         if(money.getAmount() < cannonSpeedPrice && cannonSpeedButton.isEnabled()) {
            cannonSpeedButton.setEnabled(false);
         }
         if(money.getAmount() < poisonSpeedPrice && poisonSpeedButton.isEnabled()) {
            poisonSpeedButton.setEnabled(false);
        }
        if(money.getAmount() < basicDamagePrice && basicDamageButton.isEnabled()) {
            basicDamageButton.setEnabled(false);
         }
         if(money.getAmount() < plasmaDamagePrice && plasmaDamageButton.isEnabled()) {
            plasmaDamageButton.setEnabled(false);
         }
         if(money.getAmount() < sniperDamagePrice && sniperDamageButton.isEnabled()) {
            sniperDamageButton.setEnabled(false);
         }
         if(money.getAmount() < scatterDamagePrice && scatterDamageButton.isEnabled()) {
            scatterDamageButton.setEnabled(false);
         }
         if(money.getAmount() < cannonDamagePrice && cannonDamageButton.isEnabled()) {
            cannonDamageButton.setEnabled(false);
         }
         if(money.getAmount() < poisonDamagePrice && poisonDamageButton.isEnabled()) {
            poisonDamageButton.setEnabled(false);
        }

         
        if(money.getAmount() >= basicSpeedPrice && !basicSpeedButton.isEnabled()) {
            basicSpeedButton.setEnabled(true);
        }
        if(money.getAmount() >= plasmaSpeedPrice && !plasmaSpeedButton.isEnabled()) {
            plasmaSpeedButton.setEnabled(true);
        }
        if(money.getAmount() >= sniperSpeedPrice && !sniperSpeedButton.isEnabled()) {
            sniperSpeedButton.setEnabled(true);
        }
        if(money.getAmount() >= scatterBabiesPrice && !scatterBabiesButton.isEnabled()) {
            scatterBabiesButton.setEnabled(true);
        }
        if(money.getAmount() >= cannonSpeedPrice && !cannonSpeedButton.isEnabled()) {
            cannonSpeedButton.setEnabled(true);
        }
        if(money.getAmount() >= poisonSpeedPrice && !poisonSpeedButton.isEnabled()) {
            poisonSpeedButton.setEnabled(true);
        }

        if(money.getAmount() >= basicDamagePrice && !basicDamageButton.isEnabled()) {
            basicDamageButton.setEnabled(true);
        }
        if(money.getAmount() >= plasmaDamagePrice && !plasmaDamageButton.isEnabled()) {
            plasmaDamageButton.setEnabled(true);
        }
        if(money.getAmount() >= sniperDamagePrice && !sniperDamageButton.isEnabled()) {
            sniperDamageButton.setEnabled(true);
        }
        if(money.getAmount() >= scatterDamagePrice && !scatterDamageButton.isEnabled()) {
            scatterDamageButton.setEnabled(true);
        }
        if(money.getAmount() >= cannonDamagePrice && !cannonDamageButton.isEnabled()) {
            cannonDamageButton.setEnabled(true);
        }
        if(money.getAmount() >= poisonDamagePrice && !poisonDamageButton.isEnabled()) {
            poisonDamageButton.setEnabled(true);
        } */

        repaint();
     }     
     private class AnimationListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
           animate();
        }
     }
     private class Listener_exit implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Window window = SwingUtilities.windowForComponent(UpgradePanel.this);
            if (window instanceof JFrame) {
                JFrame frame = (JFrame) window;
                frame.setVisible(false);
            }
        }
    }
    
     
    private class Listener_basicSpeed implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            allBasicBalls = bb.getAllBasicBalls();
            Money amount = bb.getMoney();
            if (allBasicBalls.length > 0 && money != null) {
                if(amount.getAmount() - basicSpeedPrice > 0) {
                    amount.decreaseAmount(basicSpeedPrice);
                    bb.setMoney(amount.getAmount());
                    basicSpeedPrice += (int)(basicSpeedPrice *2);
                    basicSpeedLabel.setText("$"+basicSpeedPrice);
                    for(BasicBall curBall : allBasicBalls) {
                        if(curBall.getDY() > 0) {
                            curBall.setDY(curBall.getDY() + 1);
                            curBall.setdX(curBall.getdX() + 1);
                        }
                        else {
                            curBall.setDY(curBall.getDY() - 1);
                            curBall.setdX(curBall.getdX() - 1);
                        }
                    }
                }
            }
        }
    }
     
    private class Listener_plasmaSpeed implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            allPlasmaBalls = bb.getAllPlasmaBalls();
            Money amount = bb.getMoney();
            if (allPlasmaBalls.length > 0 && money != null) {
                if(amount.getAmount() - plasmaSpeedPrice > 0) {
                    amount.decreaseAmount(plasmaSpeedPrice);
                    bb.setMoney(amount.getAmount());
                    plasmaSpeedPrice += (int)(plasmaSpeedPrice *2);
                    plasmaSpeedLabel.setText("$"+plasmaSpeedPrice);
                    for(PlasmaBall curBall : allPlasmaBalls) {
                        if(curBall.getDY() > 0) {
                            curBall.setDY(curBall.getDY() + 1);
                            curBall.setdX(curBall.getdX() + 1);
                        }
                        else {
                            curBall.setDY(curBall.getDY() - 1);
                            curBall.setdX(curBall.getdX() - 1);
                        }
                    }
                }
            }
        }
    }
     private class Listener_sniperSpeed implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            allSniperBalls = bb.getAllSniperBalls();
            Money amount = bb.getMoney();
            if (allSniperBalls.length > 0 && money != null) {
                if(amount.getAmount() - sniperSpeedPrice > 0) {
                    amount.decreaseAmount(sniperSpeedPrice);
                    bb.setMoney(amount.getAmount());
                    sniperSpeedPrice += (int)(sniperSpeedPrice *2);
                    sniperSpeedLabel.setText("$"+sniperSpeedPrice);
                    for(SniperBall curBall : allSniperBalls) {
                        if(curBall.getDY() > 0) {
                            curBall.setDY(curBall.getDY() + 1);
                            curBall.setdX(curBall.getdX() + 1);
                        }
                        else {
                            curBall.setDY(curBall.getDY() - 1);
                            curBall.setdX(curBall.getdX() - 1);
                        }
                    }
                }
            }
        }
     }
     private class Listener_scatterBaby implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            allSniperBalls = bb.getAllSniperBalls();
            Money amount = bb.getMoney();
            if(amount.getAmount() - scatterBabiesPrice > 0) {
                amount.decreaseAmount(scatterBabiesPrice);
                bb.setMoney(amount.getAmount());
                scatterBabiesPrice += (int)(scatterBabiesPrice *2);
                scatterBabiesLabel.setText(""+scatterBabiesPrice);
                for(int i = 0; i < allScatterBalls.length ; i++) {
                    ScatterBall curBall = allScatterBalls[i];
                    curBall.setBabies(curBall.getBabies() + 1);
                }
            }
        }
     }
     private class Listener_cannonSpeed implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            allCannonBalls = bb.getAllCannonBalls();
            Money amount = bb.getMoney();
            if (allCannonBalls.length > 0 && money != null) {
                if(amount.getAmount() - cannonSpeedPrice > 0) {
                    amount.decreaseAmount(cannonSpeedPrice);
                    bb.setMoney(amount.getAmount());
                    cannonSpeedPrice += (int)(cannonSpeedPrice *2);
                    cannonSpeedLabel.setText("$"+cannonSpeedPrice);
                    for(CannonBall curBall : allCannonBalls) {
                        if(curBall.getDY() > 0) {
                            curBall.setDY(curBall.getDY() + 1);
                            curBall.setdX(curBall.getdX() + 1);
                        }
                        else {
                            curBall.setDY(curBall.getDY() - 1);
                            curBall.setdX(curBall.getdX() - 1);
                        }
                    }
                }
            }
        }
     }
     private class Listener_poisonSpeed implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            allPoisonBalls = bb.getAllPoisonBalls();
            Money amount = bb.getMoney();
            if (allPoisonBalls.length > 0 && money != null) {
                if(amount.getAmount() - poisonSpeedPrice > 0) {
                    amount.decreaseAmount(plasmaSpeedPrice);
                    bb.setMoney(amount.getAmount());
                    plasmaSpeedPrice += (int)(plasmaSpeedPrice *2);
                    plasmaSpeedLabel.setText("$"+plasmaSpeedPrice);
                    for(PoisonBall curBall : allPoisonBalls) {
                        if(curBall.getDY() > 0) {
                            curBall.setDY(curBall.getDY() + 1);
                            curBall.setdX(curBall.getdX() + 1);
                        }
                        else {
                            curBall.setDY(curBall.getDY() - 1);
                            curBall.setdX(curBall.getdX() - 1);
                        }
                    }
                }
            }
        }
     }


     private class Listener_basicDamage implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            allPoisonBalls = bb.getAllPoisonBalls();
            Money amount = bb.getMoney();
            if(amount.getAmount() - basicDamagePrice > 0) {
                amount.decreaseAmount(basicDamagePrice);
                bb.setMoney(amount.getAmount());
                basicDamagePrice += (int)(basicDamagePrice *2);
                basicDamageLabel.setText(""+basicDamagePrice);
                for(int i = 0; i < allBasicBalls.length ; i++) {
                    BasicBall curBall = allBasicBalls[i];
                    curBall.increaseDamage();
                }
            }
        }
     }
     private class Listener_plasmaDamage implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            allPoisonBalls = bb.getAllPoisonBalls();
            Money amount = bb.getMoney();
            if(amount.getAmount() - plasmaDamagePrice > 0) {
                amount.decreaseAmount(plasmaDamagePrice);
                bb.setMoney(amount.getAmount());
                plasmaDamagePrice += (int)(basicDamagePrice *2);
                plasmaDamageLabel.setText(""+plasmaDamagePrice);
                for(int i = 0; i < allPlasmaBalls.length ; i++) {
                    PlasmaBall curBall = allPlasmaBalls[i];
                    curBall.increaseDamage();
                }
            }
        }
     }
     private class Listener_sniperDamage implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            allPoisonBalls = bb.getAllPoisonBalls();
            Money amount = bb.getMoney();
            if(amount.getAmount() - sniperDamagePrice > 0) {
                amount.decreaseAmount(sniperDamagePrice);
                bb.setMoney(amount.getAmount());
                sniperDamagePrice += (int)(basicDamagePrice *2);
                sniperDamageLabel.setText(""+sniperDamagePrice);
                for(int i = 0; i < allSniperBalls.length ; i++) {
                    SniperBall curBall = allSniperBalls[i];
                    curBall.increaseDamage();
                }
            }
        }
     }
     private class Listener_scatterDamage implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            allPoisonBalls = bb.getAllPoisonBalls();
            Money amount = bb.getMoney();
            if(amount.getAmount() - scatterDamagePrice > 0) {
                amount.decreaseAmount(scatterDamagePrice);
                bb.setMoney(amount.getAmount());
                scatterDamagePrice += (int)(basicDamagePrice *2);
                scatterDamageLabel.setText(""+scatterDamagePrice);
                for(int i = 0; i < allScatterBalls.length ; i++) {
                    ScatterBall curBall = allScatterBalls[i];
                    curBall.increaseDamage();
                }
            }
        }
     }
     private class Listener_cannonDamage implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            allPoisonBalls = bb.getAllPoisonBalls();
            Money amount = bb.getMoney();
            if(amount.getAmount() - cannonDamagePrice > 0) {
                amount.decreaseAmount(cannonDamagePrice);
                bb.setMoney(amount.getAmount());
                cannonDamagePrice += (int)(cannonDamagePrice *2);
                cannonDamageLabel.setText(""+cannonDamagePrice);
                for(int i = 0; i < allCannonBalls.length ; i++) {
                    CannonBall curBall = allCannonBalls[i];
                    curBall.increaseDamage();
                }
            }
        }
     }
     private class Listener_poisonDamage implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            allPoisonBalls = bb.getAllPoisonBalls();
            Money amount = bb.getMoney();
            if(amount.getAmount() - poisonDamagePrice > 0) {
                amount.decreaseAmount(poisonDamagePrice);
                bb.setMoney(amount.getAmount());
                poisonDamagePrice += (int)(poisonDamagePrice *2);
                poisonDamageLabel.setText(""+poisonDamagePrice);
                for(int i = 0; i < allPoisonBalls.length ; i++) {
                    PoisonBall curBall = allPoisonBalls[i];
                    curBall.increaseDamage();
                }
            }
        }
     }
     private class Listener_mouseDamage implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Money amount = bb.getMoney();
            if(amount.getAmount() - mouseDamagePrice > 0) {
                amount.decreaseAmount(mouseDamagePrice);
                bb.setMoney(amount.getAmount());
                mouseDamagePrice += (50);
                mouseDamageLabel.setText(""+mouseDamagePrice);
                bb.increaseMouseDamage();
            }
        }
     }
     
}
