// File Name Alice.java

import java.net.*;
import java.io.*;

public class Alice
{

  private static String getInput(){
    String s = "";
    try{
          BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
          s = bufferRead.readLine();
      }
      catch(IOException e)
      {
          e.printStackTrace();
      }
      return s;
  }

   public static void main(String [] args)
   {
      String serverName = args[0];
      int port = Integer.parseInt(args[1]);
      try
      {  
        String break1 = getInput();
         System.out.println("Connecting to " + serverName
                             + " on port " + port);
         Socket client = new Socket(serverName, port);
         System.out.println("Just connected to "
                      + client.getRemoteSocketAddress());
         break1 = getInput();
         OutputStream outToServer = client.getOutputStream();
         DataOutputStream out =
                       new DataOutputStream(outToServer);

         out.writeUTF("Hello from "
                      + client.getLocalSocketAddress());
         InputStream inFromServer = client.getInputStream();
         DataInputStream in =
                        new DataInputStream(inFromServer);
         System.out.println("Server says " + in.readUTF());
         client.close();
      }catch(IOException e)
      {
         e.printStackTrace();
      }
   }
}
