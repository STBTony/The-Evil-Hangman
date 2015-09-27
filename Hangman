package Hangman;
import java.util.*;
import java.io.*;
public class Hangman {
    private ArrayList word;
    private String[] output;
    public Hangman(){
        word = new ArrayList();
    }
    private Scanner s= new Scanner(System.in);
    public int maxL(){
        int temp = 0;
        for(int i = 0;i<word.size();i++){
            if(String.valueOf(word.get(i)).length()>temp){
                temp = String.valueOf(word.get(i)).length();
            }
        }
        return temp;
    }
    
    
    /**
     * method 1: to prompt user to input an integer as the length of the word
     * pre: a positive integer must be inputed
     * post: all the words that satisfy the length is stored in the array
     */
    public int askForLength(int length){
        Boolean temp = erase(length);
        output = new String[length];
        if(!temp){
           return -1;
        }
        return length;
    }
    /**
     * method 2: to prompt user to input a letter as a guess and eliminate all the words containing the letter in the arraylist
     * pre: a valid letter must be input
     * post: all the words containing the letter in the array list has been eliminated
     */
    public boolean ifWon(String letter){
        
        boolean temp =false;
        for(int i = 0;i<word.size();i++){
            if(String.valueOf(word.get(i)).indexOf(letter)>=0){
                temp = true;
            }
        }
        if(!temp){
            return false;
        }
        else{
            if(word.size()==2){
                String str = String.valueOf(word.get(0));
                if(str.contains(letter))
                    word.remove(0);
                else
                    word.remove(1);
            }
            transform(letter);
        }
        temp=false;
        for(int i = 0;i<word.size();i++){
            if(String.valueOf(word.get(i)).indexOf(letter)>=0){
                temp = true;
            }
        }
        return temp;
    }
    public void transform(String letter){   
        int[] temp = new int[word.size()];
        for(int i =0;i<temp.length;i++){
            String t = String.valueOf(word.get(i));
            for(int r = 0;r<t.length();r++){
                if(String.valueOf(t.charAt(r)).equals(letter)){
                    temp[i] +=(int)Math.pow(10, t.length()-r-1);
                }
            }
        }
        
        int te = (int)Math.pow(2,String.valueOf(word.get(0)).length());
           //temp will finally be the amount of "family"
        int[][] numbers=new int [2][te]; 
        /*To fill the first row with "code"*/
        int c=0,e=0;
        numbers[0][0]=temp[0];
        while(c<numbers[0].length-1&&e<temp.length-1){
            if(numbers[0][c]!=temp[e+1]){
                c++;
                numbers[0][c]=temp[e+1]; 
            }e++;
        }
        for (int r=0;r<numbers[0].length;r++)    {    
            numbers[1][r]=0;
            for (int i=0;i<temp.length;i++)   {
                if(temp[i]==numbers[0][r])   {
                    numbers[1][r]++;
                }
            }
        }
        int index=0;
        int max=0;
        for(int i =0;i<numbers[1].length;i++){
            if(index<numbers[1][i]){
                index=numbers[1][i];
                max=numbers[0][i];
            }
        }
        ArrayList list = new ArrayList();
        for(int i =0;i<temp.length;i++){
            if(temp[i]==max){
                list.add(word.get(i));
            }
        }
        word = list;
    }

    
    public boolean readD(String dir){
        boolean temp = false;
        try{
            File file = new File(dir);
            FileReader in;
            BufferedReader readFile;
            String line;
            
            in = new FileReader(file);
            readFile = new BufferedReader(in);
            while((line = readFile.readLine())!=null){
                word.add(line);
                temp = true;
            }
            readFile.close();
            in.close();
        }catch(FileNotFoundException a){
            System.out.println(a.getMessage());
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        return temp;
    }
    
    //erase the words with the different length
    //return true if erased, false if not
    public boolean erase(int length){
        boolean temp=false;
        int c = 0;
        while(word.size()>c){
            if(String.valueOf(word.get(c)).length()!=length){
                word.remove(c);
                temp = true;
            }else{
                c++;
            }
            
        }
        return temp;
    }
    //erase the words with the letter in them
    //return true if the user gussed the right letter, false if not
    public String[] output(String letter){
        for(int i = 0;i<String.valueOf(word.get(0)).length();i++){
            if(String.valueOf(String.valueOf(word.get(0)).charAt(i)).equals(letter)){
                output[i]=String.valueOf(String.valueOf(word.get(0)).charAt(i));
            }
            else if(output[i]==null){
                output[i]=" - ";
            }
        }
        return output;
    }
    public int getWordF(){
        return word.size();
    }
    public ArrayList getWord(){
        return word;
    }
    public int getTotal(){
        int total;
        total = word.size();
        return total;
    }
}
