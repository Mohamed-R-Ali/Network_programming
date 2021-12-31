//Tcp client
package network;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;
import java.util.*;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.*;


public class Client {
    public static void main(String[] args) {
        try{
       Socket socket = new Socket("localhost",3000);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            Scanner read = new Scanner(System.in);
            String mes,pass,response;
            do {
                System.out.print("enter name :");
               mes = read.nextLine();
                System.out.print("enter passsword :");
               pass = read.nextLine();
               out.println(mes);
               out.println(pass);
               response = input.readLine();
               if(response.equals("valid user")){
                   System.out.println("your name :"+mes+" and password is :"+pass);
               break;
               }
               else
                    System.out.println("try valid vlaue");
               
            } while (!mes.equals("exit"));
            
        socket.close();
        }catch (IOException ex) {
           System.out.println("client error " + ex.getMessage());
            System.exit(1);
        }

    }  
}
