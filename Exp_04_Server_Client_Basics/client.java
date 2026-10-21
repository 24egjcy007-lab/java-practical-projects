import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Advanced Java Lab: Client-Server Communication using TCP Sockets.
 * Start server.java before running this client.
 */
public class client {
    private static final String HOST = "localhost";
    private static final int PORT = 5000;

    public static void main(String[] args) {
        try (
            Socket socket = new Socket(HOST, PORT);
            BufferedReader input = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in)
        ) {
            System.out.print("Enter a message to send to the server: ");
            String message = scanner.nextLine();

            output.println(message);
            String response = input.readLine();

            System.out.println("Server response: " + response);
        } catch (IOException e) {
            System.err.println("Could not connect to server: " + e.getMessage());
            System.err.println("Make sure server.java is running first on port " + PORT + ".");
        }
    }
}
