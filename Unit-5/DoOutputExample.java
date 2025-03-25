import java.io.*;
import java.net.*;

public class DoOutputExample {
    public static void main(String[] args) {
        try {
            URI uri = new URI("http://www.example.com/submit");
            URL url = uri.toURL();

            // Open a connection to the URL
            URLConnection uc = url.openConnection();
            uc.setDoOutput(true); // Enable output mode

            // Send data to the server using OutputStream
            try (OutputStream outputStream = uc.getOutputStream();
                 PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream, "UTF-8"))) {
                writer.println("message=HelloServer&name=User123");
                writer.flush();
                System.out.println("Data sent successfully");
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
