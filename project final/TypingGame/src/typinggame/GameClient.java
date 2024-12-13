package typinggame;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class GameClient {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 12346;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_HOST, SERVER_PORT);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println(in.readLine()); // Welcome message

            while (true) {
                System.out.println("Type a command (START, EXIT): ");
                String command = scanner.nextLine();
                out.println(command);

                if (command.equalsIgnoreCase("EXIT")) {
                    System.out.println(in.readLine());
                    break;
                } else if (command.equalsIgnoreCase("START")) {
                    System.out.println(in.readLine()); // Instruction
                    String sentence = in.readLine(); // Typing task
                    System.out.println(sentence);

                    System.out.print("Your input: ");
                    String userInput = scanner.nextLine();
                    out.println(userInput);

                    // Receive results
                    System.out.println(in.readLine()); // WPM
                    System.out.println(in.readLine()); // Accuracy
                } else {
                    System.out.println(in.readLine()); // Unknown command message
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}