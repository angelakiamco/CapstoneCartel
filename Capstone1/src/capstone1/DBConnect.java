/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package capstone1;
import java.awt.*;
import java.net.*;
import java.io.*;
/**
 *
 * @author angel
 */
public class DBConnect {
    
    private BufferedReader in;
    private PrintWriter out;
    private boolean connected = false;
    
    private void connect(){
    try{
        Socket s = new Socket("localhost", 5069);
        in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        out = new PrintWriter(s.getOutputStream(),true);
        connected = true;       
    }catch(IOException ioe){
        System.out.println(ioe);
    }
        
    }
    
    public static void main (String[] args){
        new DBConnect();
    }
            
}
