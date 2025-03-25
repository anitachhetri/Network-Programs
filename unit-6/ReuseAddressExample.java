import java.io.IOException;
import java.net.*;

public class ReuseAddressExample {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket();
            
            // Enable SO_REUSEADDR before binding the socket
            serverSocket.setReuseAddress(true);
            
            // Bind the socket to port 8080
            serverSocket.bind(new InetSocketAddress(8080));
            
            System.out.println("Server started on port 8080 with SO_REUSEADDR enabled.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
