package org.example;

import java.io.*;
import java.net.Socket;
import java.util.*;

public class Client {
    public static void main(String[] args)  {
        try {
            Socket socket = new Socket("localhost", 3002);
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream=new DataInputStream(socket.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String message = "";
            String reply = "";

            while (!message.equals("finish")) {
                // Read user input
                reply = bufferedReader.readLine();

                // Send the user input to the server
                dataOutputStream.writeUTF(reply);
                dataOutputStream.flush();

                // Receive and print the server's response
                message = dataInputStream.readUTF();
                System.out.println("Server: " + message);
            }

            // Close streams and socket
            dataInputStream.close();
            dataOutputStream.close();
            bufferedReader.close();
            socket.close();

        } catch(IOException e){
            }
    }
}