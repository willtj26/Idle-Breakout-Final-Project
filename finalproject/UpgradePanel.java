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
    private JButton exitButton, basicSpeedButton, basicDamageButton, plasmaSpeedButton, plasmaDamageButton, sniperSpeedButton,  sniperDamageButton, scatterDamageButton, scatterBabiesButton, cannonSpeedButton,  cannonDamageButton, poisonSpeedButton, poisonDamageButton;
    private ImageIcon basicIcon, plasmaIcon, sniperIcon, scatterIcon, cannonIcon, poisonIcon;

    private JLabel basicSpeedLabel, plasmaSpeedLabel, sniperSpeedLabel, scatterBabiesLabel, cannonSpeedLabel, poisonSpeedLabel, basicDamageLabel, plasmaDamageLabel, sniperDamageLabel, scatterDamageLabel, cannonDamageLabel, poisonDamageLabel;

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
    public boolean windowIsOpen;

    private BasicBall[] allBasicBalls;
    private PlasmaBall[] allPlasmaBalls;
    private SniperBall[] allSniperBalls;
    private ScatterBall[] allScatterBalls;
    private CannonBall[] allCannonBalls;
    private PoisonBall[] allPoisonBalls;

    public UpgradePanel(JFrame f, BreakoutPanel b, Money m) {
        setPreferredSize(new Dimension(FRAMEx, FRAMEy));
        setLayout(new BorderLayout());
        money = m;

        allBasicBalls = b.getAllBasicBalls();
        allPlasmaBalls = b.getAllPlasmaBalls();
        allSniperBalls = b.getAllSniperBalls();
        allScatterBalls = b.getAllScatterBalls();
        allCannonBalls = b.getAllCannonBalls();
        allPoisonBalls = b.getAllPoisonBalls();

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
        JPanel buttonPanel = new JPanel(new GridLayout(5, 6));
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

        basicDamageButton.addActionListener(new Listener_basicDamage());
        plasmaDamageButton.addActionListener(new Listener_plasmaDamage());
        sniperDamageButton.addActionListener(new Listener_sniperDamage());
        scatterDamageButton.addActionListener(new Listener_scatterDamage());
        cannonDamageButton.addActionListener(new Listener_cannonDamage());
        poisonDamageButton.addActionListener(new Listener_poisonDamage());

        basicDamageLabel = new JLabel("" + basicDamagePrice + "\n \n");
        plasmaDamageLabel = new JLabel("" + plasmaDamagePrice + "\n \n");
        sniperDamageLabel = new JLabel("" + sniperDamagePrice + "\n \n");
        scatterDamageLabel = new JLabel("" + scatterDamagePrice + "\n \n");
        cannonDamageLabel = new JLabel("" + cannonDamagePrice + "\n \n");
        poisonDamageLabel = new JLabel("" + poisonDamagePrice + "\n \n");

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
            System.out.println("speed pressed");
            if (allBasicBalls.length >0) {
                if(money.getAmount() - basicSpeedPrice > 0) {
                    money.decreaseAmount(basicSpeedPrice);
                    basicSpeedPrice += (int)(basicSpeedPrice *2);
                    basicSpeedLabel.setText("$"+basicSpeedPrice);
                    for(int i = 0; i < allBasicBalls.length ; i++) {
                        BasicBall curBall = allBasicBalls[i];
                        if(curBall.getDY() > 0) {
                            allBasicBalls[i].setDY(curBall.getDY() + 1);
                            allBasicBalls[i].setdX(curBall.getdX() + 1);
                        }
                        else {
                            allBasicBalls[i].setDY(curBall.getDY() - 1);
                            allBasicBalls[i].setdX(curBall.getdX() - 1);
                        }
                    }
                }
            }
        }
    }
     
     private class Listener_plasmaSpeed implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(money.getAmount() - plasmaSpeedPrice > 0) {
                money.decreaseAmount(plasmaSpeedPrice);
                plasmaSpeedPrice += (int)(plasmaSpeedPrice *2);
                plasmaSpeedLabel.setText(""+plasmaSpeedPrice);
                for(int i = 0; i < allPlasmaBalls.length ; i++) {
                    PlasmaBall curBall = allPlasmaBalls[i];
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
     private class Listener_sniperSpeed implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(money.getAmount() - sniperSpeedPrice > 0) {
                money.decreaseAmount(sniperSpeedPrice);
                sniperSpeedPrice += (int)(sniperSpeedPrice *2);
                sniperSpeedLabel.setText(""+sniperSpeedPrice);
                for(int i = 0; i < allBasicBalls.length ; i++) {
                    BasicBall curBall = allBasicBalls[i];
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
     private class Listener_scatterBaby implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(money.getAmount() - scatterBabiesPrice > 0) {
                money.decreaseAmount(scatterBabiesPrice);
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
            if(money.getAmount() - cannonSpeedPrice > 0) {
                money.decreaseAmount(cannonSpeedPrice);
                cannonSpeedPrice += (int)(cannonSpeedPrice *2);
                cannonSpeedLabel.setText(""+cannonSpeedPrice);
                for(int i = 0; i < allCannonBalls.length ; i++) {
                    CannonBall curBall = allCannonBalls[i];
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
     private class Listener_poisonSpeed implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(money.getAmount() - poisonSpeedPrice > 0) {
                money.decreaseAmount(poisonSpeedPrice);
                poisonSpeedPrice += (int)(poisonSpeedPrice *2);
                poisonSpeedLabel.setText(""+poisonSpeedPrice);
                for(int i = 0; i < allPoisonBalls.length ; i++) {
                    PoisonBall curBall = allPoisonBalls[i];
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


     private class Listener_basicDamage implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(money.getAmount() - basicDamagePrice > 0) {
                money.decreaseAmount(basicDamagePrice);
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
            if(money.getAmount() - plasmaDamagePrice > 0) {
                money.decreaseAmount(plasmaDamagePrice);
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
            if(money.getAmount() - sniperDamagePrice > 0) {
                money.decreaseAmount(sniperDamagePrice);
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
            if(money.getAmount() - scatterDamagePrice > 0) {
                money.decreaseAmount(scatterDamagePrice);
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
            if(money.getAmount() - cannonDamagePrice > 0) {
                money.decreaseAmount(cannonDamagePrice);
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
            if(money.getAmount() - poisonDamagePrice > 0) {
                money.decreaseAmount(poisonDamagePrice);
                poisonDamagePrice += (int)(poisonDamagePrice *2);
                poisonDamageLabel.setText(""+poisonDamagePrice);
                for(int i = 0; i < allPoisonBalls.length ; i++) {
                    PoisonBall curBall = allPoisonBalls[i];
                    curBall.increaseDamage();
                }
            }
        }
     }
     
}
