import java.io.*;
import java.net.*;

public class TimeServer {
    public static final int PORT = 37;

    public static void main(String[] args) {
        long EPOCH_DIFFERENCE = 2208988800L;
        
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Time server running on port " + PORT);
            
            while (true) {
                try (Socket connection = server.accept();
                     OutputStream out = connection.getOutputStream()) {

                    long secondsSince1900 = (System.currentTimeMillis() / 1000) + EPOCH_DIFFERENCE;
                    byte[] time = new byte[4];
                    time[0] = (byte) (secondsSince1900 >> 24);
                    time[1] = (byte) (secondsSince1900 >> 16);
                    time[2] = (byte) (secondsSince1900 >> 8);
                    time[3] = (byte) (secondsSince1900);

                    out.write(time);
                    out.flush();
                    System.out.println("Sent time to client: " + secondsSince1900);
                } catch (IOException ex) {
                    System.err.println("Connection error: " + ex.getMessage());
                }
            }
        } catch (IOException ex) {
            System.err.println("Server error: " + ex.getMessage());
        }
    }
}
