import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Advanced Java Lab: Client-Server Communication using TCP Sockets.
 * Run server.java first, then run client.java in another terminal.
 */
public class server {
    private static final int PORT = 5000;

    public static void main(String[] args) {
        System.out.println("Server starting on port " + PORT + "...");

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is ready. Waiting for a client...");

            while (true) {
                try (
                    Socket socket = serverSocket.accept();
                    BufferedReader input = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                    PrintWriter output = new PrintWriter(socket.getOutputStream(), true)
                ) {
                    System.out.println("Client connected: " + socket.getInetAddress());
                    String message = input.readLine();

                    if (message == null) {
                        message = "";
                    }

                    System.out.println("Client says: " + message);
                    output.println("Message received by server: " + message);
                    System.out.println("Response sent. Waiting for next client...");
                } catch (IOException e) {
                    System.err.println("Client communication error: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Could not start server: " + e.getMessage());
            System.err.println("Check whether port " + PORT + " is already in use.");
        }
    }
}
