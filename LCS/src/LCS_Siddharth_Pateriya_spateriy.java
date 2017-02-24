/*
 Siddharth Pateriya - Person Number 50206348
 UB CSE-531 - Fall 2016 ; Project 2
 */


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/*
This is a Java program to output a Longest Commmon Subsequence from two strings given in a file input.txt.
The result is written to a file "output.txt".
*/

/**
 *
 * @author Siddharth1
 */
public class LCS_Siddharth_Pateriya_spateriy {
public static String lcs(String s1, String s2) {
    StringBuffer lcs = new StringBuffer();

    int[][] opt = new int[s1.length()+1][s2.length()+1];  // Create 2D array of size of lengths of strings of form opt[i][j]
    int[][] res = new int[s1.length()+1][s2.length()+1]; // Array to store arrows(1,2,3 : Diagonal, Left and Up respectively
    
     //Set initial values in opt[i][0] and opt[0][j] to null
    for (int i = 0; i<= s1.length(); i++)
    {
    opt[i][0] = 0;
    }
    for (int j = 0; j<= s2.length(); j++)
    {
    opt[0][j] = 0;
    }
    
    for (int i = 1; i <= s1.length(); i++){
     for (int j = 1; j <= s2.length(); j++){
        if (s1.charAt(i-1) == s2.charAt(j-1)){
            //If character matches
                opt[i][j] = opt[i-1][j-1] + 1;
                res[i][j] = 1; //Diagonal
        }
            else
                //If character doesn't match
             if (opt[i][j-1]>= opt[i-1][j]){
                opt[i][j] = opt[i][j-1];
                res[i][j] = 2; //Left
             }
             else{
                opt[i][j] = opt[i-1][j];
                res[i][j] = 3 ;//Up

             }
     }}
    
    //Finding LCS

      int x = s1.length();
      int y = s2.length();
      while (x>0 && y>0){
        if (res[x][y] == 1){
            lcs.append(s1.charAt(x-1));
            x = x-1;
            y = y-1;
        }
        else
            if (res[x][y] == 2)
            {
                y = y-1;
            }
            else
            {
                x = x-1;
            }

      }       
       
      return lcs.reverse().toString();
  
}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
          Scanner in = new Scanner(new File("input.txt"));
        String ofile = "output.txt";
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ofile))); 
        
        String a = in.nextLine();         //Read first line
        String b = in.nextLine();         //Read second line
        
        String result = lcs(a,b);
        
        int len = result.length();
          if (len == 0)             //If no LCS found, set result as NULL
          {result = "NULL";}
          
           bw.write(len + "\t");   //Write length of LCS
            bw.newLine();
            bw.write(result);                  //Write LCS
            
            bw.close();
        
        }
    }
    

