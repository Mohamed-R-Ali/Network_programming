
package url_html;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

public class conn {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
         System.out.println("enetr url :");
         String url = read.nextLine();
         access(url);
    }
    public static void access(String url){
        BufferedReader br = null;
        FileWriter f = null ;
        try{
            URL u = new URL(url);
            URLConnection connect = u.openConnection();
            InputStreamReader in = new InputStreamReader(connect.getInputStream());
            br = new BufferedReader(in);
        String read = "";
        f =  new FileWriter("read url.html");
            while ((read = br.readLine()) != null) {
             f.write(read);
            }
        }catch (Exception ex) {
            System.out.println("cannot access url");
            System.exit(1);
        }finally{
            System.out.println("Data saved");
            System.out.println("closing connection");
        try{
           f.close();
        br.close();
        System.exit(1);
        }catch (Exception ex) {
            System.out.println(ex.getMessage());    
            }
        }
    
    
    }
}
