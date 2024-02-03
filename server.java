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

public class server {

    public static void main(String[] args) throws Exception {

        int portNumber = 8888;

        if(args.length == 0) {
            System.out.println("Usage: java TCPServer <port number>");
            System.out.println("The default port is 8888\n");
        } else {
            portNumber = Integer.parseInt(args[0]); 
        } 

        System.out.println("The TCP Server is running....");   
        ServerSocket server_socket = new ServerSocket(portNumber);
        byte[] receive_data = new byte[1024];
        byte[] send_data = new byte[1024];

        do {
            Socket socket = server_socket.accept();
            
            InputStream input = socket.getInputStream();
            
            DataInputStream dis = new DataInputStream(input);
            
            String sentence = dis.readUTF();
            
            System.out.println("Your message is: " + sentence);
            
            String strServerResponce = sentence.toUpperCase();
            
            send_data = strServerResponce.getBytes();
            
            OutputStream output = socket.getOutputStream();
            
            output.write(send_data);
            
            socket.close();
        } while (true);
    }
}