package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Server {
    public static void main(String[] args) {
        try {
            Scanner input=new Scanner(System.in);
            ServerSocket serverSocket=new ServerSocket(3002);
            System.out.println("started");
            Socket localSpcket=serverSocket.accept();
            System.out.println("accept");
            DataInputStream dataInputStream=new DataInputStream(localSpcket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(localSpcket.getOutputStream());

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String message = "";
            String reply = "";

            while (!message.equals("finish")) {
                // Receive and print the client's message
                message = dataInputStream.readUTF();
                System.out.println("Client: " + message);

                // Read server's reply from console
                reply = bufferedReader.readLine();

                // Send the reply back to the client
                dataOutputStream.writeUTF(reply);
                dataOutputStream.flush();
            }
            } catch (IOException ex) {
        }
    }
}
