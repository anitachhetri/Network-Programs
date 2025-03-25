import java.net.*; // Import necessary networking classes

public class CachingExample {
    public static void main(String[] args) {
        try {
            // Creating a URI object
            URI uri = new URI("https://www.example.com");

            // Convert URI to URL (Incorrect type used previously)
            URL url = uri.toURL(); // Fixed type (URI -> URL)

            // Open connection (Incorrect declaration fixed)
            URLConnection connection = url.openConnection(); // Fixed type (URIConnection -> URLConnection)

            // Enable caching
            connection.setUseCaches(true);
            connection.connect();

            System.out.println("Caching Header:");

            // Print specific header fields
            printHeaderFields(connection, "Cache-Control");
            printHeaderFields(connection, "Cache-Control");
            printHeaderFields(connection, "Cache-Control");
            printHeaderFields(connection, "Cache-Control");

        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace for debugging
        }
    }

    // Corrected method signature and implementation
    private static void printHeaderFields(URLConnection connection, String field) {
        // Retrieve header value
        String value = connection.getHeaderField(field);
        if (value != null) {
            System.out.println(field + ": " + value);
        } else {
            System.out.println(field + ": Not found");
        }
    }
}
