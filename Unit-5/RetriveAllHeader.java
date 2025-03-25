import java.net.*;
import java.util.*; 
// Import utilities for working with collections

public class RetriveAllHeader { 
    // Fixed class name spelling
    public static void main(String[] args) {
        try {
            //Creating a URI object
            URI uri = new URI("https://www.example.com");

            // Convert URI to URL (Incorrect type used previously)
            URL url = uri.toURL(); 
            // Fixed variable name and type

            // Open connection (Incorrect class used previously)
            URLConnection connection = url.openConnection(); 
            // Fixed typo (URIConnection -> URLConnection)

            // Retrieve header fields
            Map<String, List<String>> header = connection.getHeaderFields();

            // Iterate through the header fields
            for (Map.Entry<String, List<String>> entry : header.entrySet()) {
                String headerName = entry.getKey();
                List<String> headerValues = entry.getValue(); 
                // Fixed variable name typo

                if (headerName != null) { 
                    // Fixed syntax error (! = should be !=)
                    // Fixed incorrect syntax of String.join()
                    System.out.println(headerName + ": " + String.join(",", headerValues));
                } else {
                    System.out.println("Status: " + String.join(",", headerValues)); 
                    // Fixed typo (headerValue -> headerValues)
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); 
            // Print stack trace for debugging
        }
    }
}
