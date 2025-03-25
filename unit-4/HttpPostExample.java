import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpPostExample {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/posts");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");

            String jsonInputString = "{\"name\": \"John\", \"email\": \"john@example.com\", \"message\": \"Hello\"}";

            try (OutputStream os = connection.getOutputStream()) {
                os.write(jsonInputString.getBytes());
                os.flush();
            }

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_CREATED) {
                System.out.println("POST request has been sent successfully");
            } else {
                System.out.println("POST request failed with response code: " + responseCode);
            }

            connection.disconnect();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}