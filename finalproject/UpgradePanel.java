import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.ArrayList;


class UpgradePanel extends JPanel {

    public static final int FRAMEx = 900;
    public static final int FRAMEy = 600;
    public JFrame f;

    private Timer t;

    private ArrayList<Animatable> animationObjects;

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

    public UpgradePanel(JFrame f) {
        setPreferredSize(new Dimension(FRAMEx, FRAMEy));
        setLayout(new BorderLayout());
  
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

        JLabel label = new JLabel(basicIcon, JLabel.CENTER);
        buttonPanel.add(label);
        JLabel label1 = new JLabel(plasmaIcon, JLabel.CENTER);
        buttonPanel.add(label1);
        JLabel label2 = new JLabel(sniperIcon, JLabel.CENTER);
        buttonPanel.add(label2);
        JLabel label3 = new JLabel(scatterIcon, JLabel.CENTER);
        buttonPanel.add(label3);
        JLabel label4 = new JLabel(cannonIcon, JLabel.CENTER);
        buttonPanel.add(label4);
        JLabel label5 = new JLabel(poisonIcon, JLabel.CENTER);
        buttonPanel.add(label5);

        buttonPanel.add(basicSpeedButton);
        buttonPanel.add(plasmaSpeedButton);
        buttonPanel.add(sniperSpeedButton);
        buttonPanel.add(scatterBabiesButton);
        buttonPanel.add(cannonSpeedButton);
        buttonPanel.add(poisonSpeedButton);

        buttonPanel.add(basicSpeedLabel);
        buttonPanel.add(plasmaSpeedLabel);
        buttonPanel.add(sniperSpeedLabel);
        buttonPanel.add(scatterBabiesLabel);
        buttonPanel.add(cannonSpeedLabel);
        buttonPanel.add(poisonSpeedLabel);
        
        basicDamageButton = new JButton("Basic Damage +1");
        plasmaDamageButton = new JButton("Plasma Damage +5");
        sniperDamageButton = new JButton("Sniper Damage +5");
        scatterDamageButton = new JButton("Scatter Damage +10");
        cannonDamageButton = new JButton("Cannon Damage +25");
        poisonDamageButton = new JButton("Poison Damage +25");

        basicDamageLabel = new JLabel("" + basicDamagePrice);
        plasmaDamageLabel = new JLabel("" + plasmaDamagePrice);
        sniperDamageLabel = new JLabel("" + sniperDamagePrice);
        scatterDamageLabel = new JLabel("" + scatterDamagePrice);
        cannonDamageLabel = new JLabel("" + cannonDamagePrice);
        poisonDamageLabel = new JLabel("" + poisonDamagePrice);

        buttonPanel.add(basicDamageButton);
        buttonPanel.add(plasmaDamageButton);
        buttonPanel.add(sniperDamageButton);
        buttonPanel.add(scatterDamageButton);
        buttonPanel.add(cannonDamageButton);
        buttonPanel.add(poisonDamageButton);

        buttonPanel.add(basicDamageLabel);
        buttonPanel.add(plasmaDamageLabel);
        buttonPanel.add(sniperDamageLabel);
        buttonPanel.add(scatterDamageLabel);
        buttonPanel.add(cannonDamageLabel);
        buttonPanel.add(poisonDamageLabel);



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
        animationObjects = new ArrayList<Animatable>();
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
                frame.dispose();
            }
        }
    }
    
    
     private class Listener_basicSpeed implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        //    if(dollars - basicPrice > 0) {
        //       dollars -= 
        //    }
        }
     }
     private class Listener_plasmaSpeed implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        //    if(dollars - basicPrice > 0) {
        //       dollars -= 
        //    }
        }
     }
     private class Listener_sniperSpeed implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        //    if(dollars - basicPrice > 0) {
        //       dollars -= 
        //    }
        }
     }
     private class Listener_scatterBaby implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        //    if(dollars - basicPrice > 0) {
        //       dollars -= 
        //    }
        }
     }
     private class Listener_cannonSpeed implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        //    if(dollars - basicPrice > 0) {
        //       dollars -= 
        //    }
        }
     }
     private class Listener_poisonSpeed implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        //    if(dollars - basicPrice > 0) {
        //       dollars -= 
        //    }
        }
     }

}
