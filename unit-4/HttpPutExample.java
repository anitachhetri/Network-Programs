import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpPutExample {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/posts/1"); // Specify the resource ID to update
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("PUT");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");

            String jsonInputString = "{\"name\": \"John\", \"email\": \"john@example.com\", \"message\": \"Updated Message\"}";

            try (OutputStream os = connection.getOutputStream()) {
                os.write(jsonInputString.getBytes());
                os.flush();
            }

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK || responseCode == HttpURLConnection.HTTP_NO_CONTENT) {
                System.out.println("PUT request has been sent successfully");
            } else {
                System.out.println("PUT request failed with response code: " + responseCode);
            }

            connection.disconnect();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
