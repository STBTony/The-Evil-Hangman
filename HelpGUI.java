package Hangman;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class HelpGUI implements ActionListener{

    final static String LABEL_TEXT = "Help message(Tony! Fill this in!)";
    JFrame hFrame;
    JPanel hContentPane;
    JLabel hLabel;
    JButton hStart,hHelp,hDeveloper,hExit;
    JTextField hTF;
    
    public HelpGUI(){
        /* Create and set up the frame */
        hFrame = new JFrame("");
        hFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        /* Create a content pane */
        hContentPane = new JPanel();
        hContentPane.setBackground(Color.white);
        
        
        hLabel = new JLabel(new ImageIcon("D:\\DISK 2\\Codes\\Hangman\\src\\Hangman\\menu.jpg"));
        hLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        hContentPane.add(hLabel);
        /* Create and add button*/
        hStart = new JButton("Start");
        
        
        //hbutton.addActionListener(this);
       // hbutton.setIcon(b);
        //hcontentPane.add(hbutton);
        
        JPanel p = new JPanel() {
            private static final long serialVersionUID = 1L;
            protected void paintComponent(Graphics g) {
                try {
                    BufferedImage img = ImageIO.read(new File(("D:\\DISK 2\\Codes\\Hangman\\src\\Hangman\\HANGMAN.jpg")));
                    g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        p.setLayout(null);
        hStart.setBounds(50, 10, 60, 20);
        p.add(hStart);
        hTF.setBounds(120, 10, 120, 20);
        p.add(hTF);
        hHelp.setBounds(50, 40, 60, 20);
        p.add(hHelp);
        
 
        hFrame.add(p);
        hStart.addActionListener(this);
        hHelp.addActionListener(this);
        
        hFrame.setResizable(false);
        hFrame.setVisible(true);
        hFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    public void actionPerformed(ActionEvent event) {
        String eventName = event.getActionCommand();
        
        if(eventName.equals("Quit")){
            hLabel.setText(" ");
            hHelp.setText("Help");
            hHelp.setActionCommand("Help");
        }else{
            hLabel.setText(LABEL_TEXT);
            hHelp.setText("Quit");
            hHelp.setActionCommand("Quit");
        }
    }
    
    private static void runGUI(){
        JFrame.setDefaultLookAndFeelDecorated(true);
        
        HelpGUI greeting = new HelpGUI();
    }
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                runGUI();
            }
        });
    }
  }
