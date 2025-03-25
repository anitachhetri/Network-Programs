import java.io.*;
import java.net.*;

public class ClientExample {
    public static void main(String[] args) {
        try {
            // Create a socket and connect to Google's web server on port 80
            Socket socket = new Socket("www.google.com", 80);

            // Get the remote (server) socket address
            SocketAddress remSocketAddress = socket.getRemoteSocketAddress();

            // Get the local (client) socket address
            SocketAddress lSocketAddress = socket.getLocalSocketAddress();

            // Print remote and local socket addresses
            System.out.println("Remote (server) address: " + remSocketAddress);
            System.out.println("Local (client) address: " + lSocketAddress);

            // Check if the socket is connected
            if (socket.isConnected()) {
                System.out.println("Socket is successfully connected.");
            }

            // Close the socket to release resources
            socket.close();
            System.out.println("Socket closed.");
        } catch (UnknownHostException e) {
            System.out.println("Unknown host: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O error: " + e.getMessage());
        }
    }
}
