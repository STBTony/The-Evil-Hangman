/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hangman;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;


public class HGUI implements ActionListener {
    JPanel p = new JPanel(),b=new JPanel(),g=new JPanel();
    JFrame jf = new JFrame();
    JLabel j1 = new JLabel(), j2=new JLabel(), j3 = new JLabel();
    JButton jb1 = new JButton(), jb2= new JButton(),
            jb3= new JButton(),jb4= new JButton(),
            jb5=new JButton(), jb6 = new JButton();
    JTextField input = new JTextField(), input2 = new JTextField();
    boolean start, wordFamily;
    Hangman hangman = new Hangman();
    int length, maxL;
    String letter;
    boolean restart=false;
    
    
    /**
     * @param args the command line arguments
     */
    
    public void setMax(int max){
        maxL = max;
    }
    public void setLength() {
        p = new JPanel() {
            private static final long serialVersionUID = 1L;
            @Override
            protected void paintComponent(Graphics g) {
                try {
                    BufferedImage img = ImageIO.read(new File(this.getClass().getResource("14.jpg").getPath()));
                    g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }  
        };
        input = new JTextField();
        input.setBounds(150,200,100,20);
        input.addActionListener(this);
        p.setLayout(null);
        j1.setBounds(150,170,1000,20);
        j1.setText("Input the length of the words you are choosing!");
        j2.setBounds(150,300,1000,20);
        p.add(j1);
        p.add(j2);
        p.add(input);
        jb6 = new JButton("Menu");
        jb6.setText("Menu");
        jb6.setBounds(180,430,100,20);
        jb6.addActionListener(this);
        p.add(jb4);
        p.add(jb6);
        input.setActionCommand("Length");
        jf.add(p);
        jf.setBounds(20,20,820,620);
        jf.setResizable(false);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void menu() {
        j1 = new JLabel(" ");
        j2 = new JLabel(" ");
        jf = new JFrame("Evil Hangman");
        jb1 = new JButton("Start");
        jb2 = new JButton("Help");
        jb3 = new JButton("Developers");
        jb4 = new JButton("Exit");
        jb5 = new JButton("Total Number of Word Family: On ");
        p = new JPanel() {
            private static final long serialVersionUID = 1L;
            @Override
            protected void paintComponent(Graphics g) {
                try {
                    BufferedImage img = ImageIO.read(new File(this.getClass().getResource("menu.jpg").getPath()));
                    g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        p.setLayout(null);
        j1.setBounds(300,400,100,20);
        p.add(j1);
        jb1.setBounds(180, 370, 100, 20);
        p.add(jb1);
        jb2.setBounds(180, 400, 100, 20);
        p.add(jb2);
        jb3.setBounds(180,430,100,20);
        p.add(jb3);
        jb4.setBounds(180,460,100,20);
        p.add(jb4);
        jb5.setBounds(180,490,250,20);
        p.add(jb5);
        jf.add(p);
        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
        jb4.addActionListener(this);
        jb5.addActionListener(this);
        jf.setBounds(20,20,820,620);
        jf.setResizable(false);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    public boolean getWordFamily(){
        return wordFamily;
    }
    public boolean ifStart(){
        return start;
    }
    public void setLetter(int count, String word, int wordF){
        final String t = String.valueOf(count);
        jf = new JFrame();
        p = new JPanel() {
            private static final long serialVersionUID = 1L;
            @Override
            protected void paintComponent(Graphics g) {
                try {
                    BufferedImage img = ImageIO.read(new File(this.getClass().getResource(t+".jpg").getPath()));
                    g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }  
        };
            j3  = new JLabel();
            j3.setBounds(170,300,1000,20);
            j3.setText(wordF+" words are in the Family! Quite deceiving eh!");
            p.add(j3);
        
        input2 = new JTextField();
        input2.setBounds(170,250,100,20);
        input2.addActionListener(this);
        p.setLayout(null);
        j2 = new JLabel();
        j1 = new JLabel();
        j1.setBounds(130,220,1000,20);
        j2.setBounds(130,180,1000,20);
        j1.setText("GUESS A WORD, REMEMBER, ONLY ONE LETTER AT A TIME!");
        j2.setText(word);
        p.add(input2);
        p.add(j1);
        p.add(j2);
        p.add(jb4);
        input2.setActionCommand("Letter");
        jf.add(p);
        jf.setBounds(20,20,820,620);
        jf.setResizable(false);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent event) {
        String eventName = event.getActionCommand();
        if(eventName.equals("Menu")){
            jf.setVisible(false);
            menu();
        }
        else if(eventName.equals("Start")){
            start = true;
            jf.remove(p);
            setLength();
            
        }else if(eventName.equals("Total Number of Word Family: On ")){
            wordFamily=false;
            jb5.setText("Total Number of Word Family: Off ");
            jb5.setActionCommand("Total Number of Word Family: Off ");
        }else if(eventName.equals("Total Number of Word Family: Off ")){
            wordFamily = true;
            jb5.setText("Total Number of Word Family: On ");
            jb5.setActionCommand("Total Number of Word Family: On ");
        }else if(eventName.equals("Developers")){
            j1.setText("See you are pretending that you don't know these guys...");
            j1.setBounds(150,400,1000,20);
            jb3.setText("Go Back");
            jb3.setActionCommand("Go Back");
            jb1.setVisible(false);
            jb2.setVisible(false);
            jb4.setVisible(false);
            jb5.setVisible(false);
        }else if(eventName.equals("Go Back")){
            j1.setText(" ");
            jb3.setText("Developers");
            jb3.setActionCommand("Developers");
            jb1.setVisible(true);
            jb2.setVisible(true);
            jb4.setVisible(true);
            jb5.setVisible(true);
        }
        else if(eventName.equals("Quit")){
            j1.setText(" ");
            jb2.setText("Help");
            jb2.setActionCommand("Help");
            jb1.setVisible(true);
            jb3.setVisible(true);
            jb4.setVisible(true);
            jb5.setVisible(true);
            jb2.setBounds(180, 400, 100, 20);
        }else if(eventName.equals("Help")){
            j1.setText("Figure It out!");
            j1.setBounds(250,400,1000,20);
            jb2.setText("Quit");
            jb2.setActionCommand("Quit");
            jb1.setVisible(false);
            jb3.setVisible(false);
            jb4.setVisible(false);
            jb5.setVisible(false);
            jb2.setBounds(100,500,100,20);
        }else if(eventName.equals("Exit")){
            System.exit(0);
        }else if(eventName.equals("Length")){
            try{
                j2.setText("Awesome! Nothing evil so far!");
                String in = input.getText();
                int temp = Integer.parseInt(in);
                if(temp>=1&&temp<maxL){
                    length = temp;
                    jf.setVisible(false);
                }else if (temp<1){
                    j2.setText("Your input is invalid, try a better looking one.");
                }else if(temp>maxL){
                    j2.setText("Your input is tooooo big...try a smaller one :) ");
                }
            }
            catch(NumberFormatException e){
                    j2.setText("What is wrong with you? Are you trying to crash this game!?");
                    
            }
        }else if(eventName.equals("Letter")){
            letter =input.getText();
        }else if(eventName.equals("PLAYAGAIN")){
            jf.setVisible(false);
            restart = true;
        }
    }
    
    public void getResult(int temp){
        
        j1 = new JLabel();
        j1.setText("YOU HAVE ESCAPED FROM THE ROPE!"
                + "\n IMPOSSIBLEEEE!");
        j1.setBounds(180,350,1000,40);
        j1.setVisible(false);
        j2 = new JLabel(new ImageIcon("clown.jpg"));
        j2.setBounds(200,300,400,200);
        j3= new JLabel();
        j3.setText("HAHA YOU LOSERRRRRRRRRR");
        j3.setBounds(200,250,1000,20);
        jb1 = new JButton("WANNA PLAY AGAIN?");
        jb1.addActionListener(this);
        jb1.setAlignmentX(JButton.CENTER_ALIGNMENT);
        jb1.setActionCommand("PLAYAGAIN");
        jb1.setVisible(true);
        jb1.setBounds(180,400,200,20);
        jb1.addActionListener(this);
        j2.setVisible(false);
        j3.setVisible(false);
        p.add(jb1);
        p.add(j3);
        p.add(j2);
        p.add(j1);
        if(temp==14){
            j2.setVisible(true);
            j3.setVisible(true);
            
        }else{
            j1.setVisible(true);
        } 
        jf.add(p);
        jf.setResizable(false);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        Hangman hangman= new Hangman();
        boolean result=false;
        int count =0;
        String str=null;
        new HGUI().setMax(hangman.maxL());
        new HGUI().menu();
        System.out.println(new HGUI().start);
        
    }
    
    
}
