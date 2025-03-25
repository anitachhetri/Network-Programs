import java.io.IOException;
import java.net.*;

public class CheckifModified {
    public static void main(String[] args) {
        try {
            URI uri = new URI("https://www.example.com");
            URL url = uri.toURL();

            // Open a connection (cast to HttpURLConnection)
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the "If-Modified-Since" time to 24 hours ago
            long lastChecked = System.currentTimeMillis() - (24 * 60 * 60 * 1000); // 24 hours ago
            connection.setIfModifiedSince(lastChecked);

            // Get the value set
            System.out.println("IF-Modified-Since: " + connection.getIfModifiedSince());

            // Connect to the server
            connection.connect();

            // Get the last modified date of the resource
            long lastModified = connection.getLastModified();
            System.out.println("Last modified: " + lastModified);

            if (lastModified == 0) {
                System.out.println("The server did not provide a Last-Modified header.");
            } else if (lastModified > lastChecked) {
                System.out.println("The resource has been updated since the last check.");
            } else {
                System.out.println("The resource has not been modified since the last check.");
            }

            // Disconnect to free up resources
            connection.disconnect();

        } catch (URISyntaxException e) {
            System.err.println("Invalid URI: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
