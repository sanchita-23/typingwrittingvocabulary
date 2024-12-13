package typinggame;

import java.io.*;
import java.net.*;
import java.util.*;

public class TypingServer {
    private static final int PORT = 12349; // Port number for the server
    private static final List<String> typingChallenges = Arrays.asList(
            "The quick brown fox jumps over the lazy dog.",
            "A journey of a thousand miles begins with a single step.",
            "All that glitters is not gold.",
            "Practice makes perfect, and persistence brings success.",
            "Success is not final, failure is not fatal: it is the courage to continue that counts.",
            "It always seems impossible until it is done.",
            "Believe you can and you're halfway there.",
            "Act as if what you do makes a difference. It does."
    );

    public static void main(String[] args) {
        System.out.println("Starting TypingServer...");
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("TypingServer is running on port " + PORT);

            while (true) {
                // Wait for a client connection
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getInetAddress());

                // Handle the client in a new thread
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            System.err.println("Server Error: " + e.getMessage());
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket clientSocket;

        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try (
                InputStream input = clientSocket.getInputStream();
                OutputStream output = clientSocket.getOutputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                PrintWriter writer = new PrintWriter(output, true)
            ) {
                writer.println("Welcome to the Typing Game Server!");
                writer.println("Type 'START' to begin or 'EXIT' to quit.");

                String clientMessage;
                while ((clientMessage = reader.readLine()) != null) {
                    if (clientMessage.equalsIgnoreCase("START")) {
                        // Send a random challenge to the client
                        String challenge = getRandomChallenge();
                        writer.println("Challenge: " + challenge);
                    } else if (clientMessage.equalsIgnoreCase("EXIT")) {
                        writer.println("Goodbye!");
                        break;
                    } else {
                        // Echo the client's message
                        writer.println("Received: " + clientMessage);
                    }
                }
            } catch (IOException e) {
                System.err.println("Client Error: " + e.getMessage());
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    System.err.println("Error closing client socket: " + e.getMessage());
                }
            }
        }

        private String getRandomChallenge() {
            Random random = new Random();
            return typingChallenges.get(random.nextInt(typingChallenges.size()));
        }
    }
}
