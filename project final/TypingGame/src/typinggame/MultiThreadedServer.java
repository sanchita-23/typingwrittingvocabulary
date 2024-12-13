package typinggame;

import java.io.*;
import java.net.*;

public class MultiThreadedServer {
    private static final int PORT = 12346;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is running on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}

class ClientHandler extends Thread {
    private Socket clientSocket;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

            out.println("Welcome to the Typing Speed Game. Type 'START' to begin or 'EXIT' to quit.");

            String request;
            while ((request = in.readLine()) != null) {
                if (request.equalsIgnoreCase("START")) {
                    out.println("Type the following sentence: 'The quick brown fox jumps over the lazy dog.'");
                } else if (request.startsWith("TYPED_TEXT")) {
                    String typedText = request.substring(11);
                    int wpm = calculateWPM(typedText);
                    int accuracy = calculateAccuracy("The quick brown fox jumps over the lazy dog.", typedText);
                    out.println("WPM: " + wpm + ", Accuracy: " + accuracy + "%");
                } else if (request.equalsIgnoreCase("EXIT")) {
                    out.println("Goodbye!");
                    break;
                } else {
                    out.println("Unknown command.");
                }
            }
        } catch (IOException e) {
            System.out.println("Client connection error: " + e.getMessage());
        }
    }

    private int calculateWPM(String input) {
        int wordCount = input.split("\\s+").length;
        return wordCount * 12; // Assuming typing in 5 seconds for demo
    }

    private int calculateAccuracy(String original, String input) {
        int correctChars = 0;
        for (int i = 0; i < Math.min(original.length(), input.length()); i++) {
            if (original.charAt(i) == input.charAt(i)) {
                correctChars++;
            }
        }
        return (correctChars * 100) / original.length();
    }
}