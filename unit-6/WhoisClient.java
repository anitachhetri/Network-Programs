import java.io.*;
import java.net.*;

public class WhoisClient







{
    private static final String WHOIS_SERVER = "whois.internic.net";
    private static final int WHOIS_PORT = 43;

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java WhoisClient <domain or IP>");
            return;
        }

        String query = args[0];

        try (Socket socket = new Socket(WHOIS_SERVER, WHOIS_PORT)) {
            // Output stream to send query
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            // Input stream to read response
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            // Send the query
            writer.println(query);

            // Read and print the response
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
