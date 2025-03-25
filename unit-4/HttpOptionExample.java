import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;


public class HttpOptionExample {
    public static void main(String[] args) throws Exception {
        URI uri = new URI("http://httpbin.org/");
        URL url = uri.toURL();
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("OPTIONS");  // Changed from HEAD to OPTIONS

        int responseCode = conn.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        // Display allowed HTTP methods
        String allowedMethods = conn.getHeaderField("Allow");
       
            System.out.println("Allowed Methods: " + allowedMethods);
        

        
        
        
    }
}
