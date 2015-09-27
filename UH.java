package hangman;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class UH implements ActionListener {
    JPanel p = new JPanel(),b=new JPanel(),g=new JPanel();
    JFrame jf,jf2;
    JLabel j1 = new JLabel(), j2=new JLabel(), j3 = new JLabel();
    JButton jb1 = new JButton(), jb2= new JButton(),
            jb3= new JButton(),jb4= new JButton(),
            jb5=new JButton();
    Hangman hangtemp = new Hangman();
    JTextField input = new JTextField(), input2 = new JTextField();
    boolean wordFamily=true;
    Hangman hangman = new Hangman();
    int length;
    public static void main(String[]args){
        new UH().menu();
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
//      p1 = new JPanel();
//      p2 = new JPanel();
//      p3 = new JPanel();
        
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
        
        //p.add(p1);
        //p.add(p2);
        //p.add(p3);
        
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
        jb5.setBounds(180,490,300,20);
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
    
    
    public void startGame() {
        hangman.readD("D:\\DISK 2\\Codes\\Hangman\\src\\Hangman\\dictionary.txt");
        p.setVisible(false);
        JPanel b = new JPanel() {
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
        input.setBounds(170,200,100,20);
        input.addActionListener(this);
        b.setLayout(null);
        j1.setBounds(170,170,1000,20);
        j1.setText("Input the length of the words you are choosing!");
        b.add(j1);
        b.add(j2);
        b.add(input);
        b.add(jb4);
        input.setActionCommand("Length");
        jf.add(b);
        jf.setBounds(20,20,820,620);
        jf.setResizable(false);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        System.out.println(input.getText());
    }
    
    public void game(int count,String word, int length,Hangman hangman){
        Hangman hangtemp = new Hangman();
        b.setVisible(false);
        j2.setVisible(false);
        input.setVisible(false);
        hangman.askForLength(length);
        System.out.println(hangman.getWord());
        final String t = String.valueOf(count);
        JPanel g = new JPanel() {
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
        if(wordFamily){
            j3  = new JLabel();
            j3.setBounds(170,300,1000,20);
            j3.setText(hangman.getWordF()+" words are in the Family! Quite deceiving eh!");
            g.add(j3);
        }
        input2 = new JTextField();
        input2.setBounds(170,250,100,20);
        input2.addActionListener(this);
        g.setLayout(null);
        j2 = new JLabel();
        j1 = new JLabel();
        j1.setBounds(130,220,1000,20);
        j2.setBounds(130,180,1000,20);
        j1.setText("GUESS A WORD, REMEMBER, ONLY ONE LETTER AT A TIME!");
        j2.setText(word);
        g.add(input2);
        g.add(j1);
        g.add(j2);
        g.add(jb4);
        input2.setActionCommand("Game");
        jf = new JFrame();
        jf.add(g);
        jf.setBounds(20,20,820,620);
        jf.setResizable(false);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
        
 
    public void actionPerformed(ActionEvent event) {
        
        String eventName = event.getActionCommand();
        if(eventName.equals("Start")){
            startGame();
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
                String in = input.getText();
                int temp = Integer.parseInt(in);
                if(temp>=1&&temp<hangman.maxL()){
                    jf.setVisible(false);
                    hangman = new Hangman();
                    hangman.readD("D:\\DISK 2\\Codes\\Hangman\\src\\Hangmandictionary.txt");
                    game(0,"_ _ _ _",temp,hangman);
                    
                }else{
                    j2.setText("Your input is invalid, try a better looking length.");
                    j2.setBounds(170,300+(int)Math.random()*50,1000,20);
                }
            }
            catch(NumberFormatException e){
                    j2.setText("Your input is invalid, try a better looking length.");
                    startGame();
                    
            }
        }else if(eventName.equals("Game")){
            boolean result=false;
            int count =0;
            while(count<14){
                String temp =String.valueOf(input2.getText()).trim();
                result = hangman.ifWon(temp);
                System.out.println(temp);
            if(!result)
                count++;
            String word ="";
            for(String str:hangman.output(temp)){
                word+=str+=" ";
            }if(word.contains("_"))
                result=false;
            if(result){
                break;
            }
            else{
              //  jf.setVisible(false);
                
                game(count,word,length,hangtemp);
            }
        }
        result(count);
        }
        
    }
    public void result(int count){
        if(count==14){
            j3 = new JLabel(new ImageIcon("clown.jpg"));
            j3.setBounds(200,200,100,300);
            j3.setAlignmentX(JLabel.CENTER_ALIGNMENT);
            g.add(j3);
            jf.add(g);
        }else{
            j3.setText("Ok, you win, big deal...");
            j3.setBounds(200,200,1000,20);
            g.add(j3);
            jf.add(g);
        }
        
    }
    
}
 
     
     
