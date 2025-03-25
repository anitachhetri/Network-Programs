
import java.net.*;

public class ReconnetExample {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("www.yahoo.com", 80);

            //save the remote address
            SocketAddress yahooAddress = socket.getRemoteSocketAddress();
            System.out.println("Connected to " + yahooAddress);

            //Close the initial Condition
            socket.close();
            //Create a new socket and reconnected using the saved address
            Socket socket2 = new Socket();
            socket2.connect(yahooAddress);
            //Reconnected to yahoo using the saved address

            System.out.println("Reconnected to:" + yahooAddress);

            //Close the second Connection
            socket2.close();

        } catch (Exception e) {
            System.err.println("Error:" + e.getMessage());
        }
    }
}
