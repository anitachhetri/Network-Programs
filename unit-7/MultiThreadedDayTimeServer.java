import java.io.*;
import java.net.*;
import java.util.*;

public class MultiThreadedDayTimeServer {
    
    public static void main(String[] args) {
        int port = 5000; // Define a port number
        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server started on port " + port);
            
            while (true) {
                Socket client = server.accept();
                new ClientHandler(client).start();
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }
    
    static class ClientHandler extends Thread {
        private final Socket client;

        public ClientHandler(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try (Writer out = new OutputStreamWriter(client.getOutputStream())) {
                out.write(new Date().toString() + "\r\n");
                out.flush();
            } catch (IOException e) {
                System.err.println("Client error: " + e.getMessage());
            } finally {
                try {
                    client.close();
                } catch (IOException ignored) {
                }
            }
        }
    }
}