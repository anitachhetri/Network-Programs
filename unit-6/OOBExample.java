import java.io.*;
import java.net.*;


public class OOBExample{

public static void main(String[] args) {
    try{
        Socket socket = new Socket("example.com", 8000);
        //
        socket.setOOBInline(true);
        System.err.println("OOBININE enabled!");
        //
        socket.sendUrgentData(3);
        System.out.println("Urgent data sent!");
        socket.close();

    }
    catch (IOException e) {
        e.printStackTrace();
    }
    
}
}
