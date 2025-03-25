import java.io.IOException;
import java.net.*;

public class Socketinfo {
    public static void main(String[] args) {
        // Check if any hostnames are passed as arguments
        if (args.length == 0) {
            System.out.println("Please provide at least one hostname as an argument.");
            return;
        }

        // Iterate over each host passed as an argument
        for (String host : args) {
            Socket theSocket = null;
            try {
                // Create a socket and connect to port 80 (HTTP)
                System.out.println("Attempting to connect to " + host);
                theSocket = new Socket(host, 80);

                // Print socket details: remote and local addresses/port
                System.out.println("Connected to " + theSocket.getInetAddress() +
                        " on port " + theSocket.getPort() +
                        " from port " + theSocket.getLocalPort() +
                        " of " + theSocket.getLocalAddress());

            } catch (UnknownHostException ex) {
                // Handle case where host can't be found
                System.err.println("Could not connect to " + host + ": " + ex.getMessage());
            } catch (IOException ex) {
                // Handle general IO exceptions
                System.err.println("I/O error: " + ex.getMessage());
            } finally {
                // Ensure the socket is closed properly
                if (theSocket != null && !theSocket.isClosed()) {
                    try {
                        theSocket.close();
                        System.out.println("Socket to " + host + " closed successfully.");
                    } catch (IOException ex) {
                        System.err.println("Error closing socket: " + ex.getMessage());
                    }
                }
            }
        }
    }
}
