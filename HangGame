/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hangman;
import java.util.*;
public class HangGame {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        int aM=14;   //the allowed mistakes
        int wTime=0;  //the times that user won
        //Scanner input=new Scanner(System.in);
        Hangman hhh = new Hangman(); //an object is created
        hhh.readD("D:\\DISK 2\\Codes\\Hangman\\src\\Hangman\\dictionary.txt");
        HGUI gui = new HGUI();
        boolean result=false;
        int count =0;
        String str=null;
        gui.setMax(hhh.maxL());
        gui.menu();
        if(gui.ifStart()){
            System.out.println(gui.ifStart());
            gui.setLength();
            hhh.askForLength(gui.length);
        for(int i = 0;i<gui.length;i++){
            str+="_";
        }
        while(count<=aM){
            gui.setLetter(count,str,hhh.getWordF());
            String temp =gui.letter;
            result = hhh.ifWon(temp);
            //System.out.println(hhh.getWord().toString());
            if(!result){
                count++;
            }str = null;
            for(String i:hhh.output(temp)){
                str+=i;
            }
            if(result)break;
            System.out.println(hhh.getWordF());
            System.out.println(hhh.getWord().toString());
        }
        }
        System.out.println("\n"+gui.start);
        
            
        }
        
    }
   
    
    
