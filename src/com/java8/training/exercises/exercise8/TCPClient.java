package com.java8.training.exercises.exercise8;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created on 04/11/2015.
 */
public class TCPClient {
    public static void main(String argv[]) throws Exception {
        final String sentence;
        final String modifiedSentence;
        final BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        final Socket clientSocket = new Socket("localhost", 6789);
        final DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        final BufferedReader inFromServer = new BufferedReader(new
                InputStreamReader(clientSocket.getInputStream()));
        sentence = inFromUser.readLine();
        outToServer.writeBytes(sentence + '\n');
        modifiedSentence = inFromServer.readLine();
        System.out.println("FROM SERVER: " + modifiedSentence);
        clientSocket.close();
    }
}
