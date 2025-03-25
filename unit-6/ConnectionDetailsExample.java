import java.net.*;
import java.io.*;

public class ConnectionDetailsExample {
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

            // Close the socket to release resources
            socket.close();
        } catch (IOException e) {
            // Handle exceptions related to networking
            System.out.println("Error: " + e.getMessage());
        }
    }
}
