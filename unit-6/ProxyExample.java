import java.net.*;

public class ProxyExample {
    public static void main(String[] args) {
        try {
            // Create a socket address for the proxy server
            SocketAddress proxyAddress = new InetSocketAddress("myproxy.example.com", 1080);
            // Create a Proxy instance using SOCKS protocol
            Proxy proxy = new Proxy(Proxy.Type.SOCKS, proxyAddress);
            // Create a socket using the proxy
            Socket socket = new Socket(proxy);
            // Define the remote server address
            SocketAddress remoteAddress = new InetSocketAddress("login.ibiblio.org", 25);
            // Connect to the remote server through the proxy
            socket.connect(remoteAddress);
            System.out.println("Connected via proxy!");
            socket.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
