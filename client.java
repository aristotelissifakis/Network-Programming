/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aristotelis
 */
import java.io.*;
import java.net.*;

public class client {
   public static void main(String args[]) throws Exception
   {
        String host_name = "127.0.0.1"; 
        int port_number = 8888; 
        
        if (args.length == 2) { 
           host_name = args[0]; 
           port_number = Integer.parseInt(args[1]); 
        } 
        else
        {
            System.out.println("Usage: java EchoClient <host name> <port number>"); 
            System.out.println("The default values for host and port are 127.0.0.1 and 8888\n");
        }       

      System.out.println("Type a message to send : ");        
      
      BufferedReader keybInput = new BufferedReader(new InputStreamReader(System.in));
      
      Socket clientSocket = new Socket(host_name, port_number);
      
      PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
      
      BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
      
      String sentence = keybInput.readLine();
      
      out.println(sentence);
      
      String srvResponce = in.readLine();
      
      System.out.println("The server response :" + srvResponce);
      
      clientSocket.close();
    }
}
