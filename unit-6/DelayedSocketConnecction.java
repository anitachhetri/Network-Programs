import java.io.*;
import java.net.*;

public class DelayedSocketConnecction {
    public static void main(String[] args) {
        // Create an unconnected socket
        Socket socket = new Socket();

        // Define the server address and port (time server at NIST)
        SocketAddress address = new InetSocketAddress("time.nist.gov", 13);

        try {
            // Attempt to connect to the server with a timeout of 5 seconds (5000 ms)
            System.out.println("Connecting to the time server...");
            socket.connect(address, 5000);
            System.out.println("Connected successfully!");
            
            // Create a BufferedReader to read data from the server
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Read and print the server response
            String serverTime;
            while ((serverTime = reader.readLine()) != null) {
                System.out.println("Server time: " + serverTime);
            }
            
            // Close resources
            reader.close();
            socket.close();
        } catch (IOException e) {
            // Handle exceptions related to network connection
            System.out.println("Error: " + e.getMessage());
        }
    }
}
